package Array;

public class BuyAndSellStock {
        public int maxProfit(int[] prices) {
            
            int len = prices.length;
            int mp = 0;
            if(len > 1){
            int localMin = prices[0];
                if(len == 2 && prices[1] > localMin){
                    mp = mp + (prices[1] - localMin); 
                }
            for(int i=1; i<len-1; i++){
                if(prices[i] < prices[i+1] && prices[i] <= localMin){
                    localMin = prices[i];
                }    
                
                if(prices[i] > prices[i+1] && localMin < prices[i]){
                    mp = mp + (prices[i] - localMin);
                    localMin = prices[i+1];
                }
                
                if((i+1) == (len-1) && localMin < prices[i+1]){
                    mp = mp + (prices[i+1] - localMin);
                }
                
            }
            }
            return mp;
        }
}