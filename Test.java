import java.util.*;

public class Test {
    public static void main(String[] args) {
        testExample();
        testConsec();
    }

    public static void testExample() {
        Sol s = new Sol();

        int[] in = {1, 2, 0, 3};
        int[] out = {3, 1, 2, 0};
        int[] exp_arr = {1, 2, 0, 1, 3, 0};
        LinkedList<Move> expected = init(exp_arr);

        print("Got: ");
        LinkedList<Move> got = s.move_cars(in, out);    
        print(got);
        print("Result: " + (expected.equals(got)? "OK" : "X") + "\n-------");
        
    }

    public static void testConsec() {
        Sol s = new Sol();

        int[] in = {1, 3, 6, 0, 5, 4, 2};
        int[] out = {1, 2, 3, 4, 5, 6, 0};
        int[] exp_arr = {2, 3, 1, 2, 5, 1, 3, 5, 1, 3, 6, 1};
        LinkedList<Move> expected = init(exp_arr);

        print("Got: ");
        LinkedList<Move> got = s.move_cars(in, out);    
        print(got);
        print("Result: " + (expected.equals(got)? "OK" : "X") + "\n-------");
          
    }

    // helpers

    private static void print(String s){
        System.out.println(s);
    }

    private static void print(LinkedList < Move > coll) {
        for (Move elem: coll)
            System.out.println("Moved " + elem.x + " to " + elem.y);
    }
    private static LinkedList<Move> init(int[] arr){
        LinkedList<Move> out = new LinkedList<Move>();
        for(int i = 0; i < arr.length - 1; i+= 2)
            out.add(new Move(arr[i], arr[i+1]));
        return out;
    }
}
