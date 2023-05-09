import java.util.Arrays;

public class SJF {
  // with Non-Preemption
  public static void non_preemptiveSJF() {
    int n = 5;
    int[] at = { 0, 1, 2, 3, 4 };
    int[] bt = { 4, 3, 1, 2, 6 };
    int[] gantt = new int[n + 1];
    // sorting accor. to burst time
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n - i - 1; j++) {
        if (bt[j] > bt[j + 1]) {
          int temp = bt[j];
          bt[j] = bt[j + 1];
          bt[j + 1] = temp;
          temp = at[j];
          at[j] = at[j + 1];
          at[j + 1] = temp;
        }
      }
    }

    gantt[0] = 0;
    gantt[1] = bt[0];
    for (int i = 1; i < n; i++) {
      gantt[i + 1] = gantt[i] + bt[i];
    }
    System.out.println("Gantt Chart: " + Arrays.toString(gantt));
    System.out.println("Process | Arrival Time | Burst Time | Waiting Time | Turn Around Time");
    int awt = 0, atat = 0;
    for (int i = 0; i < n; i++) {
      int tat = gantt[i + 1] - at[i];
      int wt = tat - bt[i];
      awt += wt;
      atat += tat;
      System.out.println("P" + (at[i] + 1) + "   |   " + at[i] + "   |   " + bt[i] + "   |   " + wt + "   |   " + tat);
    }
    System.out.println("Average Turn Around Time: " + atat / n);
    System.out.println("Average Waiting Time: " + awt / n);
  }

  // With Preemption
  // static int min(int bt[]) {
  // int t = 0;
  // for (int i = 1; i < bt.length; i++) {
  // if (bt[t] > bt[i] && bt[t] != 0)
  // t = i;
  // }
  // if (bt[t] <= 0)
  // return -1;
  // return t;
  // }

  // public static void preemptiveSJF() {
  // int n = 4;
  // int[] at = { 0, 1, 2, 4 };
  // int[] bt = { 5, 3, 4, 1 };
  // int limit = 0;
  // // sorting accord. to burst time and counting burst time
  // for (int i = 0; i < n; i++) {
  // limit += bt[i];
  // for (int j = 0; j < n - 1; j++) {
  // if (bt[j] > bt[j + 1]) {
  // int temp = bt[j];
  // bt[j] = bt[j + 1];
  // bt[j + 1] = temp;
  // temp = at[j];
  // at[j] = at[j + 1];
  // at[j + 1] = temp;
  // }
  // }
  // }
  // System.out.println("Arrival Time: " + Arrays.toString(at));
  // System.out.println(limit + "\nBurst Time: " + Arrays.toString(bt));
  // int[] gantt = new int[limit];
  // gantt[0] = 0;
  // for (int i = 1; i < limit; i++) {
  // int k = min(bt);
  // if (k == -1)
  // break;
  // gantt[i] = at[k];
  // bt[k]--;
  // }

  // System.out.println("gantt Chart: " + Arrays.toString(gantt));

  // }

  public static void main(String[] args) {
    non_preemptiveSJF();
    // preemptiveSJF();
  }
}
