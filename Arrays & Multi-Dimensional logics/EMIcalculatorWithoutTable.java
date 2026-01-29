import java.util.Scanner;

public class EMIcalculatorWithoutTable {
        public  static  void main(String []args){
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the principle amount: ");
            double principle  = sc.nextDouble();

            System.out.print("Enter the Duration in months: ");
            int duration = sc.nextInt();

            System.out.print("Enter the number of rate of intrest: ");
            double rate = sc.nextDouble();

            double[][] tabel = new double[2][];

            tabel[0]= new double[2];
            tabel[1]= new double[duration];

            double simpleintrest = (principle*rate*duration)/100;
            double TotalAmount = simpleintrest+principle;
            tabel[0][0]=TotalAmount;
            tabel[0][1]=simpleintrest;

            double emi = TotalAmount / (duration);
            for(int i=0;i<tabel[1].length;i++){
                tabel[1][i]=emi;
            }
            System.out.println("Total Amount: "+ tabel[0][0]);
            System.out.println("Simple intrest: " +tabel[0][1]);

            for (int i=0;i<tabel[1].length;i++){
                System.out.println("Emi amount for month : "+(i+1)+" is "+tabel[1][i]);
            }
        }
    }

