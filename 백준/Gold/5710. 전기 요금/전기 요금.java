import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            if(A == 0 && B == 0){
                return;
            }

            int total = electric(A);
            int left = 0;
            int right = total / 2; // 상근이가 무조건 적다.

            while(left <= right){
                int mid = (left + right) / 2;

                int priceL = cost(mid);
                int priceR = cost(total - mid);

                int diff = Math.abs(priceL - priceR);

                if(diff < B){
                    right = mid - 1;
                }else if(diff > B){
                    left = mid +1;
                }else{
                    System.out.println(cost(mid));
                    break;
                }
            }
        }
    }
    

    public static int cost(int wh){
        if(wh <= 100){
            return wh * 2;
        }else if(wh <= 10000){
            return 200 + (wh - 100) * 3;
        }else if(wh <= 1000000){
            return 200 + 29700 + (wh - 10000) * 5;
        }else{
            return 200 + 29700 + 4950000 + (wh - 1000000) * 7;
        }
    }

    public static int electric(int price){
        if(price <= 200){
            return price / 2;
        }else if(price <= 200 + 29700){
            return (price - 200) / 3 + 100;
        }else if(price <= 200 + 29700 + 4950000){
            return (price - 200 - 29700) / 5 + 10000;
        }else{
            return (price - 200 - 29700 - 4950000) / 7 + 1000000;
        }
    }
}

// 1100 300
// 35515 27615
// 0 0