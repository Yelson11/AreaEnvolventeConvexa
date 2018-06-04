package aplicacion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CalculadorArea {

	public CalculadorArea() {
	}
    public ArrayList<Punto> executeQuickHull(ArrayList<Punto> inputPoints) {
        ArrayList<Punto> convexHull = new ArrayList<>();
        if (inputPoints.isEmpty()) {
            throw new IllegalArgumentException("Cannot compute convex hull of zero points.");
        }

        // search extreme values
        Punto rightmostPoint = inputPoints.get(0);
        Punto leftmostPoint = inputPoints.get(0);
        for (Punto point : inputPoints) {
            if (point.getPosX() < rightmostPoint.getPosX()) {
                rightmostPoint = point;
            } else if (point.getPosX() > leftmostPoint.getPosX()) {
                leftmostPoint = point;
            }
        }
        
        // divide the set into two halfes
        List<Punto> leftOfLine = new LinkedList<>();
        List<Punto> rightOfLine = new LinkedList<>();
        for (Punto point : inputPoints) {
            if (point.equals(rightmostPoint) || point.equals(leftmostPoint)) {
                continue;
            }
            if (point.isLeftOfLine(leftmostPoint, rightmostPoint)) {
                leftOfLine.add(point);
            } else {
                rightOfLine.add(point);
            }
        }
        
        convexHull.add(leftmostPoint);
        List<Punto> hull = divide(leftOfLine, leftmostPoint, rightmostPoint);
        convexHull.addAll(hull);
        convexHull.add(rightmostPoint);
        
        hull = divide(rightOfLine, rightmostPoint, leftmostPoint);
        convexHull.addAll(hull);
        
        
        return convexHull;
    }

    /**
     * Recursive implementation of QuickHull to find the furthest point to the line between the points p1
     * and p2 and divide the list of points. Caution: The points p1 and p2 must be in correct order so that
     * the points which are outside if the triangle furthest point - p1 - p2 are left of the viewing direction.
     * The viewing directions are as follow: p1 -> furthest point -> p2.
     * @param points The list of points
     * @param p1 
     * @param p2
     * @param convexHull A list of points which are on the convex hull.
     */
    private List<Punto> divide(List<Punto> points, Punto p1, Punto p2) {
        
        List<Punto> hull = new ArrayList<>();
        
        if (points.isEmpty()) {
            return hull;
        } else if (points.size() == 1) {
            hull.add(points.get(0));
            return hull;
        }
        
        Punto maxDistancePoint = points.get(0);
        List<Punto> l1 = new LinkedList<>();
        List<Punto> l2 = new LinkedList<>();
        double distance = 0.0;
        for (Punto point : points) {
            if (point.getDistanceToLine(p1, p2) > distance) {
                distance = point.getDistanceToLine(p1, p2);
                maxDistancePoint = point;
            }
        }
        
        points.remove(maxDistancePoint);
        
        for (Punto point : points) {
            if (point.isLeftOfLine(p1, maxDistancePoint)) {
                l1.add(point);
            } else if (point.isLeftOfLine(maxDistancePoint, p2)) {
                l2.add(point);
            }
        }
        
        points.clear();
        
        List <Punto> hullPart = divide(l1, p1, maxDistancePoint);
        hull.addAll(hullPart);
        hull.add(maxDistancePoint);
        hullPart = divide(l2, maxDistancePoint, p2);
        hull.addAll(hullPart);
        
        return hull;
    }
}
