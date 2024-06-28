import java.util.*;
import java.io.*;

public class boj2875 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
  
    int female = Integer.parseInt(st.nextToken());
    int male = Integer.parseInt(st.nextToken());
    int cant = Integer.parseInt(st.nextToken());

    int can = 0;

    while(true) {
      if(female >= 2 && male >= 1 && (female+male) - cant >= 3){ 
        female -= 2;
        male -= 1;
        can++;
      }
      else{
        break;
      }
  }
   System.out.println(can);
}
}