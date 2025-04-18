package com.pluralsight;

public class TestStatisticsApp {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        TestScores scores = new TestScores();
        scores.setTestScores(new int[]{34, 67, 78, 89, 99, 100, 77, 88, 90, 100});
        int avgScore = scores.getAvgScore();
        int highScore = scores.getHighScore();
        int lowScore = scores.getLowScore();
        int medianScore = scores.getMedianScore();

        System.out.printf("Average score:  %d\nHigh score:  %d\nLow score:  %d\nMedian score:  %d\n", avgScore,
                highScore, lowScore, medianScore);
    }

}
