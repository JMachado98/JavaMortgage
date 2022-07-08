package com.packages;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte monthsInYear = 12;
        final byte percent = 100;

        Scanner scanner = new Scanner(System.in);

        int principalValue;
        while (true) {
            System.out.print("Principal ($1k - $1M): ");
            principalValue = scanner.nextInt();
            if (principalValue <= 1_000_000 && principalValue >= 1000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        float monthlyInterest;
        while (true) {
            System.out.print("Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            monthlyInterest = annualInterest / percent / monthsInYear;
            if (annualInterest > 0 && annualInterest <= 30)
                break;
            System.out.println("Enter a value greater than 0 and up to 30.");
        }


        int periodTotal;
        byte periodValue;
        while (true) {
            System.out.print("Period (Years): ");
            periodValue = scanner.nextByte();
            periodTotal = periodValue * monthsInYear;
            if (periodValue <= 30 && periodValue >= 1)
                break;
            System.out.println("Enter a value between 1 and 30.");
        }

        double mortgage = principalValue
                * (monthlyInterest * Math.pow(1 + monthlyInterest, periodTotal))
                / (Math.pow(1 + monthlyInterest, periodTotal) - 1);

        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println(formattedMortgage);
    }
}