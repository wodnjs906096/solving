import java.util.*; 

class Programmers_immigration {
public long solution(int n, int[] times) {
    long min_time = 1;

    Arrays.sort(times);

    long left = 1;
    long right = (long) n * times[0];

    while (left <= right) {
      long mid = (left + right) / 2;
      long immigrated = 0;
      for (int i = 0; i < times.length; i++) {
        immigrated += (mid / times[i]);
      }
      if (n > immigrated) {
        left = mid + 1;
      } else {
        right = mid - 1;
        min_time = mid;
      }
    }

    return min_time;
  }
}