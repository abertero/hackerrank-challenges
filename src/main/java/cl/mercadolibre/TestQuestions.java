package cl.mercadolibre;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thesc on 28-01-2017.
 */
public class TestQuestions {

    public static void main(String[] args) {
        stairCase(10);
        summation(new int[]{1, 2, 3, 4, 5});
        fizzBuzz(15);
        printArray(cutSticks(new int[]{5,4,4,2,2,8}));
        printArray(cutSticks(new int[]{1,2,3,4,3,3,2,1}));
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void stairCase(int n) {
        for (int i = 1; i <= n; ++i) {
            System.out.println(String.format("%s%s", multiplyChar(n - i, " "), multiplyChar(i, "#")));
        }
    }

    private static String multiplyChar(int numberOfTimes, String character) {
        return new String(new char[numberOfTimes]).replace("\0", character);
    }


    static int summation(int[] numbers) {
        if (numbers == null) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < numbers.length; ++i) {
            res += numbers[i];
        }
        return res;
    }

    static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            String res = "";
            if (i % 3 == 0) {
                res = "Fizz";
            }
            if (i % 5 == 0) {
                res += "Buzz";
            }
            if (res.isEmpty()) {
                System.out.println(i);
            } else {
                System.out.println(res);
            }
        }
    }

    static int[] cutSticks(int[] lengths) {
        List<Integer> list = new ArrayList<>();
        while (stillUncutted(lengths)) {
            int minStick = findMinStick(lengths);
            int counter = 0;
            for (int i = 0; i < lengths.length; i++) {
                if (lengths[i] > 0) {
                    ++counter;
                    lengths[i] = Math.max(lengths[i] - minStick, 0);
                }
            }
            list.add(counter);
        }

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    static boolean stillUncutted(int[] lengths) {
        for (int i = 0; i < lengths.length; i++) {
            if (lengths[i] > 0) {
                return true;
            }
        }
        return false;
    }

    static int findMinStick(int[] lengths) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lengths.length; i++) {
            if (lengths[i] > 0 && lengths[i] < min) {
                min = lengths[i];
            }
        }
        return min;
    }
}
