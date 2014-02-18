import java.util.*;

public class FollowDirections {
    private static int turn; // 0 ^ , clockwise direction
    private static int x, y;


    public static void main (String [] args) {
        LinkedList<String> ls = new LinkedList<String>();
        turn = 0;
        x  = 0;
        y = 0;

        while (!StdIn.isEmpty()) 
            ls.add(StdIn.readString());
        
        while(!ls.isEmpty()) {
            String s = ls.remove();
            if(s.equals("Move")) move(ls.remove());
            else turn(ls.remove());
        }

        System.out.println(x + ", " + y);
    }

    private static void move (String distance) {
        int dist = Integer.parseInt(distance);

        if (turn % 2 == 0) 
            y += Math.abs(dist);
        if (turn % 2 == 1)
            x += Math.abs(dist);

        // if (turn % 4 == 0)
        //     y += dist;
        // if (turn % 4 == 1)
        //     x += dist;
        // if (turn % 4 == 2);
        //     y -= dist;
        // if (turn % 4 == 3)
        //     x -= dist;
    }

    private static void turn (String direction) {
        if(direction.equals("right"))
            turn++;
        else 
            turn += 3;
    }

}