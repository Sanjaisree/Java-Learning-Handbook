package enums.complexstates;

import java.util.Scanner;

enum Operation{
    ADD{
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    SUBTRACT{
        @Override
        double apply( double x, double y){
            return x - y;
        }
    },
    MULTIPLY{
        @Override
                double apply(double x,double y){
            return x*y;
        }
    },
    DIVISION{
        @Override
                double apply (double x, double y){
            return x/y;
        }
    };
    abstract double apply(double x, double y);
}

public class Operations {
    public static void main(String[] args) {
        //Operation opr1= Operation.ADD;
        //Operation opr2=Operation.SUBTRACT;
        //Operation opr3=Operation.MULTIPLY;

        //System.out.println(opr1.apply(5,10));
        //System.out.println(opr2.apply(10,5));
        //System.out.println(opr3.apply(5,10));
        Scanner sc = new Scanner(System.in);
        System.out.print("choose ADD, SUBTRACT, MULTIPLY, DIVISION(type it): ");
        String choice = sc.nextLine().toUpperCase();
        System.out.print("enter num 1: ");
        int num1 = sc.nextInt();
        System.out.print("enter num 2: ");
        int num2 = sc.nextInt();

        Operation opr1=Operation.valueOf(choice);
        double results=opr1.apply(num1,num2);
        System.out.println("the result is "+results);
    }
}
