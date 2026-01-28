public class VarArgs {
  
    static void num(int... a)
    {
        System.out.println("Number of arguments: " + a.length);
        
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }
    public static void main(String args[])
    {
        num(100);

        num(1, 2, 3, 4);

        num();
    }
}