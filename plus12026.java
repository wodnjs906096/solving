import java.util.*;
import java.io.*;

public class plus12026 {
  static int MAX = 1000;
  static int MIN = 1;
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int cnt = Integer.parseInt(br.readLine());
    // 블록 개수 입력 받음

    if(cnt < 1 || cnt > 1000)
      return; // 입력 조건 

    String Block = br.readLine(); // 보도블록

    char[] check = {'B', 'O', 'J'};
    // 

    int[] dp = new int[cnt];
    Arrays.fill(dp, Integer.MAX_VALUE);
    //dp 배열내에 최대값을 담아준다.

    int nextIdx = 0;
    char nextchar = ' ';
      
    dp[0] = 0;
    // 첫번째 위치에서의 에너지는 0이기 때문에 
    // 0 할당.

    for(int i = 0; i < cnt; i++) {
      if(dp[i] == Integer.MAX_VALUE) continue;
      // dp[i] 가 최대값인 경우에는 갈 수 없는 곳이라고 판단.
      
      int curIdx = -1;
      
      for(int k = 0; k < 3; k++) {
        if(Block.charAt(i) == check[k]){
          curIdx = k;
          break;
        }
      }

      nextIdx = (curIdx + 1) % 3;
      nextchar = check[nextIdx];

      for(int j = i+1; j < cnt; j++) {
        if(Block.charAt(j) == nextchar) {
          int cost = (j-i) * (j-i);
          dp[j] = Math.min(dp[j], dp[i] + cost);
        }
      }
    }

    if(dp[cnt - 1] == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(dp[cnt - 1]);
    }
  }
}