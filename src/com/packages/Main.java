package com.packages;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte monthsInYear = 12;
        final byte percent = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principalValue = scanner.nextInt();

        System.out.print("Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / percent / monthsInYear;

        System.out.print("Period (Years): ");
        byte periodValue = scanner.nextByte();
        int periodTotal = periodValue * monthsInYear;

        double mortgage = principalValue
                    * (monthlyInterest * Math.pow(1 + monthlyInterest, periodTotal))
                    / (Math.pow(1 + monthlyInterest, periodTotal) - 1);

        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println(formattedMortgage);
    }
}