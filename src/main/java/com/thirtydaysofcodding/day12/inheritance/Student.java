package com.thirtydaysofcodding.day12.inheritance;

public class Student extends Person {
    private int[] testScores;

    public Student(String firstName, String lastName, int id, int[] testScores) {
        super(firstName, lastName, id);
        this.testScores = testScores;
    }

    public char calculate() {
        int sumScores = 0;
        for (int testScore : testScores) {
            sumScores += testScore;
        }
        int avgScore = sumScores / testScores.length;
        if (avgScore < 40) {
            return 'T';
        } else if (avgScore < 55) {
            return 'D';
        } else if (avgScore < 70) {
            return 'P';
        } else if (avgScore < 80) {
            return 'A';
        } else if (avgScore < 90) {
            return 'E';
        } else {
            return 'O';
        }
    }
}
