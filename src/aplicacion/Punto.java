package aplicacion;

public class Punto {
	private static final double DOUBLE_DELTA = 1E-10;
	private int posX;
	private int posY;
	
	public Punto(int pX, int pY) {
		posX = pX;
		posY = pY;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	 private double calcCrossProduct(Punto origin, Punto p2) {
	        return (p2.posX - origin.posX) * (this.posY - origin.posY)
	                - (p2.posY - origin.posY) * (this.posX - origin.posX);
	    }

	    /**
	     * A point is considered left of a line between points from and to if it is
	     * on the lefthand side when looking along the line from point "from" to
	     * point "to".
	     *
	     * The method uses the cross-product to determine if this point is left of
	     * the line.
	     *
	     * @param from Point from which the line is drawn and from where we "look"
	     * along the line in direction of point "to" to determine whether the point
	     * is left or right of it.
	     * @param to Point to which the line is drawn
	     */
	    public boolean isLeftOfLine(Punto from, Punto to) {
	        return Double.compare(calcCrossProduct(from, to), 0) > 0;
	    }

	    /**
	     * This point is considered collinear if it lies on a straight line between
	     * the two given points.
	     *
	     * The method uses the cross-product to determine if that's the case.
	     *
	     * @param p2
	     * @param reference
	     * @return true if point is collinear, false otherwise
	     */
	    public boolean isCollinearTo(Punto p2, Punto reference) {
	        return Math.abs(0.0 - calcCrossProduct(reference, p2)) < DOUBLE_DELTA;
	    }

	    /**
	     * Calculates the distance to given point.
	     *
	     * @param p2 Point to calculate the distance to.
	     * @return The distance of this point to given point.
	     */
	    public double getDistance(Punto p2) {
	        return Math.sqrt((this.posX - p2.posX) * (this.posX - p2.posX)
	                + (this.posY - p2.posY) * (this.posY - p2.posY));
	    }

	    @Override
	    public String toString() {
	        return "(" + this.posX + ", " + this.posY + ")";
	    }

	    @Override
	    public int hashCode() {
	        int hash = 3;
	        hash = 37 * hash + (int) (Double.doubleToLongBits(this.posX) ^ (Double.doubleToLongBits(this.posX) >>> 32));
	        hash = 37 * hash + (int) (Double.doubleToLongBits(this.posY) ^ (Double.doubleToLongBits(this.posY) >>> 32));
	        return hash;
	    }

	    /**
	     * {@inheritDoc }
	     */
	    @Override
	    public boolean equals(Object o) {
	        if (o == null || !o.getClass().equals(this.getClass())) {
	            return false;
	        }
	        if (o == this) {
	            return true;
	        }
	        Punto other = (Punto) o;
	        return Math.abs(this.posX - other.posX) < DOUBLE_DELTA
	                && Math.abs(this.posY - other.posY) < DOUBLE_DELTA;
	    }

	    /**
	     * Calculates the distance of this point to the line which is formed by points a and b.
	     * @param a
	     * @param b
	     * @return The distance to the line.
	     */
	    public double getDistanceToLine(Punto a, Punto b) {
	        return Math.abs((b.getPosX() - a.getPosX()) * (a.getPosY() - this.posY) - (a.getPosX() - this.posX) * (b.getPosY() - a.getPosY()))
	                / Math.sqrt(Math.pow(b.getPosX() - a.getPosX(), 2) + Math.pow(b.getPosY() - a.getPosY(), 2));
	    }
	
	
}
