import java.util.*;
import java.io.*;

public class boj2805 {
  public static void main() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int Tree_cnt = Integer.parseInt(st.nextToken());
    int Need_leg = Integer.parseInt(st.nextToken());
    
    int[] Tree = new int[Tree_cnt];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < Tree_cnt; i++)
      Tree[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(Tree);
    
    int left = 0;
    int right = Tree[Tree.length - 1];
    int min_height = 0;

    while (left <= right) {
      int mid = (right + left) / 2;
      long sum = 0;

      for(int i = 0; i < Tree_cnt; i++) {
        if(Tree[i] > mid)
        sum += (Tree[i] - mid);
      }
      // 자른 나무 길이 합이 필요 길이보다 많다 = 절단기의 높이를 높여야 한다.
      if (sum >= Need_leg) {
        left = mid + 1;
        min_height = mid;
      }
      // 자른 나무 길이 합이 필요 길이보다 적다 = 절단기의 높이를 낮춰야 한다.
      else {
        right = mid - 1;
      } 
    }
    
    System.out.println(min_height);
  }
}