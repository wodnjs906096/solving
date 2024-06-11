import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.lang.StringBuilder;

public class boj1158{
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    LinkedList<Integer> list = new LinkedList<Integer>(); 
    
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int index = 0;

    sb.append("<");
    
    for(int i = 1; i <= n; i++) 
      list.add(i);

    for(int i = 0; i < n; i++) {
      index = (index + k - 1 ) % list.size();
      if(list.size() != 1) 
      sb.append(list.get(index) + ", ");

      else
        sb.append(list.get(index));
      
      list.remove(index);
    }

    sb.append(">");

    System.out.println(sb);
  }
}