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

            solve();
            printGrid();
           
        }
        
    }

    // this is so icky and inefficient
    public static void solve () {
        sol = new LinkedList[9][9];

        while(!solved()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (grid[i][j] != 0)
                        continue;
                    
                    sol[i][j] = new LinkedList<Integer>();
                    
                    for (int k = 1; k <= 9; k++) 
                        if(legal(i, j, k))
                            sol[i][j].add(k);
                    
                    if(sol[i][j].size() == 1)
                        grid[i][j] = sol[i][j].remove();

                }
            }


            printGrid();
        }
                
        
    }

    private static boolean legal (int x, int y, int num) {
        for (int i = 0; i < 9; i++) 
            if ((grid[i][y] == num) || (grid[x][i] == num))
                return false;
        
        x /= 3;
        y /= 3;

        for(int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++ )
                if (grid[x * 3 + i][y * 3 + j] == num)
                    return false;

        return true;
    }

    private static boolean solved() {
        for (int i = 0; i < 9; i++) 
            for (int j = 0; j < 9; j++) 
                if (grid[i][j] == 0)
                    return false;

        return true;
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