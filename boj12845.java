import java.util.*;
import java.io.*;

public class boj12845 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int cnt = Integer.parseInt(br.readLine());
    int[] card = new int[cnt];
    
    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i = 0; i < cnt; i++){
      card[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(card);

    int card_max = card[cnt-1];
    int gold = 0;
    
    for(int i = cnt-1; i > 0; i--) {
      gold += card_max + card[i-1];
    }

    System.out.println(gold);
  }
}