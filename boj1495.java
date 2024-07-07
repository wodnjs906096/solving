import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int Songs = Integer.parseInt(st.nextToken());
    int NV = Integer.parseInt(st.nextToken());
    int MAX = Integer.parseInt(st.nextToken());

    int[] changes = new int[Songs];

    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < Songs; i++) {
      changes[i] = Integer.parseInt(st.nextToken());
    }

    boolean[][] dp = new boolean[Songs+1][MAX + 1];

    dp[0][NV] = true;

    for(int i = 0; i < Songs; i++){
      for(int j = 0; j <= MAX; j++){
        if(dp[i][j]){
          if(j+changes[i] <= MAX)
            dp[i+1][j+changes[i]] = true;

          if(j-changes[i] >= 0) 
            dp[i+1][j-changes[i]] = true;
          
        }
      }
    }

    int result = -1;

    for(int i = MAX; i >= 0; i--){
      if(dp[Songs][i]){
        result = i;
        break;
      }
    }

    System.out.println(result);
  }
}