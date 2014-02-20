import java.util.*;

public class Sudoku {
    
    private static int [][] grid;

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

            solve(0, 0, grid);
            printGrid();
           
        }
        
    }

    public static boolean solve(int i, int j, int [][] cells) {
        // increment rows
        if(i == 9) {
            i = 0;
            j++;
        }

        // check to see if cell has value
        if (cells[i][j] != 0)
            return solve(i + 1, j, cells);

        // check to see if completed
        if (i == 8 && j == 8)
            return true;

        // check values
        for (int n = 1; n <= 9; n++) {
            if(legal(i, j, n, cells)) {
                cells[i][j] = n;
                if(solve(i + 1, j, cells))
                    return true;
            }
        }

        cells[i][j] = 0;
        return false;
    }

    private static boolean legal (int x, int y, int num, int [][] cells) {
        for (int i = 0; i < 9; i++) 
            if ((cells[i][y] == num) || (cells[x][i] == num))
                return false;
        
        x /= 3;
        y /= 3;

        for(int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++ )
                if (cells[x * 3 + i][y * 3 + j] == num)
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