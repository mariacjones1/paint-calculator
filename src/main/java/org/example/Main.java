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

        do {
            System.out.println("Enter the room to be painted (kitchen, bathroom or other):");
            String room = roomType.nextLine().toLowerCase();

            switch (room) {
                case "kitchen" -> costPerSquareMetre = 2f;
                case "bathroom" -> costPerSquareMetre = 2.5f;
                case "other" -> costPerSquareMetre = 1.5f;
                default -> System.out.println("Invalid room, please try again.");
            }
        } while (costPerSquareMetre == 0);


        int costBracket = wallArea < 50 ? 1 : 2;

        if (costBracket == 1) {
            cost = 125;
        } else {
            cost = costPerSquareMetre * wallArea;
        }

        System.out.println("Total cost: £" + cost);
        if (cost == 125) {
            System.out.println("(Minimum price)");
        }
    }
}