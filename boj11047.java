import java.io.*;
import java.util.*;

public class boj11047 {
  static int MAX = 100000000;
  static int MIN = 1;
  
  public static void main(String[] args)throws IOException{    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int cnt = Integer.parseInt(st.nextToken());
    int acount = Integer.parseInt(st.nextToken());
    int[] coins = new int[cnt];
    int result = 0;

    if(cnt < MIN || cnt > 10 || acount < MIN || acount > MAX) 
      return;

    for(int i = cnt; i >= 1; i--){
      coins[i-1] = Integer.parseInt(br.readLine());
    }

    for(int i = 0; i < cnt; i++) {
      if(coins[i] <= acount) {
        result += acount / coins[i];
        acount = acount % coins[i];
      }
    }

    System.out.println(result);
  }
}