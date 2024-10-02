import utils.ExecDuration;

public class BuySellStock121 {

    public static void main(String[] args) {
        BuySellStock121 obj = new BuySellStock121();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(obj.maxProfit(prices)); // 5
        ExecDuration.measure(() -> obj.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int res = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            res = Math.max((prices[i] - buy), res);
            buy = Math.min(buy, prices[i]);
        }
        return res;
    }
}
