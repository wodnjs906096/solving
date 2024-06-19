import java.util.*;
import java.io.*;

public class boj1012 {
  static int X[] = {0, 0, 1, -1};
  static int Y[] = {1, -1, 0, 0};
  static int field[][];
  static int visited[][];
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    for(int i = 0; i < N; i++) {
    int c = 0 ; 
    StringTokenizer st = new StringTokenizer(br.readLine());

    int length = Integer.parseInt(st.nextToken());
    int height = Integer.parseInt(st.nextToken());
    int cnt = Integer.parseInt(st.nextToken());
    
    if((length + height) > 100 && (length + height) < 1)
      return;

    field = new int[height+5][length+5];
    visited = new int[height+5][length+5];

    for(int j = 0; j < cnt; j++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      field[y+1][x+1] = 1;
    }

      for(int j = 1; j <= height; j++) {
        for(int k = 1; k <= length; k++) {
          if(visited[j][k] != 1 && field[j][k] == 1) {
              dfs(j, k);
              c++;
          }
        }
      }
      System.out.println(c);
    }
  }

  public static void dfs(int y, int x) {
    visited[y][x] = 1;

    for(int i = 0; i < 4; i++) {
      int newX = x + X[i];
      int newY = y + Y[i];

      if(visited[newY][newX] != 1 && field[newY][newX] == 1) {
        dfs(newY, newX);
      }
      }
    }
  }