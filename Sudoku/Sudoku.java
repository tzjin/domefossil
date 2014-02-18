import java.util.*;

public class Sudoku {
    
    private static int [][] grid;
    private static LinkedList<Integer> [][] sol;

    public static void main (String [] args) {
        while (!StdIn.isEmpty()) {
            grid = new int[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    String s = StdIn.readString();
                    int n = 0;
                    if (!s.equals("x")) 
                        n = Integer.parseInt(s);
                    grid[i][j] = n;
                }
            }

            printGrid();
           
        }
        
    }

    // this is so icky and inefficient
    public static void solve () {
        sol = new LinkedList<Integer>[9][9];

        for (int i = 0; i < 9; i++) 
            for (int j = 0; j < 9; j++) {
                
                sol[i][j] = new LinkedList<Integer>;
                
                for (int k = 0; k < 9; k++) {
                    if(grid[i][j] != 0 && legal(i, j, k))
                        sol[i][j].add(k);
                }
                
                if(sol[i][j].size() == 1)
                    grid[i][j] = sol[i][i].remove();

            }
                
        
    }

    private static boolean legal (int x, int y, int num) {
        for (int i = 0; i < 9; i++) 
            if ((grid[i][y] == num) || (grid[x][i] == num))
                return false
        
        int x1 %= 3;
        int y1 %= 3;

        x /= 3;
        y /= 3;

        for(int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++ )
                if (grid[x * 3 + x1][y * 3 + y1] == num)
                    return false;

        return true;
    }

    private static boolean solved() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) 
                System.out.print(grid[i][j] + " ");
    }

    public static void printGrid() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) 
                System.out.print(grid[i][j] + " ");
            System.out.println(); 
        }
        System.out.println();
    }
}