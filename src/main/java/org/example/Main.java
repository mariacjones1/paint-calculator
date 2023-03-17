package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float cost;
        float costPerSquareMetre = 0;
        Scanner wallLength = new Scanner(System.in);
        Scanner wallHeight = new Scanner(System.in);
        Scanner roomType = new Scanner(System.in);

        List<String> paintColours = new ArrayList<>();
        paintColours.add("pink");
        paintColours.add("blue");
        paintColours.add("yellow");
        paintColours.add("green");

        Scanner chosenPaintColour = new Scanner(System.in);
        System.out.println("Please choose your paint colour from the following selection, or choose your own colour for 50% more:");
        for (int i = 0; i < paintColours.size(); i++) {
            System.out.println("Paint #" + (i+1) + ": " + paintColours.get(i));
        }
        String colour;
        float multiplier;
        colour = chosenPaintColour.nextLine();
        if (paintColours.contains(colour)) {
            multiplier = 1;
        } else {
            multiplier = 1.5f;
        }

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

        String roomToPaint;
        if (room.equals("other")) {
            roomToPaint = "room";
        } else {
            roomToPaint = room;
        }

        int costBracket;
        if (wallArea < 100) {
            costBracket = 1;
            if (room.equals("kitchen")) {
                cost = 200 * multiplier;
            } else if (room.equals("bathroom")) {
                cost = 250 * multiplier;
            } else {
                cost = 150 * multiplier;
            }
        } else {
            costBracket = 2;
            cost = wallArea * costPerSquareMetre * multiplier;
        }

        String explanation = costBracket == 1 ? "(Minimum price)" : "(Calculated price)";
        System.out.println("Total cost to paint your " + roomToPaint + " " + colour + ": £" + cost + "\n" + explanation);
    }
}