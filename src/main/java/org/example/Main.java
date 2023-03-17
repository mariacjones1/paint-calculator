package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double cost;
        double costPerSquareMetre = 0;
        Scanner wallLength = new Scanner(System.in);
        Scanner wallHeight = new Scanner(System.in);
        Scanner roomType = new Scanner(System.in);

        System.out.println("Enter the total wall length:");
        double inputLength = wallLength.nextDouble();
        System.out.println("Enter the total wall height:");
        double inputHeight = wallHeight.nextDouble();
        double wallArea = inputLength * inputHeight;
        System.out.println("Wall area: " + wallArea + "m2");

        do {
            System.out.println("Enter the room to be painted (kitchen, bathroom or other):");
            String room = roomType.nextLine().toLowerCase();

            switch (room) {
                case "kitchen" -> costPerSquareMetre = 2;
                case "bathroom" -> costPerSquareMetre = 2.5;
                case "other" -> costPerSquareMetre = 1.5;
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
    }
}