class Solution {
    public int solution(int price) {
        double money = (double) price;
        
        if(price < 100_000){
            return (int) money;
        }else if(price < 300_000){
            return (int) (money * 0.95);
        }else if(price < 500_000){
            return (int) (money * 0.9);
        }else{
            return (int) (money * 0.8);
        }
    }
}