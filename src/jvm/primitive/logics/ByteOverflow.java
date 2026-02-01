package jvm.primitive.logics;

public class ByteOverflow {
    public static void main(String[] args) {
		 byte b = 127;

	        for (int i = 0; i < 5; i++) {
	            b++;
	            System.out.println(b);

	}

}
}
