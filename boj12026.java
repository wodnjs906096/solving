import java.util.*;
import java.io.*;

public class boj12026 {
  static int MIN = 1;
  static int MAX = 1000;
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());

    if(N < MIN || N > MAX)
      return;

    String block = br.readLine();

    int[] dp = new int[N];
    Arrays.fill(dp, Integer.MAX_VALUE);

    dp[0] = 0;

    for(int i = 0; i < N; i++) {
      if(dp[i]  == Integer.MAX_VALUE) continue;
      int cost = 0;
      for(int j = i+1; j < N; j++){
        if(block.charAt(i) == 'B' && block.charAt(j) == 'O'){
          cost = (j - i) * (j - i);
          dp[j] = Math.min(dp[j], dp[i] + cost);
        }
        else if(block.charAt(i) == 'O' && block.charAt(j) == 'J'){
          cost = (j - i) * (j - i);
          dp[j] = Math.min(dp[j], dp[i] + cost);
        }
        else if(block.charAt(i) == 'J' && block.charAt(j) == 'B'){
          cost = (j - i) * (j - i);
          dp[j] = Math.min(dp[j], dp[i] + cost);
        }
      }

    }
    
    if(dp[N-1] == Integer.MAX_VALUE){
      System.out.println(-1);
      return;
    } else {
      System.out.println(dp[N-1]);
      return;
    }
      
  }
}