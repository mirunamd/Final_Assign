import java.util.*;

public class Sol {
    int[] in ;
    HashMap < Integer, Integer > exp;
    LinkedList < Move > moves_coll;
    int zeropos;

    public LinkedList<Move> move_cars(int[] in , int[] out) {
        initialise( in , out);
        solve();
      
        return moves_coll;
    }

    private void initialise(int[] in , int[] out) {
        exp = new HashMap < Integer, Integer > ();
        moves_coll = new LinkedList < Move > ();
        this.in = in ;

        for (int i = 0; i < out.length; i++) {
            exp.put(out[i], i);
        }

        for (int j = 0; j < in .length; j++)
            if ( in [j] == 0) {
                zeropos = j;
                break;
            }

    }

    private void solve() {
        int i = 0;
        while (i < in .length) {
            if (exp.get( in [i]) != i && in [i] != 0) {
                move(i);
                i = -1;
            }
            i++;
        }

        // print(in);
    }

    /* temp contains in : 1, 2, 0, 3
                                            
    // exp: 3 -> 0,
            1 -> 1,
            2 -> 2,
            0 -> 3
            
    */
    private void move(int i) {
        int val = in [i];
        int di = exp.get(val); // desired index
        int nval = in [di];

        if ( in [di] != 0) { in [di] = val; in [i] = 0; in [zeropos] = nval;
            moves_coll.add(new Move(di, zeropos));
            moves_coll.add(new Move(i, di));

            zeropos = i;

        } else { in [di] = val; in [i] = 0;
            zeropos = i;
            moves_coll.add(new Move(i, di));
        }
    }

    private void print(LinkedList < Move > coll) {
        for (Move elem: coll)
            System.out.println("Moved " + elem.x + " to " + elem.y);
    }
    private void print(int x) {

        System.out.println(x);
    }
  
    private void print(int[] arr) {
        for(int x : arr)
            System.out.print(x + " ");
         System.out.println();      
    }
}

class Move {
    public int x; // move x to y
    public int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null)
          return false;

        Move o = (Move) obj;
        return (this.x == o.x && this.y == o.y);
    }
}
