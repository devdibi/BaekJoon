import java.util.*;
import java.io.*;


public class Main {
	static int N, M;
	static boolean[] visited;
	static int[] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		result = new int[M];
		visited = new boolean[N];
		
		permutation(0);
		
		sc.close();
	}
	
	public static void permutation(int cnt) {
		if(cnt == M) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < M;i++) {
				sb.append(result[i]).append(" ");
			}
			System.out.println(sb);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			int temp = result[cnt];
			result[cnt] = i+1;
			visited[i] = true;
			
			permutation(cnt+1);
			
			result[cnt] = temp;
			visited[i] = false;
		}
	}
	
	
}
