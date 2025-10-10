public class bestTimeToSellAndBuyStocks2 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        bestTimeToSellAndBuyStocks2 obj = new bestTimeToSellAndBuyStocks2();
        int profit = obj.maxProfit(prices);
        System.out.println("Maximum Profit: " + profit);
    }
}
