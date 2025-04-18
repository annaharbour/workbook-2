package com.pluralsight;

public class RollTheDice {
    public static void main(String[] args) {
        Dice dice = new Dice();

        int twosCount = 0;
        int foursCount = 0;
        int sixCount = 0;
        int sevensCount = 0;

        for(int i=1; i <= 100; i++){
            int roll1 = dice.roll();
            int roll2 = dice.roll();
            System.out.printf("Roll #%d: %d - %d Sum : %d\n", i, roll1, roll2, roll1 + roll2);
            switch(roll1 + roll2){
                case 2:
                    twosCount++;
                    break;
                case 4:
                    foursCount++;
                    break;
                case 6:
                    sixCount++;
                    break;
                case 7:
                    sevensCount++;
                    break;
                default:
                    break;
            }
        }
        System.out.printf("2: %d\n4: %d\n6: %d\n7: %d\n", twosCount, foursCount, sixCount, sevensCount);
    }
}
