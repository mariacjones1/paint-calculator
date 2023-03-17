package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean moreRoomsToPaint = true;
        Scanner moreRooms = new Scanner(System.in);
        float totalCost = 0;

        do {
            totalCost = totalCost + costOfRoom();
            System.out.println("Do you have more rooms to paint? Y/N");
            String more = moreRooms.nextLine().toUpperCase();
            boolean validAnswer = false;
            do {
                if (more.equals("Y")) {
                    moreRoomsToPaint = true;
                    validAnswer = true;
                } else if (more.equals("N")) {
                    moreRoomsToPaint = false;
                    validAnswer = true;
                } else {
                    System.out.println("Invalid answer; please type 'Y' or 'N'.");
                    validAnswer = false;
                }
            } while (validAnswer == false);
        } while (moreRoomsToPaint == true);

        System.out.println("Total cost to paint all rooms: £" + totalCost);
    }

    public static float costOfRoom() {
        float cost;
        float costPerSquareMetre = 0;
        Scanner roomLength = new Scanner(System.in);
        Scanner roomWidth = new Scanner(System.in);
        Scanner roomHeight = new Scanner(System.in);
        Scanner removeArea = new Scanner(System.in);
        Scanner ceiling = new Scanner(System.in);
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

        System.out.println("Enter the room length:");
        float inputLength = roomLength.nextFloat();
        System.out.println("Enter the room width:");
        float inputWidth = roomWidth.nextFloat();
        System.out.println("Enter the room height:");
        float inputHeight = roomHeight.nextFloat();
        System.out.println("Please enter the total area of the windows and doors:");
        float windowsAndDoors = removeArea.nextFloat();
        System.out.println("Do you want to paint the ceiling? Y/N");
        String inputCeiling = ceiling.nextLine().toUpperCase();
        float ceilingArea = -1;
        do {
            if (inputCeiling.equals("Y")) {
                ceilingArea = inputLength * inputWidth;
            } else if (inputCeiling.equals("N")) {
                ceilingArea = 0;
            } else {
                System.out.println("Invalid answer; please type 'Y' or 'N'.");
            }
        } while (ceilingArea == -1);
        float wallArea = ((inputLength * 2) + (inputWidth * 2)) * inputHeight + ceilingArea - windowsAndDoors;
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

        return cost;
    }
}