import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long total;

    static class Loc implements Comparable<Loc>{
        long X, A;

        public Loc(long X, long A) {
            this.X = X;
            this.A = A;
        }

        public int compareTo(Loc o) {
            if (this.X == o.X) {
                return (int) (this.A - o.A);
            }
            return (int) (this.X - o.X);
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        Loc[] arr = new Loc[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        total = 0;
        
        for (int i = 0; i < N; i++) {
            total += arr[i].A;
        }
        
        Arrays.sort(arr);

        long count = 0;
        
        for (Loc l : arr) {
            count += l.A;
            if (count >= (total+1)/2) {
                System.out.println(l.X);
                break;
            } 
        }
    }   
}