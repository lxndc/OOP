public class TetrisGrid {
    private boolean[][] grid;
    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     * @param grid
     */
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }


    /**
     * Does row-clearing on the grid (see handout).
     */
    public void clearRows() {
        int newRows = grid.length-1;
        boolean[][] res = new boolean[grid.length][grid[0].length];
        for(int i = grid.length-1; i >=0; i--) {
            boolean check = true;
            for(int j = 0; j < grid[i].length; j++) {
                if(!grid[i][j]) {
                    check = false;
                    break;
                }
            }
            if(!check) {
                res[newRows--]=grid[i];
            }
        }
        grid = res;
    }


    /**
     * Returns the internal 2d grid array.
     * @return 2d grid array
     */
    boolean[][] getGrid() {
        return grid; // YOUR CODE HERE
    }
    public static void  main(String[] agrs) {
        boolean[][] before =
                {
                        {false, true,false},
                        {true, true, true, },
                        {false, true, true, }
                };
        TetrisGrid grid = new TetrisGrid(before);
        grid.clearRows();
        // Print the grid
        boolean[][] after = grid.getGrid();
        for (int i = 0; i < after.length; i++) {
            for (int j = 0; j < after[i].length; j++) {
                System.out.print(after[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }

    }
}