package ClosestPair;

import java.util.*;
import java.util.List;

public class ClosestPair {

    // Algorithm 1 : To calculate minimum distance between 2D points (Nearest Neighbour Problem)
    // We are implementing the Closest Pair Algorithm

    /*
    1- Sort the points in each set based on their x-coordinate.
    2- Divide the sets into two equal-sized subsets based on the median x-coordinate.
    3- Recursively find the minimum distance in each subset.
    4- Determine the minimum distance, delta, among the two subsets.
    5- Consider the points that have an x-coordinate within delta distance from the median line.
    6- Sort these points based on their y-coordinate.
    7- Calculate the distance between each point and its seven neighbors.
    8- Update delta with the minimum distance found in this step.
    9- Return the final minimum distance.
     */

    // sort by x coordinate
    private void sortByX(List<Points> pointsList) {
        // Sort the list based on x-coordinate
        pointsList.sort(Comparator.comparingDouble(Points::getX));

    }

    private String printSortedX(List<Points> pointsList) {
        // Sort the list based on x-coordinate
        this.sortByX(pointsList);

        String idxs = "";
        for (Points p : pointsList) {
            idxs += p.getX() + ", ";
        }
        return idxs;
    }

    private double distance(double x1, double y1, double x2, double y2) {
        double euclidSum = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2); // raise to pow 2
        return Math.sqrt(euclidSum); // taking the square root
    }
    private double easyDist(Points p1, Points p2) {
        double euclidSum = Math.pow(p2.getX()-p1.getX(), 2) + Math.pow(p2.getY()-p1.getY(), 2); // raise to pow 2
        return Math.sqrt(euclidSum); // taking the square root
    }

    private int findMid(List<Points> points, int start, int end) {
        int mid = start + (end - 1) / 2;
        Points midPoint = points.get(mid);
        double midX = midPoint.getX();
        // System.out.println("middle x coord:" + midX + " at index: " + points.indexOf(midPoint));
        return mid;
    }

    private double findL(List<Points> arr) {
        int mid = findMid(arr, 0, arr.size());
        List<Points> leftHalf = arr.subList(0, mid + 1); // left<->mid
        List<Points> rightHalf = arr.subList(mid+ 1, arr.size()); // mid+1<->right

        double left1 = leftHalf.get(leftHalf.size() - 1).getX(); // last element in left
        double right1 = rightHalf.get(0).getX(); // first element in right

        return (left1 + right1) / 2;
    }

    private double precisionRound(double value, int places) {
//        double res = (double)Math.round(value * (10*places)d) / (10*places)d;
//        return res;
        return 0.0;
    }

    private double strip(Points[] deltaStrip, int size, double delta) {
        double mindist = delta;
        Arrays.sort(deltaStrip, 0, size, Comparator.comparingDouble(Points::getY));

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j <  size; j++) {
                if ((deltaStrip[j].getY() - deltaStrip[i].getY()) >= mindist) {
                    break;
                }
                if (easyDist(deltaStrip[i], deltaStrip[j]) < mindist) {
                    mindist = easyDist(deltaStrip[i], deltaStrip[j]);
                }
            }
        }
        return mindist;

    }

    // Closest Pair Algorithm Main Implementation
    private double minDist(List<Points> points) {
        // System.out.println("Before sort: " + points);
        sortByX(points);
        // System.out.println("After sort: " + points);

        double overallEuclideanDistance = 0.0;
        double xEuclidDist = 0.0;
        double yEuclidDist = 0.0;
        double DELTA = 0.0;

        List<Points> leftHalf;
        List<Points> rightHalf;
        List<Points> deltaStrip = new ArrayList<>();

        if (points.size() == 1) {
            DELTA = Double.POSITIVE_INFINITY;

        }
        else if (points.size() == 2) {
            double x1, y1, x2, y2;

            x1 = points.get(0).getX();
            y1 = points.get(0).getY();
            x2 = points.get(1).getX();
            y2 = points.get(1).getY();
            return distance(x1, y1, x2, y2);
//            System.out.println(DELTA + " " + x1 + " " + y1 + " " + " " + x2 + " " + y2);
        }
        // if number of points in the array exceed 2
        else {
            int mid = findMid(points, 0, points.size());
            Points[] middleCoord = new Points[]{points.get(mid)};
            leftHalf = points.subList(0, mid + 1); // left<->mid
            rightHalf = points.subList(mid+ 1, points.size()); // mid+1<->right

            double left1 = leftHalf.get(leftHalf.size() - 1).getX();
            double right1 = rightHalf.get(0).getX();

            double L = (left1 + right1) / 2;

            double RL = this.findL(rightHalf);

            double delta1 = minDist(leftHalf);
            double delta2 = minDist(rightHalf);
            DELTA = Math.min(delta1, delta2);
            //System.out.println(DELTA);

            for (int i = 0; i < points.size(); i++) {
                if ((Math.abs(points.get(i).getX() - middleCoord[0].getX()) < DELTA)) {
                    deltaStrip.add(points.get(i));
                }
            }
        }
        // return DELTA; // random val
        Points[] temp = deltaStrip.toArray(new Points[deltaStrip.size()]);

        overallEuclideanDistance = Math.min(DELTA, strip(temp, deltaStrip.size(), DELTA));
        return (double) Math.round(overallEuclideanDistance * 10000d) / 10000d;
    }

    public static void main(String[] args) {

        ClosestPair run = new ClosestPair();

        List<Points> a = new ArrayList<>();
        a.add(new Points(1.0, -6.0));
        a.add(new Points(-4.0, -1.0));
        a.add(new Points(4.0, -4.0));
        a.add(new Points(-3.0, 4.0));
        a.add(new Points(3.0, -2.0));
        a.add(new Points(-8.0, 0.0));
        a.add(new Points(0.0, -8.0));
        a.add(new Points(5.0, -3.0));


        run.sortByX(a);
        System.out.println(a);
        System.out.println("MIN DIST FOR BUFFER A: " + run.minDist(a));


    }
}

