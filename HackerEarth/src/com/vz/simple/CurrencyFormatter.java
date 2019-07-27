package com.vz.simple;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CurrencyFormatter {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        NumberFormat usformat = NumberFormat.getCurrencyInstance(Locale.US);
        String us = usformat.format(payment);


        NumberFormat chinaformat = NumberFormat.getCurrencyInstance(Locale.CHINA);

        String china = chinaformat.format(payment);
        NumberFormat franceformat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = franceformat.format(payment);



        NumberFormat indiaformat = NumberFormat.getCurrencyInstance();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setCurrencySymbol("Rs.");
        symbols.setMonetaryDecimalSeparator('.');
        symbols.setGroupingSeparator(',');

        ((DecimalFormat)indiaformat).setDecimalFormatSymbols(symbols);
        String india = indiaformat.format(payment);


        // Write your code here.

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}

