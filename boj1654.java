import java.io.*;
import java.util.*;

public class boj1654 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int have_lan = Integer.parseInt(st.nextToken());

    int need_lan = Integer.parseInt(st.nextToken());

    int[] lan_len = new int[have_lan];

    for(int i = 0; i < have_lan; i++)
      lan_len[i] = Integer.parseInt(br.readLine());    

    Arrays.sort(lan_len);
    long left = 1;
    long right = lan_len[have_lan- 1];
    long max_len = 0;

    while(left <= right) {
      long sum = 0;
      long mid = (left + right) / 2;

      for(int i = 0; i < have_lan; i++) {
          sum += lan_len[i] / mid;
      }
      if(sum < need_lan) {
        right = mid - 1;
      } else {
        left = mid + 1;
        max_len = mid;
      }
    }
    System.out.println(max_len);
  }
}