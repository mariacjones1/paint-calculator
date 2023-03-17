package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float cost;
        float costPerSquareMetre = 0;
        Scanner wallLength = new Scanner(System.in);
        Scanner wallHeight = new Scanner(System.in);
        Scanner roomType = new Scanner(System.in);

        System.out.println("Enter the total wall length:");
        float inputLength = wallLength.nextFloat();
        System.out.println("Enter the total wall height:");
        float inputHeight = wallHeight.nextFloat();
        float wallArea = inputLength * inputHeight;
        System.out.println("Wall area: " + wallArea + "m2");

        String room;
        do {
            System.out.println("Enter the room to be painted (kitchen, bathroom or other):");
            room = roomType.nextLine().toLowerCase();

            switch (room) {
                case "kitchen" -> costPerSquareMetre = 2f;
                case "bathroom" -> costPerSquareMetre = 2.5f;
                case "other" -> costPerSquareMetre = 1.5f;
                default -> System.out.println("Invalid room, please try again.");
            }
        } while (costPerSquareMetre == 0);

        int costBracket;
        if (wallArea < 50) {
            costBracket = 1;
            if (room == "kitchen") {
                cost = 100;
            } else if (room == "bathroom") {
                cost = 125;
            } else {
                cost = 75;
            }
        } else {
            costBracket = 2;
            cost = wallArea + costPerSquareMetre;
        }

        String explanation = costBracket == 1 ? "(Minimum price)" : "(Calculated price)";
        System.out.println("Total cost: £" + cost + "\n" + explanation);
    }
}