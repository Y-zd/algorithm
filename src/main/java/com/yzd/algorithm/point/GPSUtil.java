package com.yzd.algorithm.point;


import java.math.BigDecimal;

/**
 * @Date 2017/2/6 17:51
 * @Description [GPSUTIL 类，准确]
 */
public final class GPSUtil {

    private static final double pi = 3.1415926535897932384626;

    private static final double x_pi = 3.14159265358979324 * 3000.000 / 180.000;

    private static final double a = 6378245.000;

    private static final double ee = 0.00669342162296594323;

    private GPSUtil() {
    }

    public static double transformLat(double x, double y) {
        double ret = -100.000 + 2.000 * x + 3.000 * y + 0.200 * y * y + 0.100 * x * y
                + 0.2000 * Math.sqrt(Math.abs(x));
        ret += (20.000 * Math.sin(6.000 * x * pi) + 20.000 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
        ret += (20.000 * Math.sin(y * pi) + 40.000 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
        ret += (160.000 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
        return ret;
    }

    public static double transformLon(double x, double y) {
        double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1
                * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0
                * pi)) * 2.0 / 3.0;
        return ret;
    }

    public static double[] transform(double lat, double lon) {
        if (outOfChina(lat, lon)) {
            return new double[]{lat, lon};
        }
        double dLat = transformLat(lon - 105.0, lat - 35.0);
        double dLon = transformLon(lon - 105.0, lat - 35.0);
        double radLat = lat / 180.0 * pi;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
        double mgLat = lat + dLat;
        double mgLon = lon + dLon;
        return new double[]{mgLat, mgLon};
    }

    public static boolean outOfChina(double lat, double lon) {
        if (lon < 72.004 || lon > 137.8347)
            return true;
        return lat < 0.8293 || lat > 55.8271;
    }

    /**
     * 84 to 火星坐标系 (GCJ-02) World Geodetic System ==> Mars Geodetic System
     *
     * @param lat
     * @param lon
     * @return
     */
    public static double[] gps84_To_Gcj02(double lat, double lon) {
        if (outOfChina(lat, lon)) {
            return new double[]{lat, lon};
        }
        double dLat = transformLat(lon - 105.0, lat - 35.0);
        double dLon = transformLon(lon - 105.0, lat - 35.0);
        double radLat = lat / 180.0 * pi;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
        double mgLat = lat + dLat;
        double mgLon = lon + dLon;
        return new double[]{mgLat, mgLon};
    }

    /**
     * 84 转百度
     *
     * @param lat
     * @param lon
     * @return
     */
    public static double[] wgs84_bd09(double lat, double lon) {
        // ,将84转国测局gcj-02
        if (outOfChina(lat, lon)) {
            return new double[]{lat, lon};
        }
        double dLat = transformLat(lon - 105.0, lat - 35.0);
        double dLon = transformLon(lon - 105.0, lat - 35.0);
        double radLat = lat / 180.0 * pi;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
        double latGCJ = lat + dLat;
        double lonGCJ = lon + dLon;

        double x = lonGCJ, y = latGCJ;

        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        double bd_lon = z * Math.cos(theta) + 0.0065;
        double bd_lat = z * Math.sin(theta) + 0.006;
        // .将gcj-02转百度
        return new double[]{bd_lat, bd_lon};
    }

    /**
     * * 火星坐标系 (GCJ-02) to 84 * * @param lon * @param lat * @return
     */
    public static double[] gcj02_To_Gps84(double lat, double lon) {
        double[] gps = transform(lat, lon);
        double lontitude = lon * 2 - gps[1];
        double latitude = lat * 2 - gps[0];
        return new double[]{latitude, lontitude};
    }

    /**
     * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 将 GCJ-02 坐标转换成 BD-09 坐标 高德转百度（国内坐标）
     *
     * @param point
     */
    public static Point gaode2Baidu(Point point) {
        double x = point.getLng(), y = point.getLat();
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        double tempLon = z * Math.cos(theta) + 0.0065;
        double tempLat = z * Math.sin(theta) + 0.006;
        point.setLat(tempLat);
        point.setLng(tempLon);
        return point;
    }

    /**
     * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法
     * <p>
     * 将 BD-09 坐标转换成GCJ-02 坐标 *
     */
    public static double[] bd09_To_Gcj02(double lat, double lon) {
        double x = lon - 0.0065, y = lat - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
        double tempLon = z * Math.cos(theta);
        double tempLat = z * Math.sin(theta);
        BigDecimal b = BigDecimal.valueOf(tempLon);
        tempLon = b.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
        BigDecimal d = BigDecimal.valueOf(tempLat);
        tempLat = d.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();

        return new double[]{tempLat, tempLon};
    }

    /**
     * 将gps84转为bd09
     *
     * @param lat
     * @param lon
     * @return
     */
    public static double[] gps84_To_bd09(double lat, double lon) {
        double[] gcj02 = gps84_To_Gcj02(lat, lon);

        return gcj02_To_Bd09(gcj02[0], gcj02[1]);
    }

    /**
     * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 将 GCJ-02 坐标转换成 BD-09 坐标 高德转百度（国内坐标）
     *
     * @param lat
     * @param lon
     */
    public static double[] gcj02_To_Bd09(double lat, double lon) {
        double x = lon, y = lat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        double tempLon = z * Math.cos(theta) + 0.0065;
        double tempLat = z * Math.sin(theta) + 0.006;

        return new double[]{tempLat, tempLon};
    }

    public static double[] bd09_To_gps84(double lat, double lon) {
        double[] gcj02 = bd09_To_Gcj02(lat, lon);
        double[] gps84 = gcj02_To_Gps84(gcj02[0], gcj02[1]);
        // 留小数点后六位
        gps84[0] = retain6(gps84[0]);
        gps84[1] = retain6(gps84[1]);
        return gps84;
    }

    /**
     * 保留小数点后六位
     *
     * @param num
     * @return
     */
    private static double retain6(double num) {
        String result = String.format("%.6f", num);
        return Double.valueOf(result);
    }

    /**
     * 建议使用该方法最准确几乎没有误差
     *
     * @param bd_lon
     * @param bd_lat
     * @return
     */
    public static double[] bdToGaoDe(double bd_lon, double bd_lat) {
        double[] gd_lat_lon = new double[2];
        double PI = 3.14159265358979324 * 3000.0 / 180.0;
        double x = bd_lon - 0.0065, y = bd_lat - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * PI);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * PI);
        gd_lat_lon[0] = retain6(z * Math.cos(theta));
        gd_lat_lon[1] = retain6(z * Math.sin(theta));
        return gd_lat_lon;
    }

    /**
     * 建议使用该方法最准确几乎没有误差
     *
     * @param point
     * @return
     */
    public static Point baidu2Gaode(Point point) {
        double PI = 3.14159265358979324 * 3000.0 / 180.0;
        double x = point.getLng() - 0.0065, y = point.getLat() - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * PI);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * PI);
        point.setLng(retain6(z * Math.cos(theta)));
        point.setLat(retain6(z * Math.sin(theta)));
        return point;
    }

    /**
     * 百度坐标区域点转换成高德坐标区域点
     *
     * @param polygonPoints
     * @return
     */
    public static String BaiduPoints2Gaode(String polygonPoints) {
        String[] points = polygonPoints.split("\\|");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < points.length; i++) {
            Point point = new Point();
            point.setLng(Double.parseDouble(points[i].split(",")[0]));
            point.setLat(Double.parseDouble(points[i].split(",")[1]));
            point = baidu2Gaode(point);
            sb.append(point.getLng());
            sb.append(",");
            sb.append(point.getLat());
            sb.append("|");
        }
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * 高德坐标区域点转换成百度坐标区域点
     *
     * @param polygonPoints
     * @return
     */
    public static String GaodePoints2Baidu(String polygonPoints) {
        String[] points = polygonPoints.split("\\|");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < points.length; i++) {
            Point point = new Point();
            point.setLng(Double.parseDouble(points[i].split(",")[0]));
            point.setLat(Double.parseDouble(points[i].split(",")[1]));
            point = gaode2Baidu(point);
            sb.append(point.getLng());
            sb.append(",");
            sb.append(point.getLat());
            sb.append("|");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        Point p = new Point(116.401394,39.915378);

        Point point = baidu2Gaode(p);

        System.out.println(point);
    }

}
