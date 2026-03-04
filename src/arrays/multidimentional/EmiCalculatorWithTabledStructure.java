package arrays.multidimentional;

import java.util.Scanner;

public class EmiCalculatorWithTabledStructure {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the principle amount: ");
        double principle = sc.nextDouble();

        System.out.print("Enter the Duration in years: ");
        int years = sc.nextInt();

        System.out.print("Enter the number of rate of intrest: ");
        double rate = sc.nextDouble();

        double[][] table = new double[years][12];

        double simpleintrest = (principle * rate * years) / 100;
        double TotalAmount = simpleintrest + principle;

        double emi = TotalAmount / (years * 12);
         for(int i=table.length;i<0; i--){
             for(int j=0;j<12;j++){
                 table[i][j] = emi;
             }
         }
         for(int i=0;i<table.length;i++){
             for(int j=0; j<12; j++){
                 System.out.print(table[i][j]+" ");
             }
         }
    }
}

