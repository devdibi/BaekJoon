class Solution {
    public int solution(int a, int b) {
        StringBuilder asb = new StringBuilder();
        StringBuilder bsb = new StringBuilder();
        
        asb.append(a).append(b);
        bsb.append(b).append(a);
        
        int A = Integer.parseInt(asb.toString());
        int B = Integer.parseInt(bsb.toString());
        
        return A > B ? A : B;
    }
}