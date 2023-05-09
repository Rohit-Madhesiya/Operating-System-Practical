import java.util.*;
import java.lang.*;

public class FCFS {
  public static void main(String[] args) {
    int[] arrival = { 2, 5, 1, 0, 4 };
    int[] burst = { 6, 2, 8, 3, 4 };
    for (int j = 0; j < arrival.length - 1; j++) {
      for (int i = 0; i < arrival.length - 1 - j; i++) {
        if (arrival[i] > arrival[i + 1]) {
          int temp = arrival[i];
          arrival[i] = arrival[i + 1];
          arrival[i + 1] = temp;
          temp = burst[i];
          burst[i] = burst[i + 1];
          burst[i + 1] = temp;
        }
      }
    }

    int[] gantt = new int[arrival.length + 1];
    gantt[0] = 0;
    for (int i = 1; i < arrival.length + 1; i++) {
      gantt[i] = gantt[i - 1] + burst[i - 1];
    }

    System.out.print("Gantt Chart are: ");
    for (int i = 0; i < gantt.length; i++)
      System.out.print(gantt[i] + " ");
    System.out.println();
    System.out.println("Table: ");
    System.out.println("Process | Arrival Time | Burst Time | Turn Around Time | Waiting Time | Completetion Time");
    int avgT = 0, avgW = 0;
    for (int i = 0; i < arrival.length; i++) {
      int tat = gantt[i + 1] - arrival[i];
      avgT += tat;
      int wt = tat - burst[i];
      avgW += wt;
      System.out.println("P" + i + "    |     " + arrival[i] + "    |     " + burst[i] + "    |     " + tat
          + "     |     " + wt + "    |     " + gantt[i + 1]);
    }
    System.out.println("Average Turn Around Time:   " + avgT / arrival.length + "m/sec.");
    System.out.println("Average Waiting Time:       " + avgW / arrival.length + "m/sec.");

  }
}