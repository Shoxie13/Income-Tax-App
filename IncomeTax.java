/**********************************************
Workshop 2
Course: JAC444 - Semester 4
Last Name: Abdi
First Name: Tareq
ID: 123809196
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature - TA
Date: 11/02/2022
**********************************************/

package workshop2;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.Character;

public class IncomeTax {
    private static Scanner myObj;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    final static int SINGLE_FILER = 0;
    final static int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
    final static int MARRIED_SEPARATELY = 2;
    final static int HEAD_OF_HOUSEHOLD = 3;

    //number of incrementing the income tax for the tables
    final int numOfIncrement = 1000;

    //rates
    final double[] rate21 = { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
    final double[] rate11 = { 0.15, 0.275, 0.305, 0.355, 0.33, 0.391};

    //2011 tax intervals
    final int[][] single11 = { {0, 27050}, {27051, 65550}, {65551, 136750}, {136751, 297350}, {297351} };
    final int[][] mjqw11 = { {0, 45200}, {45201, 109250}, {109251, 166500}, {166501, 297350}, {297351} };
    final int[][] marriedSeparate11 = { {0, 22600}, {22601, 54625}, {54626, 83250}, {83251, 148675}, {148676} };
    final int[][] headOfHouse11 = { {0, 36250}, {36251, 93650}, {93651, 151650}, {151651, 297350}, {297351} };

    //2021 tax intervals
    final int[][] single21 = { {0, 8350}, {8351, 33950}, {33951, 82250}, {82251, 171550}, {171551, 372950}, {372951} };
    final int[][] mjqw21 = { {0, 16700}, {16701, 67900}, {67901, 137050}, {137051, 208850}, {208851, 372950}, {372951} };
    final int[][] marriedSeparate21 = { {0, 8350}, {8351, 33950}, {33951, 68525}, {68526, 104425}, {104426, 186475}, {186476} };
    final int[][] headOfHouse21 = { {0, 11950}, {11951, 45500}, {45501, 117450}, {117451, 190200}, {190201, 372950}, {372951} };

    private int[][] intervals;
    private double rates[];
    private double taxableIncome;
    private int filingStatus;

    //no arg constructor
    IncomeTax() {
        intervals = new int[0][0];
        rates= new double[0];
        taxableIncome = 0;
        filingStatus = 0;
    };
    
    //four arg constructor
    IncomeTax(int filingStatus, int intervals[][], double rates[], double taxableIncome) {
        setFilingStatus(filingStatus);
        setIntervals(intervals);
        setRates(rates);
        setTaxableIncome(taxableIncome);
    }

    //Get and set functions for Status
    public int getFilingStatus() {
        return filingStatus;
    };

    public void setFilingStatus(int status) {
        this.filingStatus = status;
    }

    //Get and set functions for Intervals
    public int[][] getIntervals() {
        return intervals;
    }

    public void setIntervals(int[][] intervals) {
        this.intervals = intervals;
    }

    //Get and set functions for Rates
    public double[] getRates() {
        return rates;
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    //Get and set functions for Taxable Income
    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    } 

    //Get taxt results for 2021
    public double getTaxResult21() {
        double tax = 0;
        
        if (taxableIncome > intervals[0][0] && taxableIncome <= intervals[0][1]) {
            tax = rates[0] * taxableIncome;
        }else if (taxableIncome > intervals[1][0] && taxableIncome <= intervals[1][1]) {
            tax = (rates[0] * intervals[0][1]) + (rates[1] * (taxableIncome - intervals[0][1]));
        }else if (taxableIncome > intervals[2][0] && taxableIncome <= intervals[2][1]) {
            tax = (rates[0] * intervals[0][1]) + (rates[1] * (intervals[1][1] - intervals[0][1])) + (rates[2] * (taxableIncome - intervals[1][1]));
        }else if (taxableIncome > intervals[3][0] && taxableIncome <= intervals[3][1]) {
            tax = (rates[0] * intervals[0][1]) + (rates[1] * (intervals[1][1] - intervals[0][1])) + (rates[2] * (intervals[2][1] - intervals[1][1])) + (rates[3] * (taxableIncome - intervals[2][1]));
        }else if (taxableIncome > intervals[4][0] && taxableIncome <= intervals[4][1]) {
            tax = (rates[0] * intervals[0][1]) + (rates[1] * (intervals[1][1] - intervals[0][1])) + (rates[2] * (intervals[2][1] - intervals[1][1])) + (rates[3] * (intervals[3][1] - intervals[2][1])) + (rates[4] * (taxableIncome - intervals[3][1]));
        }else if (taxableIncome > intervals[5][0]) {
            tax = (rates[0] * intervals[0][1]) + (rates[1] * (intervals[1][1] - intervals[0][1])) + (rates[2] * (intervals[2][1] - intervals[1][1])) + (rates[3] * (intervals[3][1] - intervals[2][1])) + (rates[4] * (intervals[4][1] - intervals[3][1])) + (rates[5] * (taxableIncome - intervals[4][1]));
        }

        return tax;
    }

    //Get taxt results for 2011
    public double getTaxResult11() {
        double tax = 0;

        if (taxableIncome > intervals[0][0] && taxableIncome <= intervals[0][1]) {
            tax = rates[0] * taxableIncome;
        }else if (taxableIncome > intervals[1][0] && taxableIncome <= intervals[1][1]) {
            tax = (rates[0] * intervals[0][1]) + (rates[1] * (taxableIncome - intervals[0][1]));
        }else if (taxableIncome > intervals[2][0] && taxableIncome <= intervals[2][1]) {
            tax = (rates[0] * intervals[0][1]) + (rates[1] * (intervals[1][1] - intervals[0][1])) + (rates[2] * (taxableIncome - intervals[1][1]));
        }else if (taxableIncome > intervals[3][0] && taxableIncome <= intervals[3][1]) {
            tax = (rates[0] * intervals[0][1]) + (rates[1] * (intervals[1][1] - intervals[0][1])) + (rates[2] * (intervals[2][1] - intervals[1][1])) + (rates[3] * (taxableIncome - intervals[2][1]));
        }

        return tax;
    }

    //Execute function to run the main program
    public void execute() {
        int status = 0;
        myObj = new Scanner(System.in);

        mainHeader();
        int option = numCheck(myObj.next(), 1, 3);

        switch (option) {
            case 1:
                //Table 2 2021 Tax Rates and Intevals
                typeOfFilers();
                status = numCheck(myObj.next(), 0, 3);

                System.out.print("Enter the Taxable Income: $");
                int taxable = numCheck(myObj.next());
 
                IncomeTax income21 = new IncomeTax(status, single21, rate21, taxable);

                statusCheck(status, income21);

                System.out.println();
                System.out.println("--------------------------------------");
                System.out.printf("Tax is: %s" + "%21s%n", df.format(income21.getTaxResult21()), "|" );
                showEnd();
                break;
            case 2:
                System.out.print("Enter the amount From: $");
                int incomeFrom = numCheck(myObj.next());
                int incomeFrom21 = incomeFrom;

                System.out.print("Enter the amount To: $");
                int incomeTo = numCheck(myObj.next());

                IncomeTax inc = new IncomeTax(status = 0, single11, rate11, incomeFrom);

                showHeader(incomeFrom, incomeTo, 2011);

                printInfo11(incomeFrom, incomeTo, inc, numOfIncrement);

                line();

                showHeader(incomeFrom21, incomeTo, 2021);

                inc.setRates(rate21);
                inc.setIntervals(single21);
                inc.setTaxableIncome(incomeFrom21);

                printInfo21(incomeFrom21, incomeTo, inc, numOfIncrement);

                line();

                showEnd();
                break;
            case 3:
                showEnd();
                break;
        }
    }

    // Checks for letters when only digits are expected
    int numCheck(String str) {
        myObj = new Scanner(System.in);

        for (int i = 0; i < str.length(); i++) {
            while(!Character.isDigit(str.charAt(i))) {
                System.out.print("Letter detected! Enter only digits: ");
                str = myObj.next();
            }
        }

        return Integer.parseInt(str);
    }

    // Oveloaded function 
    int numCheck(String str, int firstBound, int secondBound) {
        myObj = new Scanner(System.in);

        for (int i = 0; i < str.length(); i++) {
            while(!Character.isDigit(str.charAt(i)) || (Integer.parseInt(String.valueOf(str)) < firstBound || Integer.parseInt(String.valueOf(str)) > secondBound)) {
                System.out.print("Letter or out of bounds number detected! Enter only digits from 1 - 3: ");
                str = myObj.next();
            }
        }

        return Integer.parseInt(str);
    }

    //Ending for the program
    void showEnd() {
        System.out.println("--------------------------------------");
        System.out.println("Thank you for using our program, bye!|");
        System.out.println("--------------------------------------");
    }

    //Header for the two tax tables
    void showHeader(double incomeFrom, double incomeTo, int year) {
        System.out.println();
        System.out.println(year + " tax tables for taxable income from $" + incomeFrom + " to $" + incomeTo);
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("%s" + "%10s" + "%11s" + "%23s" + "%20s%n", "Taxable Income", "Single", "MJQW", "Married Separate", "Head of a House");
        System.out.println("----------------------------------------------------------------------------------");
    }

    //prints out a line
    void line() {
        System.out.println("----------------------------------------------------------------------------------");
    }

    //print info for 2011 table
    void printInfo11(double incomeFrom, double incomeTo, IncomeTax inc, int numOfIncrement) {
        while (incomeFrom <= incomeTo) {
            System.out.printf("%10s" + "%15s", incomeFrom, df.format(inc.getTaxResult11()));
            
            inc.setIntervals(mjqw11);
            System.out.printf("%12s", df.format(inc.getTaxResult11()));
            
            inc.setIntervals(marriedSeparate11);
            System.out.printf("%17s", df.format(inc.getTaxResult11()));

            inc.setIntervals(headOfHouse11);
            System.out.printf("%20s%n", df.format(inc.getTaxResult11()));

            incomeFrom += numOfIncrement;
            inc.setTaxableIncome(incomeFrom);
        }
    }

    //print info for 2021 table
    void printInfo21(double incomeFrom, double incomeTo, IncomeTax inc, int numOfIncrement) {
        while (incomeFrom <= incomeTo) {
            System.out.printf("%10s" + "%15s", incomeFrom, df.format(inc.getTaxResult11()));
            
            inc.setIntervals(mjqw11);
            System.out.printf("%12s", df.format(inc.getTaxResult11()));
            
            inc.setIntervals(marriedSeparate11);
            System.out.printf("%17s", df.format(inc.getTaxResult11()));

            inc.setIntervals(headOfHouse11);
            System.out.printf("%20s%n", df.format(inc.getTaxResult11()));

            incomeFrom += numOfIncrement;
            inc.setTaxableIncome(incomeFrom);
        }
    }

    //types of filers
    void typeOfFilers() {
        System.out.println("0. Single");
        System.out.println("1. Married Joint or Widow/er");
		System.out.println("2. Married Separately");
        System.out.println("3. Head of a Household");
        System.out.print("Enter the filing status: ");
    }

    //main header
    void mainHeader() {
        System.out.println("1. Compute Personal Income Tax");
        System.out.println("2. Print Tax Tables Within Range");
		System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    //checks the status and shows the selected the type of the filer
    void statusCheck(int status, IncomeTax income21) {
        if(status == SINGLE_FILER) {
            income21.setIntervals(single21);
        }else if (status == MARRIED_JOINTLY_OR_QUALIFYING_WIDOW) {
            income21.setIntervals(mjqw21);
        }else if (status == MARRIED_SEPARATELY) {
            income21.setIntervals(marriedSeparate21);
        }else if (status == HEAD_OF_HOUSEHOLD) {
            income21.setIntervals(headOfHouse21);
        }
    }
}