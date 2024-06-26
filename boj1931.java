import java.util.*;
import java.io.*;

public class boj1931{
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int meet_Cnt = Integer.parseInt(br.readLine());
    int[][] meet_time = new int[meet_Cnt][2];

    for(int i = 0; i < meet_Cnt; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      meet_time[i][0] = Integer.parseInt(st.nextToken());
      meet_time[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(meet_time, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2){
        if(o1[1] == o2[1])
          return o1[0] - o2[0];

        return o1[1] - o2[1];
      }
    });

    int prev = 0;
    int cnt = 0;

    for(int i = 0; i < meet_Cnt; i++) {
      if(prev <= meet_time[i][0]) {
        prev = meet_time[i][1];
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}