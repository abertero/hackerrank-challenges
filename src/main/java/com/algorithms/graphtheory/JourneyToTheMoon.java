package com.algorithms.graphtheory;

import java.util.*;

public class JourneyToTheMoon {

    public static void main(String[] args) {
        Map<Long, Set<Long>> sameCountryMap = new HashMap<>();
        Set<String> sameCountry = new HashSet<>();
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        int p = scn.nextInt();
        for (int i = 0; i < p; i++) {
            long a = scn.nextLong();
            long b = scn.nextLong();
            addSameCountry(sameCountry, sameCountryMap, a, b);
        }
        System.out.println(sumOf(n - 1) - sameCountry.size());
        scn.close();
    }

    private static boolean addSameCountry(Set<String> sameCountry, Map<Long, Set<Long>> sameCountryMap, long a, long b) {
        String toDelete;
        if (a > b) {
            toDelete = String.format("%s#%s", b, a);
        } else {
            toDelete = String.format("%s#%s", a, b);
        }
        boolean added = sameCountry.add(toDelete);
        if (added) {
            addToMap(sameCountry, sameCountryMap, a, b);
        }
        return added;
    }

    private static void addToMap(Set<String> sameCountry, Map<Long, Set<Long>> sameCountryMap, long a, long b) {
        if (sameCountryMap.get(a) == null) {
            sameCountryMap.put(a, new HashSet<Long>());
        }
        if (sameCountryMap.get(b) == null) {
            sameCountryMap.put(b, new HashSet<Long>());
        }

        List<Long> auxList = new ArrayList<>(sameCountryMap.get(a));
        for (Long intg : auxList) {
            addSameCountry(sameCountry, sameCountryMap, intg, b);
        }
        auxList = new ArrayList<>(sameCountryMap.get(b));
        for (Long intg : auxList) {
            addSameCountry(sameCountry, sameCountryMap, intg, a);
        }

        sameCountryMap.get(a).add(b);
        sameCountryMap.get(b).add(a);
    }

    private static long sumOf(long n) {
        return n * (n + 1) / 2;
    }
}
