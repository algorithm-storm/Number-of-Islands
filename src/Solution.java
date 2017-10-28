import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */


    static public void main(String []args){

        Solution test = new Solution();

        int intGrid [][] = new int [][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1}
        };

        boolean grid[][] = new boolean[intGrid.length][intGrid[0].length];

        for (int i = 0 ; i < intGrid.length; i++) {
            for(int j = 0 ; j < intGrid[0].length; j++){
                if(intGrid[i][j] == 1){
                    grid[i][j] = true;
                }
                else {
                    grid[i][j] = false;
                }
            }
        }

        System.out.println(test.numIslands(grid));

    }

    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public int numIslands(boolean[][] grid) {


        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int count = 0;
        for(int i = 0 ; i < grid.length ; i++){

            for(int j = 0 ; j < grid[i].length; j++){

                if(grid[i][j] == true){
                    findConnectedIslands(grid,j,i);
                    count++;
                }
            }
        }
        return count;
    }

    public void findConnectedIslands(boolean[][] grid, int x, int y){

        Queue<Coordinate> connectedIslands = new LinkedList<>();
        connectedIslands.offer(new Coordinate(x,y));

        int [] directX = {-1,0,1,0};
        int [] directY = {0,1,0,-1};

        while (!connectedIslands.isEmpty()){
            Coordinate start = connectedIslands.poll();
            grid[start.y][start.x] = false; //EASY TO FORGET!!!!!!!!!!!!!!!!!
            for(int i = 0 ; i < 4 ; i++){
                Coordinate adjacent = new Coordinate(start.x+directX[i], start.y+directY[i]);
                if(isbound(grid,adjacent.x,adjacent.y)){
                    continue;
                }
                if(grid[adjacent.y][adjacent.x]){
                    grid[adjacent.y][adjacent.x] = false;
                    connectedIslands.offer(adjacent);
                }
            }
        }
    }


    public boolean isbound(boolean[][] grid, int x , int y){
        if( x < 0 || x >= grid[0].length){
            return true;
        }
        if( y < 0 || y >= grid.length){
            return  true;
        }
        return false;
    }

}