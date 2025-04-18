package com.pluralsight;

import java.util.Arrays;

public class TestScores {
    private int[] testScores;

    public TestScores() {
        this.testScores = new int[10];
    }

    public void setTestScores(int[] testScores) {
        if (testScores == null || testScores.length == 0) {
            throw new IllegalArgumentException("Scores cannot be null or empty.");
        }
        this.testScores = Arrays.copyOf(testScores, testScores.length);
    }

    private int[] sortScores() {
        Arrays.sort(this.testScores);
        return this.testScores;
    }

    public int getAvgScore() {
        if (this.testScores.length == 0) return 0;
        int sum = 0;
        for (int score : this.testScores) {
            sum += score;
        }
        double avg = (double) sum / (this.testScores.length);
        return (int) Math.round(avg);
    }

    public int getHighScore() {
        int[] sortedScores = sortScores();
        return sortedScores[sortedScores.length - 1];
    }

    public int getLowScore() {
        int[] sortedScores = sortScores();
        return sortedScores[0];
    }

    public int getMedianScore() {
        if (this.testScores.length == 0) return 0;
        int[] sortedScores = sortScores();
        if (sortedScores.length % 2 == 0) {
            int[] middleScores = {sortedScores[(sortedScores.length / 2) - 1], sortedScores[sortedScores.length / 2]};
            return (int) Math.round((middleScores[0] + middleScores[1]) / 2.0);
        } else {
            return sortedScores[sortedScores.length / 2];
        }
    }
}
