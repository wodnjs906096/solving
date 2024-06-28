import java.util.*;
import java.io.*;

public class boj10601 {
  static int MAX = 10000;
  static int MIN = 1;
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String num = br.readLine();
    // 1만 자리수는 어떤 정수형으로도 받을 수 없어서
    // String으로 받아준 것.
    
    int charAt[] = new int[num.length()];
    // 각 자리 숫자를 받아줄 배열
    
    int sum = 0;
    // 각 자리 수의 합
    
    if(num.length() > MAX && num.length() <= MIN)
      return;
    // 1자리면 안되고, 10000자리 넘어도 안됨.

    for(int i = 0; i < num.length(); i++) {
      charAt[i] = num.charAt(i) - '0';
      // - '0' 해줌으로써 형변환.
      sum += charAt[i];
    }

    Arrays.sort(charAt); // 오름차순 정렬

    if((sum % 3 == 0) && (charAt[0] == 0)){
    // 각 자리 수를 다 더해서 3으로 나누어 떨어지고
    // 0이 있어야 10의 배수가 되기 때문에
    // 둘 다 만족해야 30의 배수가 되는 것.
      for(int i = charAt.length - 1; i > -1; i--) {
        System.out.print(charAt[i]);
        // 성립하는 경우에는 가장 큰 수 부터 출력하면
        // 그게 가장 큰 수가 되는 것.
      }
    } else {
      System.out.println(-1);
    }

  }
}