package jvm.primitive.logics;

public class Memory { public static void main(String[] args) {

    String s1 = "SANJAI";
    String s2 = "SANJAI";
    String s3 = new String("SANJAI");

    System.out.println(s1 == s2); 
    System.out.println(s1 == s3); 

    System.out.println("s1 hash: " + System.identityHashCode(s1));
    System.out.println("s2 hash: " + System.identityHashCode(s2));
    System.out.println("s3 hash: " + System.identityHashCode(s3));
}
}