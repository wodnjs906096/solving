import java.util.*;
import java.io.*;

public class boj2805 {
  public static void main() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());  

    int Tree_cnt = Integer.parseInt(st.nextToken());
    int Need_leg; 
    int[] Tree = new int[Tree_cnt];

    if(st.hasMoreTokens())
      Need_leg = Integer.parseInt(st.nextToken());
    else 
      return;

    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < Tree_cnt; i++) 
      Tree[i] = Integer.parseInt(st.nextToken());

    int left = 1;
    int right = Tree[Tree.length - 1] - 1; 

    while(left <= right) {
      int mid = ( right + left ) / 2;
      int sum = 0;
      
      // 자른 나무 길이 합이 필요 길이보다 많다 = 절단기의 높이를 높여야 한다. 
      if(sum > Need_leg){ 
        left = mid+1;
      }
      // 자른 나무 길이 합이 필요 길이보다 적다 = 절단기의 높이를 낮춰야 한다.
      else if(sum < Need_leg) {
        right = mid - 1;
      }
      else {
        int min_height = mid;
        System.out.println(min_height);
        return;
      }
    }
  }
}
