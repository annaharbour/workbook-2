package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter a game score: ");
        Scanner scanner = new Scanner(System.in);
        String score = scanner.nextLine();
        String[] scoreArr = score.split("[|:]");
        String firstTeam = scoreArr[0];
        String secondTeam = scoreArr[1];
        int firstTeamScore = Integer.parseInt(scoreArr[2]);
        int secondTeamScore = Integer.parseInt(scoreArr[3]);
        String winner;
        if (firstTeamScore > secondTeamScore) {
            winner = firstTeam;
        } else if (secondTeamScore > firstTeamScore){
            winner = secondTeam;
        } else {
            winner = "Tie!";
        }
        System.out.println("Winner: " + winner);
    }
}


//- one split will be on the pipe ( | )
//- one split will be on the colon ( : )
//
// ---
//Please enter a game score: Home:Visitor|21:9↵
//
//Winner: Home
