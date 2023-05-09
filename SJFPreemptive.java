import java.util.*;

public class SJFPreemptive {
  static int minBT(List<Integer> ls) {
    int res = 0;
    for (int i = 1; i < ls.size(); i++) {
      if (ls.get(res) > ls.get(i) && ls.get(res) != 0 && ls.get(i) != 0)
        res = i;
    }
    return res;
  }

  static int countZero(List<Integer> ls) {
    int c = 0;
    for (Integer it : ls) {
      if (it == 0)
        c++;
    }
    return c;
  }

  public static void main(String[] args) {
    int[] pr = { 0, 1, 2, 4 };
    int[] bt = { 5, 3, 4, 1 };
    List<Integer> readyList = new ArrayList<>();
    List<Integer> pList = new ArrayList<>();
    int j = 0;
    for (int i = 0; i < pr.length; i++) {
      if (pr[j] == i) {
        readyList.add(bt[j]);
        j++;
      }
      int index = minBT(readyList);
      if (readyList.get(index) == 0) {
        break;
      }
      pList.add(pr[index]);
      readyList.set(index, readyList.get(index) - 1);
    }
    while (countZero(readyList) != readyList.size()) {

    }
  }
}
