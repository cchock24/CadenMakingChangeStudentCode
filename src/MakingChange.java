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
        // Number of Ways with 5 and 1 coins + number of ways with 10 = number of ways with 1,5,10


        return 0;
    }

    // Get Smallest number of coins needed
    public static int[] getCoins(int[] coins, int target){
        int[] change = new int[coins.length];
        for(int i = coins.length-1; i >= 0; i--){
            int counter = 0;
            while(target > coins[i]){
                target = target - coins[i];
                counter++;
            }
            change[i] = counter;
        }
        return change;
    }
}
