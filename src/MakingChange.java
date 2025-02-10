import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Caden Chock
 */

public class MakingChange {
    /**
     * TODO: Complete this function, countWays(), to return the number of ways to make change
     *  for any given total with any given set of coins.
     */
    public static long countWays(int target, int[] coins) {
        Arrays.sort(coins);
        return Memo(target, coins);
    }

    // Reverse Order of Array
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
        // Number of Ways with 5 and 1 coins + number of ways with 10 = number of ways with 1,5,10
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
        //Include
        ways += changeMemo(target - coins[length], coins, length, saved);
        //Exclude
        ways += changeMemo(target, coins, length+1, saved);
        saved[target][length] = ways;
        return ways;
    }

    public static long Tab(int target, int[] coins){

        return 0;
    }

    public static long changeTab(int target, int[] coins, int length, long[][] saved){
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j < target; j++){

            }
        }
    }
}
