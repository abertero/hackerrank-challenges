package com.algorithms.random;

import java.util.Scanner;

/**
 * Calvin is driving his favorite vehicle on the 101 freeway. He notices that the check engine light of his vehicle is on, and he wants to service it immediately to avoid any risks. Luckily, a service lane runs parallel to the highway. The length of the service lane is  units. The service lane consists of  segments of equal length and different width.
 * <p/>
 * Calvin can enter to and exit from any segment. Let's call the entry segment as index  and the exit segment as index . Assume that the exit segment lies after the entry segment () and . Calvin has to pass through all segments from index  to index  (both inclusive).
 * <p/>
 * Paradise Highway
 * <p/>
 * Calvin has three types of vehicles - bike, car, and truck - represented by ,  and , respectively. These numbers also denote the width of the vehicle.
 * <p/>
 * You are given an array  of length , where  represents the width of the th segment of the service lane. It is guaranteed that while servicing he can pass through at most  segments, including the entry and exit segments.
 * <p/>
 * If , only the bike can pass through the th segment.
 * If , the bike and the car can pass through the th segment.
 * If , all three vehicles can pass through the th segment.
 * Given the entry and exit point of Calvin's vehicle in the service lane, output the type of the largest vehicle which can pass through the service lane (including the entry and exit segments).
 * <p/>
 * Input Format
 * <p/>
 * The first line of input contains two integers,  and , where  denotes the length of the freeway and  the number of test cases. The next line has  space-separated integers which represent the  array.
 * <p/>
 * test cases follow. Each test case contains two integers,  and , where  is the index of the segment through which Calvin enters the service lane and  is the index of the lane segment through which he exits.
 * <p/>
 * Constraints
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * Output Format
 * <p/>
 * For each test case, print the number that represents the largest vehicle type that can pass through the service lane.
 * <p/>
 * Note: Calvin has to pass through all segments from index  to index  (both inclusive).
 * <p/>
 * Sample Input
 * <p/>
 * 8 5
 * 2 3 1 2 3 2 3 3
 * 0 3
 * 4 6
 * 6 7
 * 3 5
 * 0 7
 * Sample Output
 * <p/>
 * 1
 * 2
 * 3
 * 2
 * 1
 * Explanation
 * <p/>
 * Below is the representation of the lane:
 * <p/>
 * |HIGHWAY|Lane|    ->    Width
 * <p/>
 * 0: |       |--|            2
 * 1: |       |---|           3
 * 2: |       |-|             1
 * 3: |       |--|            2
 * 4: |       |---|           3
 * 5: |       |--|            2
 * 6: |       |---|           3
 * 7: |       |---|           3
 * (0, 3): Because width[2] = 1, only the bike can pass through it.
 * (4, 6): Here the largest allowed vehicle which can pass through the 5th segment is the car and for the 4th and 6th segment it's the truck. Hence the largest vehicle allowed in these segments is a car.
 * (6, 7): In this example, the vehicle enters at the 6th segment and exits at the 7th segment. Both segments allow even trucks to pass through them. Hence the answer is 3.
 * (3, 5): width[3] = width[5] = 2. While the 4th segment allows the truck, the 3rd and 5th allow up to a car. So 2 will be the answer here.
 * (0, 7): The bike is the only vehicle which can pass through the 2nd segment, which limits the strength of the whole lane to 1.
 */
public class ServiceLane {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int width[] = new int[n];
        for (int width_i = 0; width_i < n; width_i++) {
            width[width_i] = in.nextInt();
        }
        for (int a0 = 0; a0 < t; a0++) {
            int i = in.nextInt();
            int j = in.nextInt();
            System.out.println(checkServiceMazSize(width, i, j));
        }
    }

    private static int checkServiceMazSize(int[] width, int i, int j) {
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            if (width[k] < min) {
                min = width[k];
            }
        }
        return min;
    }

}
