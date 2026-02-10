package collections.perfomance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListAddTest {
    public static void main(String[] args) {
        int n = 1000000;

        List<Integer> Arraylist=new ArrayList<>();
        long start=System.nanoTime();
        for(int i=0;i<n;i++){ //add at the end
            Arraylist.add(i);
        }
        long end=System.nanoTime();
        System.out.println("arraylist add at end time :"+(end-start));

        start = System.nanoTime();
        Arraylist.add(0,-1);
        end = System.nanoTime();
        System.out.println("arraylist add at start time :"+(end-start));

        start = System.nanoTime();
        Arraylist.add(Arraylist.size()/2,-2);
        end = System.nanoTime();
        System.out.println("arraylist add at middle time :"+(end-start));

        //linked list
        List<Integer>Linkedlist=new LinkedList<>();
        start=System.nanoTime();
        for(int i=0;i<n;i++){
            Linkedlist.add(i);
        }
        end=System.nanoTime();
        System.out.println("Linkedlist add at end time :"+(end-start));

        start = System.nanoTime();
        Linkedlist.add(0,-1);
        end = System.nanoTime();
        System.out.println("Linkedlist add at start time :"+(end-start));

        start = System.nanoTime();
        Linkedlist.add(Linkedlist.size()/2,-1);
        end = System.nanoTime();
        System.out.println("Linkedlist add at middle time :"+(end-start));
    }
}
