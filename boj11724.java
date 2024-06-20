import java.util.*;
import java.io.*;

public class boj11724 {
  static ArrayList<Integer> arr[];
  static int visited[]; 
  
  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    arr = new ArrayList[N+1];
    visited = new int[N+1];

    for(int i = 0; i < N+1; i++)
      arr[i] = new ArrayList<Integer>();

    for(int i = 0; i < L; i++) {
      st = new StringTokenizer(br.readLine());
      
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());

      arr[node1].add(node2);
      arr[node2].add(node1);
    }

    int cnt = 0;

    for(int i = 1; i < N+1; i++) {
      if(visited[i] != 1){
        dfs(i);
        cnt++;
      }
    }

    System.out.println(cnt);
  }

  static void dfs(int i) {
    if(visited[i] == 1)
      return;
    
    visited[i] = 1;
    for(int j : arr[i]){
      if(visited[j] != 1) {
          dfs(j);
      }
    }
  }
}
