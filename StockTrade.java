import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * This problem was recently asked by Apple:

You are given an array. Each element represents the price of a stock on that particular day. Calculate and return the maximum profit you can make from buying and selling that stock only once.

For example: [9, 11, 8, 5, 7, 10]

Here, the optimal trade is to buy when the price is 5, and sell when it is 10, so the return value should be 5 (profit = 10 - 5 = 5).

Here's your starting point:

def buy_and_sell(arr):
  #Fill this in.
  
print buy_and_sell([9, 11, 8, 5, 7, 10])
# 5
 */
public class StockTrade {

    public int buyAndSell(Integer[] prices){
        List<Integer> sorted =  new LinkedList<>(Arrays.asList(prices));
        sorted.sort(Collections.reverseOrder());
        int maxProfit=Integer.MIN_VALUE;
        for(int i = 0; i< prices.length;i++){
            int profit = sorted.get(0) - prices[i];
            if(profit > maxProfit){
                maxProfit = profit;
            }
            // remove this from sorted.
            sorted.remove(prices[i]);
        }
        return maxProfit;
    }

    /**
     * Sort prices highest to lowest
     * Loop through list in order (not sorted).
     * Compare to highest value in sorted list. Remove
     * @param prices
     * @return
     */
    public int buyAndSellWithShorts(Integer[] prices){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i = 0; i< prices.length;i++){
            if(prices[i]>max)
                max=prices[i];
            if(prices[i]<min)
                min=prices[i];
        }
        return max-min;
    }

    public long time(Function fn, int iterations){
        long start = System.nanoTime();
        for(int i =0;i<iterations;i++){
            fn.doStuff();
        }
        return System.nanoTime()-start;
    }

    interface Function {
        int doStuff();
    }

    public static void main(String[] args) {
        StockTrade stockTrade = new StockTrade();
        final Integer[] prices = new Integer[]{9,11,8,5,7,10,6,7,8,9,8,7,6,5,4};
        int loop =100;
        System.out.println("Max with no shorts "+stockTrade.time( ()->stockTrade.buyAndSell(prices), loop ));
        System.out.println("Max with    shorts "+stockTrade.time( ()->stockTrade.buyAndSellWithShorts(prices), loop));
    }
    
}