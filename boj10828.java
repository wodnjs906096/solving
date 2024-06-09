import java.util.Stack;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class boj10828 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Stack<Integer> stk = new Stack<Integer>();
    int cnt = Integer.parseInt(br.readLine());

    for (int i = 0; i < cnt; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      String cmd = st.nextToken();

      if (cmd.equals("push")) {
        stk.push(Integer.parseInt(st.nextToken()));
      } else if (cmd.equals("pop")) {
        if (stk.isEmpty())
          System.out.println(-1);
        else
          System.out.println(stk.pop());
      } else if (cmd.equals("size")) {
        System.out.println(stk.size());
      } else if (cmd.equals("empty")) {
        if (stk.isEmpty())
          System.out.println(1);
        else
          System.out.println(0);
      } else if (cmd.equals("top")) {
        if (stk.isEmpty())
          System.out.println(-1);
        else
          System.out.println(stk.peek());
      }
    }
  }
}