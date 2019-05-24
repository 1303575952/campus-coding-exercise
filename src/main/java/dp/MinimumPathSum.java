package dp;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int[][] arr = new int[grid.length][grid[0].length];
        arr[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            arr[i][0] = arr[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            arr[0][j] = arr[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                arr[i][j] = grid[i][j] + (arr[i - 1][j] < arr[i][j - 1] ? arr[i - 1][j] : arr[i][j - 1]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        return arr[arr.length - 1][arr[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
