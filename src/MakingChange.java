import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Caden Chock
 */

public class MakingChange {
    public static long countWays(int target, int[] coins) {
        Arrays.sort(coins);
        //return Memo(target, coins);
        return Tab(target, coins);
    }

    // Reverse Order of Array made based off code from geeksforgeeks
    public static int[] reverse(int[] coins) {
        int n = coins.length;
        for (int i = 0; i < n / 2; i++) {
            int t = coins[i];
            coins[i] = coins[n - i - 1];
            coins[n - i - 1] = t;
        }
        return coins;
    }

    public static long Memo(int target, int[] coins){
        coins = reverse(coins);
        int length = coins.length-1;
        long[][] saved = new long[target+1][length+1];
        // Set base case
        for(int i = 0; i < coins.length; i++){
            saved[0][i] = 1;
        }
        return changeMemo(target, coins, 0, saved);
    }

    public static long changeMemo(int target, int[] coins, int length, long[][] saved){
        long ways = 0;
        // Base Cases
        if(target == 0){
            return 1;
        }
        if(length > coins.length-1){
            return 0;
        }
        if(target < 0){
            return 0;
        }
        if(saved[target][length] != 0){
            return saved[target][length];
        }
        // Include
        ways += changeMemo(target - coins[length], coins, length, saved);
        // Exclude
        ways += changeMemo(target, coins, length+1, saved);
        saved[target][length] = ways;
        return ways;
    }

    public static long Tab(int target, int[] coins){
        // Plus 1 because add space for 0
        long[][] saved = new long[coins.length][target+1];
        // Base Case
        for(int i = 0; i < coins.length; i++){
            saved[i][0] = 1;
        }
        return changeTab(target, coins, saved);
    }

    public static long changeTab(int target, int[] coins, long[][] saved){
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j < target+1; j++){
                // Include
                long x = 0;
                // Make sure in bounds
                if(j-coins[i] >= 0){
                    x = saved[i][j-coins[i]];
                }
                // Exclude
                long y = 0;
                // Make sure in bounds
                if(i-1 >= 0){
                    y = saved[i-1][j];
                }
                saved[i][j] = x+y;
            }
        }
        return saved[coins.length-1][target];
    }
}
