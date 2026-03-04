package jvm.primitive.logics;

public class Memory { public static void main(String[] args) {

    String s1 = "SANJAI";
    String s2= s1.concat("SANJ");
    System.out.println(s2);
    System.out.println(s1);
    String s3 = new String("SANJAI");

    int a=10;
    int b=10;
    System.out.println(a==b);
    //.out.println(s1 == s2);
    System.out.println(s1 == s3);
    System.out.println (s1.equals(s3));

    System.out.println("s1 hash: " + System.identityHashCode(s1));
    //System.out.println("s2 hash: " + System.identityHashCode(s2));
    System.out.println("s3 hash: " + System.identityHashCode(s3));
}
}