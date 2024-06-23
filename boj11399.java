import java.io.*;
import java.util.*;

public class boj11399 {
  public static void main(String[] args)throws IOException{    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int Person_Cnt = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] Times = new int[Person_Cnt];
    int total = 0;
    int prev = 0;

    if(st.countTokens() != Person_Cnt)
      return;

    for(int i = 0; i < Person_Cnt; i++) {      
      Times[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(Times);

    for(int i = 0; i < Person_Cnt; i++){
      prev += Times[i];
      total += prev;
    }
    System.out.println(total);
  }
}