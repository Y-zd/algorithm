package com.yzd.algorithm.sort;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/***
 *
 * @author : yanzhidong
 * @date : 2020/4/23 
 * @version : V1.0
 *
 */
public class ArrayUtil {

    public static int[] generate(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }

    public static void print(int[] array) {
        String string = Arrays.stream(array).boxed().map(Object::toString).collect(Collectors.joining(","));
        System.out.println(string);
    }

}
