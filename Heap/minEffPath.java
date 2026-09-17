import java.util.*;

public class minEffPath {

    static class Cell {
        int row, col, cost;
        Cell(int row, int col, int cost){
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
    static int minCost(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int dist[][] = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b)-> a.cost - b.cost);
        dist[0][0] = grid[0][0];
        pq.add(new Cell(0, 0, grid[0][0]));
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        while(!pq.isEmpty()){
            Cell curr = pq.remove();
            int r = curr.row;
            int c = curr.col;
            int cost = curr.cost;
            if(r == n-1 && c== m-1){
                return cost;
            }
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    int newCost = cost + grid[nr][nc];
                    if(newCost < dist[nr][nc]){
                        dist[nr][nc] = newCost;
                        pq.add(new Cell(nr, nc, newCost));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {31, 100, 65, 12, 18},
            {10, 13, 47, 157, 6},
            {100, 113, 174, 11, 33},
            {88, 124, 41, 20, 140},
            {99, 32, 111, 41, 20}
        };

        System.out.println(minCost(grid));
    }
}