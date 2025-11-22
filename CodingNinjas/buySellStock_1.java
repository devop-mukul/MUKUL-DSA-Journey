public class buySellStock_1 {
    public int buySellStock1(int [] prices) { //ONLY ONE TRANSACTION ALLOWED
        int profit_if_sold_today = 0;
        int least_so_far = Integer.MAX_VALUE;
        int overall_profit = 0;

        for(int i = 0; i < prices.length; i++) {
            if(prices[i] <= least_so_far) {
                least_so_far = prices[i];
            }

            profit_if_sold_today = prices[i] - least_so_far;

            if(profit_if_sold_today >= overall_profit)
                overall_profit = profit_if_sold_today;
        }
        return overall_profit;
    }
    
    public int buySellStock2(int [] prices) { // INFINITE TRANSACTIONS ALLOWED
        int total_profit = 0;
        int buyDay = 0;
        int sellDay = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1])
                sellDay++;
        
            else {//IF DIP AATA HAI GRAPH ME TO PREVIOUS PROFIT CALCULATE KARO
                total_profit += prices[sellDay] - prices[buyDay];
                sellDay = buyDay = i;
            }
        }
        //REMAINING PROFIT CACULATE KARNE KE LIYE
        total_profit += prices[sellDay] - prices[buyDay];
        return total_profit;
    }
    
    public int buySellStock3(int day, int buy, int [] prices, int limit) { //ONLY 2 TRANSACTIONS ALLOWED
        if(day == prices.length)
            return 0;
        if(limit == 0)
            return 0;

        int profit = 0;

        if(buy == 1) {
            int buyNow = -prices[day] + buySellStock3(day + 1, 0, prices, limit);
            int skipKaro = 0 + buySellStock3(day + 1, 1, prices, limit);
            profit = Math.max(buyNow, skipKaro);
        }
        else {//SELL KARO
        int sellNow = prices[day] + buySellStock3(day + 1, 1, prices, limit - 1);
        int skipKaro = 0 + buySellStock3(day + 1, 0, prices, limit);
            profit = Math.max(sellNow, skipKaro);
        }

        return profit;
    }
    
    public static void main(String[] args) {
        buySellStock_1 obj = new buySellStock_1();
        int prices[] = {3, 3, 5, 0, 0, 1, 4};
        System.out.println(obj.buySellStock1(prices));
        System.out.println(obj.buySellStock2(prices));
        System.out.println(obj.buySellStock3(0, 1, prices, 2));
    }
}
