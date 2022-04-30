package homework3.task2;

import java.util.Arrays;

/**
 * Utility class for finding the median of an array
 */

public class Median {

    /**
     * The median is the numeric value that divides the sorted array of numbers into half and half.
     * In a sorted array with an odd number of elements, the median is the number in the middle of the array.
     * For an array with an even number of elements, where there is no one element exactly in the middle,
     * the median is the average of the two numbers in the middle of the array.
     *
     * @param arr array of integer type.
     * @return the array's element of float type, which is an median.
     */

    public static float median(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        if (n % 2 == 0) {
            return ((float) arr[n / 2] + arr[n / 2 - 1]) / 2;
        } else {
            return (float) arr[n / 2];
        }
    }

    /**
     * The median is the numeric value that divides the sorted array of numbers into half and half.
     * In a sorted array with an odd number of elements, the median is the number in the middle of the array.
     * For an array with an even number of elements, where there is no one element exactly in the middle,
     * the median is the average of the two numbers in the middle of the array.
     *
     * @param arr array of double type.
     * @return the array's element of double type, which is an median.
     */

    public static double median(double[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        if (n % 2 == 0) {
            return (arr[n / 2] + arr[n / 2 - 1]) / 2;
        } else {
            return arr[n / 2];
        }
    }
}
