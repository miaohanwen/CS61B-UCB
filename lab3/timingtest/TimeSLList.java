package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        int adds[] = {1000,2000,4000,8000,16000,32000,64000,128000};
        AList<Integer> Ns=new AList<>();
        AList<Double> times=new AList<>();
        AList<Integer> opCounts=new AList<>();
        int op = 10000;
        int item = 1;
        for (int i=0;i<adds.length;i++){
            SLList<Integer> test = new SLList<>();

            for (int j=0;j<adds[i];j++){
                test.addLast(item);
            }
            Stopwatch sw = new Stopwatch();
            for (int j=0;j<op;j++){
                int last = test.getLast();
            }
            double timeInSeconds = sw.elapsedTime();

            Ns.addLast(adds[i]);
            times.addLast(timeInSeconds);
            opCounts.addLast(op);
        }
        printTimingTable(Ns, times, opCounts);
    }

}
