import java.util.*;
import java.io.*;

public class boj1679 {
  static int MAX = 100000;
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int pos = Integer.parseInt(st.nextToken());
    int child_pos = Integer.parseInt(st.nextToken());

    if(pos == child_pos) {
      System.out.println(0);
      return;
    }
    
    bfs(pos, child_pos);
  }

  static void bfs(int pos, int child_pos) {
    Queue<Integer> search = new LinkedList<Integer>();
    int[] visited = new int[MAX+1]; 
    
    search.add(pos);
    visited[pos] = 1;
    int min_time = 0;
    int size = search.size();
    
    while(!search.isEmpty()) {
      min_time++;
      size = search.size();
      for(int i = 0; i < size; i++) {
        int val = search.poll();
        if(val - 1 == child_pos || val + 1 == child_pos || val * 2== child_pos){
          System.out.println(min_time);
          return;
        }
        if(val - 1 >= 0 && visited[val - 1] == 0){
          visited[val - 1] = 1;
          search.add(val - 1);
        }
        if(val + 1 <= MAX && visited[val + 1] == 0){
          visited[val + 1] = 1;
          search.add(val + 1);
        }
        if(val * 2 <= MAX && visited[val * 2] == 0 ){
          visited[val * 2] = 1;
          search.add(val * 2);
        }
      }
  }
    System.out.println(min_time);
}
}