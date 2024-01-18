import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < a; i++){
            sb.append("*");    
        }
        sb.append("\n");
        
        String row = sb.toString();
        for(int i = 0; i < b-1; i++){
            sb.append(row);
        }
        System.out.println(sb.toString());
        
    }
}