package org.com2031.q2;

import java.util.*;

// Algorithm 2 : To calculate minimum distance between 2D points (Nearest Neighbour Problem)
// We are implementing the Closest Pair Algorithm
public class WeightedSchedule {

    // first sort the intervals
    private void sortIntervals(ArrayList<Interval> intervals) {
       intervals.sort(Comparator.comparingDouble(Interval::getFinish));
    }

    private int bisect_right(Integer[] A, int x, int lo, int hi) {
        int N = A.length;
        if (N == 0) {
            return 0;
        }
        if (x < A[lo]) {
            return lo;
        }
        if (x > A[hi - 1]) {
            return hi;
        }
        for (;;) {
            if (lo + 1 == hi) {
                return lo;
            }
            int mi = (hi + lo) / 2;
            if (x < A[mi]) {
                hi = mi;
            } else {
                lo = mi;
            }
        }
    }

    private int bisect_right(Integer[] A, int x) {
        return bisect_right(A, x, 0, A.length);
    }


    private ArrayList<Integer> previousIntervals(ArrayList<Interval> intervals, ArrayList<Integer> prevs) {
        ArrayList<Integer> startBuffer = new ArrayList<>();
        ArrayList<Integer> finishBuffer = new ArrayList<>();

        for (Interval i : intervals) {
            startBuffer.add(i.getStart());
        }
        for (Interval i : intervals) {
            finishBuffer.add(i.getFinish());
        }

        for (int i = 0; i < intervals.size(); i++) {
            // int idx = this.bi(finishBuffer.toArray(new Integer[finishBuffer.size()]), startBuffer.get(i)) - 1;
            int idx = this.bisect_right(finishBuffer.toArray(new Integer[finishBuffer.size()]), startBuffer.get(i)) - 1;
            prevs.add(idx);

        }
        return prevs;
    }

    private int calcOPT(int j, ArrayList<Interval> intervals, ArrayList<Integer> prevs, ArrayList<Integer> OPTIMAL_WEIGHTS) {
        if (j == -1) {
            return 0;
        }

        if (j < OPTIMAL_WEIGHTS.size()) {
            return OPTIMAL_WEIGHTS.get(j);
        }
        else {
            return Math.max(intervals.get(j).getWeight() + calcOPT(prevs.get(j), intervals, prevs, OPTIMAL_WEIGHTS), calcOPT(j-1,
                                                                                            intervals, prevs, OPTIMAL_WEIGHTS));
        }
    }

    private ArrayList<Integer> operateModified(ArrayList<Integer> newPrev, ArrayList<Integer> prevs) {
        System.out.println(prevs.size());
        for (int i = 0; i < prevs.size(); i++) {
            newPrev.add(prevs.get(i) + 1);
        }
        return newPrev;
    }

    private ArrayList<Integer> getIntervalWeights(ArrayList<Interval> intervals, ArrayList<Integer> prevs, ArrayList<Integer> OPTIMAL_WEIGHTS, ArrayList<Interval> bestJobs) {

        if (intervals.isEmpty()) {
            return new ArrayList<>();
        }
        if (intervals.size() == 1) {
            ArrayList<Integer> buffer = new ArrayList<>();
            buffer.add(intervals.get(0).getWeight());
            return buffer;
        }

        int i = 0;
        for (int j = 0; j < intervals.size(); j++) {
            int opt_j = this.calcOPT(j, intervals, prevs, OPTIMAL_WEIGHTS);
            OPTIMAL_WEIGHTS.add(opt_j);
        }
        return OPTIMAL_WEIGHTS;
    }


    private String outputArray(ArrayList<Interval> intervals) {
        String s = "";
        for (Interval i : intervals) {
            s += "(START: " + i.getStart() + ", FINISH: " + i.getFinish() + ", WEIGHT: " + i.getWeight() + ")" + "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        ArrayList<Interval> temp = new ArrayList<>();

         // my points

        temp.add(new Interval(15, 19, 7));
        temp.add(new Interval(5, 9, 7));
        temp.add(new Interval(5, 7, 6));
        temp.add(new Interval(15, 18, 3));
        temp.add(new Interval(5, 8, 8));
        temp.add(new Interval(14, 17, 7));
        temp.add(new Interval(13, 15, 4));
        temp.add(new Interval(12, 14, 5));


        ArrayList<Integer> prevs = new ArrayList<>();
        ArrayList<Integer> WEIGHTS = new ArrayList<>();
        ArrayList<Interval> bestJobs = new ArrayList<>();


        WeightedSchedule run = new WeightedSchedule();

        run.sortIntervals(temp);

        ArrayList<Integer> buffer = run.previousIntervals(temp, prevs);
        System.out.println("PREVIOUS: " + buffer);

        System.out.println("WEIGHTS: "  + run.getIntervalWeights(temp, prevs, WEIGHTS, bestJobs));

    }
}
