import java.util.LinkedList;
import java.util.Deque;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    int time = 0;
    int totalWeight = 0;
    Deque<Integer> road = new ArrayDeque<>();
        
    for (int i = 0; i < bridge_length; i++) {
      road.addLast(0);
    }
    
    Queue<Integer> trucks = new LinkedList<>();
    for (int w : truck_weights) {
      trucks.add(w);
    }

    while ((!road.isEmpty())) {
      time++;
      int curWeight = road.pollFirst();
      totalWeight -= curWeight;

      if (trucks.isEmpty()) continue;
      
      if (totalWeight + trucks.peek() <= weight) {
        totalWeight += trucks.peek();
        road.addLast(trucks.poll());
      } else {
        road.addLast(0);
      }
    }
    return time;
  }
}