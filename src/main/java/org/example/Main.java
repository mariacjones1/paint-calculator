package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double costPerSquareMetre = 1.5;
        Scanner wallLength = new Scanner(System.in);
        Scanner wallHeight = new Scanner(System.in);
        System.out.println("Enter the total wall length:");
        double inputLength = wallLength.nextDouble();
        System.out.println("Enter the total wall height:");
        double inputHeight = wallHeight.nextDouble();
        double wallArea = inputLength * inputHeight;
        System.out.println("Wall area: " + wallArea + "m2");
        double totalCost = costPerSquareMetre * wallArea;
        System.out.println("Total cost: £" + totalCost);
    }
}