
public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int maxcol = Integer.MIN_VALUE;
        int maxrow = Integer.MIN_VALUE;
        int mincol = Integer.MAX_VALUE;
        int minrow = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == ch) {
                    flag = true;
                    maxcol = Math.max(maxcol, j);
                    maxrow = Math.max(maxrow, i);
                    mincol = Math.min(mincol, j);
                    minrow = Math.min(minrow, i);
                }
            }
        }
        if(flag) {
            return ((maxcol - mincol) + 1)*((maxrow - minrow)+1);
        }
        return 0; // YOUR CODE HERE
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     * @return number of + in grid
     */
    private int check(int i,int j,int idir,int jdir) {
        char ch = grid[i][j];
        int length = 1;
        while(true) {
            i+=idir;
            j+=jdir;
            if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] != ch) {
                break;
            }
            else
                length++;
        }
        return length;
    }
    public int countPlus() {
        int res=0;
        for(int i = 1; i < grid.length-1; i++) {
            for(int j = 1; j < grid[i].length-1; j++) {
                if(Character.isLetter(grid[i][j])) {
                    int up = check(i, j, -1, 0);
                    int down = check(i, j, 1, 0);
                    int left = check(i, j, 0, -1);
                    int right = check(i, j, 0, 1);
                    if(up>=2 && down>=2 && left>=2 && right>=2 && up==down && down==left && left==right) {
                        res++;
                    }
                }
            }
        }
        return res; // YOUR CODE HERE
    }

    public static void main(String[] args) {
        char[][] inputGrid = {
                {' ',' ','p',' ',' ',' ',' ',' ',' '},
                {' ',' ','p',' ',' ',' ',' ','x',' '},
                {'p','p','p','p','p',' ','x','x','x'},
                {' ',' ','p',' ',' ','y',' ','x',' '},
                {' ',' ','p',' ','y','y','y',' ',' '},
                {'z','z','z','z','z','y','z','z','z'},
                {' ',' ','x','x',' ','y',' ',' ',' '}
        };
        CharGrid grid = new CharGrid(inputGrid);
        System.out.print(grid.countPlus());
    }
}
