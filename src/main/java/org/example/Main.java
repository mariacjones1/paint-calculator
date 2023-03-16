package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int costBracket = 0;
        double cost = 0;
        double costPerSquareMetre = 0;
        Scanner wallLength = new Scanner(System.in);
        Scanner wallHeight = new Scanner(System.in);
        Scanner paintColour = new Scanner(System.in);
        System.out.println("Enter the total wall length:");
        double inputLength = wallLength.nextDouble();
        System.out.println("Enter the total wall height:");
        double inputHeight = wallHeight.nextDouble();
        double wallArea = inputLength * inputHeight;
        System.out.println("Wall area: " + wallArea + "m2");
        System.out.println("Enter the paint colour (blue, pink or yellow):");
        String paint = paintColour.nextLine().toLowerCase();

        if (paint.equals("blue")) {
            costPerSquareMetre = 1.5;
        } else if (paint.equals("pink")) {
            costPerSquareMetre = 2;
        } else if (paint.equals("yellow")) {
            costPerSquareMetre = 2.5;
        } else {
            System.out.println("Invalid paint colour.");
        }

        if (wallArea < 50) {
            costBracket = 1;
        } else if (wallArea < 100) {
            costBracket = 2;
        }

        switch(costBracket) {
            case 1:
                cost = 125;
                break;
            case 2:
                cost = 250;
                break;
            default:
                cost = costPerSquareMetre * wallArea;
                break;
        }

        System.out.println("Total cost: £" + cost);
    }
}