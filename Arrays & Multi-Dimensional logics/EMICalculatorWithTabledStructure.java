import java.util.Scanner;

public class EMICalculatorWithTabledStructure {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the principle amount: ");
            double principle  = sc.nextDouble();

            System.out.print("Enter the Duration in years: ");
            int years = sc.nextInt();

            System.out.print("Enter the number of rate of intrest: ");
            double rate = sc.nextDouble();

            double[][] table = new double[years][12];

            double simpleintrest = (principle*rate*years)/100;
            double TotalAmount = simpleintrest+principle;

            double emi = TotalAmount/(years*12);
            for(int i=0;i<years;i++){
                for(int j=0;j<12;j++){
                    table[i][j]=emi;
                }
            }
            for (int i = 0; i < years; i++) {
                System.out.printf( "Year %d: ", i + 1);
                for (int j = 0; j < 12; j++) {
                    System.out.printf("M%d-%.2f ",j+1,table[i][j]);
                }
                System.out.println();
            }
        }
}

