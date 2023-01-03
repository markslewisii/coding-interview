package com.google;

public class NumIslands {
    
    public static void main(String[] args) {
        /*
        int[][] map = {
                { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1},
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                { 0, 1, 1, 0, 1, 0, 1, 1, 0, 0},
                { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                { 0, 1, 0, 1, 0, 0, 1, 0, 1, 0},
                { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1},
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                { 0, 1, 1, 0, 0, 0, 1, 1, 0, 0},
                { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                { 0, 1, 0, 1, 0, 0, 1, 0, 1, 0},
                { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1},
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                { 0, 1, 1, 0, 1, 0, 1, 1, 0, 0},
                { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                { 0, 1, 0, 1, 0, 0, 1, 0, 1, 0},
                { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1},
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                { 0, 1, 1, 0, 0, 0, 1, 1, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 1, 0, 1, 0, 0, 1, 0, 1, 0},
        };
        */
        int[][] map = {
                { 1, 0, 1, 0, 1},
                { 1, 0, 0, 0, 1},
                { 1, 1, 0, 1, 1},
                { 0, 1, 0, 0, 1},
                { 0, 1, 1, 0, 0}
        };
        
        /*
        int w = 300;
        int h = 300;
        int[][] map = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = (int) Math.round(Math.random());
            }
           
        }
        */

        NumIslands ni = new NumIslands(map);
        System.out.println(ni.getGrid());
        
        System.out.println(ni.getNumIslands());
        
        //System.out.println(ni.getGrid());
    }

    
    private Grid grid;
    private static final int MARKER = 8;

    public NumIslands(int[][] map) {
        this.setGrid(new Grid(map));
    }
 
    public Grid getGrid() {
        return grid;
    }


    public void setGrid(Grid grid) {
        this.grid = grid;
    }
    
    
    public int getNumIslands() {
        int numIslands = 0;
        for(int x = 0; x < this.getGrid().width; x++) {
            for(int y = 0; y < this.getGrid().height; y++) {
                if (this.getGrid().getCoord(x, y) == 1) {
                    // System.out.println("tracing island");
                    traceIsland(x, y);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    
    private void traceIsland(int x, int y) {
        // System.out.println(String.format("traceIsland(%d, %d)", x, y));
        if (x == this.getGrid().getWidth() || 
                x < 0 ||
                y == this.getGrid().getHeight() ||
                y < 0) {
            return;
        } else if (this.getGrid().getCoord(x, y) == 0 || 
                this.getGrid().getCoord(x, y) == MARKER) {
            return;
        } else {
            this.getGrid().setCoord(x, y, MARKER);
            traceIsland(x+1, y);
            traceIsland(x, y+1);
            traceIsland(x-1, y);
            traceIsland(x, y-1);
        }
    }

   
    
    
    class Grid {
        private int[][] grid;
        private int width;
        private int height;
        

        public Grid(int w, int h) {
            this.setWidth(w);
            this.setHeight(h);
            this.setGrid(new int[h][w]);
        }
        
        public Grid(int[][] grid) {
            this.setGrid(grid);
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
        
        public int [][] getGrid() {
            return grid;
        }

        public void setGrid(int[][] grid) {
            this.setHeight(grid.length);
            this.setWidth(grid[0].length);
            this.grid = grid;
        }
        
        public int getCoord(int x, int y) {
            return this.getGrid()[y][x];
        }
        
        public void setCoord(int x, int y, int val) {
            this.getGrid()[y][x] = val;
        }
        
        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append(String.format("width: %d, height: %d\n", this.getWidth(), this.getHeight()));
            for(int[] line: this.getGrid()) {
                for (int coord: line) {
                    sb.append(coord + " ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
        
    }
    
    
    class Coord {
        int x;
        int y;
        
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    


}
