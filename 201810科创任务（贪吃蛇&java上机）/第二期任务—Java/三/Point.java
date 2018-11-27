
public abstract class Point {
	private int px; // position in x
	private int py; // position in y
	
	/*
	 * Return the euclidean distance between this point 
	 * and another point p
	 * @param p another point
	 * @return the euclidean distance
	 */
	public abstract double getDistance(Point p);
	
	/*
	 * Return the difference in grayscale between this point 
	 * and another point p
	 * @param p another point
	 * @return the grayscale difference
	 */
	public abstract int grayscaleDiff(Point p);

}
