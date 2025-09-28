import java.util.Arrays;
import java.util.Comparator;

class ClosestPair {

    // point class to represent a 2D point
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // for sorting points based on x
        public static Comparator<Point> XComparator = new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return Integer.compare(p1.x, p2.x);
            }
        };

        // for sorting points based on y
        public static Comparator<Point> YComparator = new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return Integer.compare(p1.y, p2.y);
            }
        };
    }

    // function to calculate the distance between two points
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    // function to find the closest pair of points in a strip
    public static double stripClosest(Point[] strip, double d) {
        double min = d;
        int size = strip.length;

        // check points in the strip within a distance d
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; j++) {
                min = Math.min(min, distance(strip[i], strip[j]));
            }
        }

        return min;
    }

    // recursive function to find the closest pair of points
    public static double closestUtil(Point[] points, Point[] temp, int left, int right) {
        if (right - left <= 3) {
            double min = Double.MAX_VALUE;
            for (int i = left; i <= right; i++) {
                for (int j = i + 1; j <= right; j++) {
                    min = Math.min(min, distance(points[i], points[j]));
                }
            }
            return min;
        }

        int mid = (left + right) / 2;
        Point midPoint = points[mid];

        // recursively find the closest pair in both halves
        double dl = closestUtil(points, temp, left, mid);
        double dr = closestUtil(points, temp, mid + 1, right);

        // find the minimum distance from the two halves
        double d = Math.min(dl, dr);

        // copy points to temp and sort by y
        System.arraycopy(points, left, temp, left, right - left + 1);
        Arrays.sort(temp, left, right + 1, Point.YComparator);

        // check the strip area for possible closer pairs
        return Math.min(d, stripClosest(temp, d));
    }

    // main function to find the closest pair of points
    public static double closestPair(Point[] points) {
        // sort the points by x-coordinate
        Point[] temp = new Point[points.length];
        Arrays.sort(points, Point.XComparator);

        // call the recursive function
        return closestUtil(points, temp, 0, points.length - 1);
    }

    public static void main(String[] args) {
        // input points
        Point[] points = new Point[]{
                new Point(2, 3),
                new Point(12, 30),
                new Point(40, 50),
                new Point(5, 1),
                new Point(12, 10),
                new Point(3, 4)
        };

        // find the closest pair of points
        System.out.println("The closest pair distance is: " + closestPair(points));
    }
}
