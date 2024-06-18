import java.util.*;
import java.io.*;

public class boj2667 {
  static int[][] visited; // 방문 체크 배열
  static int[][] grid; // 정사각형모양의 숫자들이 채워질 공간
  static int CntApt; // 아파트 수를 카운트하기 위한 변수
  static int Y[] = {1, -1, 0, 0}; //  Y 증감 확인 = 상, 하 확인
  static int X[] = {0, 0, 1, -1}; // X 증감 확인 = 우, 좌 확인
  static int MAX = 25 + 10; // 상하좌우 확인을 위해 최대값에 값을 조금 더 더해줌
  static int MIN = 5; // 최소값
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int cnt = Integer.parseInt(br.readLine());
    // 정사각형 길이, 입력 횟수
    if(cnt < 5 || cnt > 25)
      return;
    
    grid = new int[MAX][MAX];
    // 숫자들이 채워질 공간
    visited = new int[MAX][MAX];
    // 방문 체크 배열
    
    for(int i = 1; i <= cnt; i++) {
      String s = br.readLine(); // 각 줄 0과 1로 이루어진 cnt자리 숫자 입력
      for(int j = 1; j <= cnt; j++) {
        grid[i][j] = s.charAt(j - 1) -'0'; // 정사각형 공간에 순서대로 s의 각자리 입력.
        // charAt을 한 값은 char형이라서 - '0' 을 해준 후 자료형을 맞춰줌.
        // j-1을 하는 이유는 반복문 시작 값이 1이기 때문.
      }
    }// 이 과정 마친 후, 정사각형 배열 생성됨.
    
    ArrayList<Integer> countList = new ArrayList<Integer>();
    // 단지의 개수 확인 및 
    // 각 단지의 아파트 수 확인을 위한 ArrayList
    // ArrayList의 size => 단지의 개수
    // ArrayList의 값들 => 각 단지의 아파트 수
    
    for(int i = 1; i <= cnt; i++) {
      for(int j = 1; j <= cnt; j++) {
        if(grid[i][j] == 1 && visited[i][j] != 1) {
          //grid에 값이 있고, 방문확인배열이 비어있을 때
          CntApt = 0;
          dfs(i, j);
          countList.add(CntApt);
        }
      }
    }

    Collections.sort(countList);
  
    System.out.println(countList.size());

    for(int i = 0; i < countList.size(); i++) {
      System.out.println(countList.get(i));
    }
  }

  public static void dfs(int y, int x) {
    visited[y][x] = 1; // 매개변수로 들어온 좌표 방문 표시
    CntApt++; // 아파트 개수 증가 
    // 위 조건에서 정사각형에 값이 있고, 방문 체크 배열이 비어있을 때
    // 아래 조건에서도 정사각형에 값이 있고, 방문 체크 배열이 비어있을 때만 해당 함수 실행되기 때문.

    for(int i = 0; i < 4; i++) {
      int newY = y + Y[i]; // 상, 하 확인 
      int newX = x + X[i]; // 우, 좌 확인
      if(visited[newY][newX] != 1 && grid[newY][newX] ==1) {
        dfs(newY, newX); 
      }
    }
  }
}