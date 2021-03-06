package dp;

/**
 * On a 2-dimensional grid, there are 4 types of squares:
 *
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Example 2:
 *
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * Example 3:
 *
 * Input: [[0,1],[2,0]]
 * Output: 0
 * Explanation:
 * There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.
 */
public class UniquePaths_3 {
    public int uniquePathsIII(int[][] grid) {
        int startX = 0;
        int startY = 0;
        int[] result = new int[1];
        int numNonObstacleSquares = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }

                if(grid[i][j] != -1 && grid[i][j] != 2) {
                    ++numNonObstacleSquares;
                }
            }
        }

        uniquePathsIII(grid, startX, startY, numNonObstacleSquares, result);

        return result[0];
    }

    private void uniquePathsIII(int[][] grid, int i, int j, int numNonObstacleSquares, int[] result) {
        if(grid[i][j] == -1 || grid[i][j] == 3) return;

        if(grid[i][j] == 2) {
            if(numNonObstacleSquares == 0) {
                ++result[0];
            }
            return;
        }

        --numNonObstacleSquares;
        int currentValue = grid[i][j];
        grid[i][j] = 3;
        if(i != grid.length - 1) {
            uniquePathsIII(grid, i+1, j, numNonObstacleSquares, result);
        }
        if(j != grid[0].length - 1) {
            uniquePathsIII(grid, i, j+1, numNonObstacleSquares, result);
        }
        if(i != 0) {
            uniquePathsIII(grid, i-1, j, numNonObstacleSquares, result);
        }
        if(j != 0) {
            uniquePathsIII(grid, i, j-1, numNonObstacleSquares, result);
        }
        grid[i][j] = currentValue;
    }
}
