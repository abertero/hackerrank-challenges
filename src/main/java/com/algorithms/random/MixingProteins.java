package com.algorithms.random;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Some scientists are working on protein recombination, and during their research, they have found a remarkable fact: there are 4 proteins in the protein ring that mutate after every second according to a fixed pattern. For simplicity, proteins are called  (you know, protein names can be very complicated). A protein mutates into another one depending on itself and the protein right after it. Scientists determined that the mutation table goes like this:
 * <p>
 * A   B   C   D
 * _   _   _   _
 * A|  A   B   C   D
 * B|  B   A   D   C
 * C|  C   D   A   B
 * D|  D   C   B   A
 * Here rows denote the protein at current position, while columns denote the protein at the next position. And the corresponding value in the table denotes the new protein that will emerge. So for example, if protein i is A, and protein i + 1 is B, protein i will change to B. All mutations take place simultaneously. The protein ring is seen as a circular list, so last protein of the list mutates depending on the first protein.
 * <p>
 * Using this data, they have written a small simulation software to get mutations second by second. The problem is that the protein rings can be very long (up to 1 million proteins in a single ring) and they want to know the state of the ring after upto  seconds. Thus their software takes too long to report the results. They ask you for your help.
 * <p>
 * Input Format
 * Input contains 2 lines.
 * First line has 2 integers  and ,  being the length of the protein ring and  the desired number of seconds.
 * Second line contains a string of length  containing uppercase letters ,,  or  only, describing the ring.
 * <p>
 * Output Format
 * Output a single line with a string of length , describing the state of the ring after  seconds.
 * <p>
 * Constraints
 * <p>
 * <p>
 * Sample Input:
 * <p>
 * 5 15
 * AAAAD
 * Sample Output:
 * <p>
 * DDDDA
 * Explanation
 * The complete sequence of mutations is:
 * <p>
 * AAADD
 * AADAD
 * ADDDD
 * DAAAD
 * DAADA
 * DADDD
 * DDAAA
 * ADAAD
 * DDADD
 * ADDAA
 * DADAA
 * DDDAD
 * AADDA
 * ADADA
 * DDDDA
 * TODO: Incomplete
 */
public class MixingProteins {
    public static final char CHR_A = 'A';
    public static final char CHR_B = 'B';
    public static final char CHR_C = 'C';
    public static final char CHR_D = 'D';
    private static final char[][] TABLE = new char[][]{
            new char[]{CHR_A, CHR_B, CHR_C, CHR_D},
            new char[]{CHR_B, CHR_A, CHR_D, CHR_C},
            new char[]{CHR_C, CHR_D, CHR_A, CHR_B},
            new char[]{CHR_D, CHR_C, CHR_B, CHR_A}
    };

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int times = scn.nextInt();
        scn.nextLine();
        String seq = scn.nextLine();
        scn.close();
        System.out.println(mutateNTimes(seq, times));
    }

    public static int getIndex(final char str) {
        switch (str) {
            case CHR_A:
                return 0;
            case CHR_B:
                return 1;
            case CHR_C:
                return 2;
            case CHR_D:
                return 3;
            default:
                return -1;
        }
    }

    public static char getMutation(final char src, final char nxt) {
        return TABLE[getIndex(src)][getIndex(nxt)];
    }

    public static String mutate(final String src) {
        String res = "";
        int length = src.length();
        for (int i = 0; i < length; i++) {
            char curr = src.charAt(i);
            char nxt = src.charAt((i + 1) % length);
            char mut = getMutation(curr, nxt);
            res += mut;
        }
        return res;
    }

    public static String mutateNTimes(final String src, final int times) {
        Map<Integer, String> mutations = new HashMap<>();
        String mut = src;
        int n = 0;
        while (!mutations.containsValue(mut) && n < times) {
            mutations.put(n, src);
            mut = mutate(mut);
            ++n;
        }
        if (n < times) {
            return mutations.get((times - n) % n);
        } else {
            return mut;
        }
    }
}
