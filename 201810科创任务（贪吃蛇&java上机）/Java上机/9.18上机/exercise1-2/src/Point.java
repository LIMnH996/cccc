
public abstract class Point {
	public int px; // position in x
	public int py; // position in y\
	public int grey;
	public int r;
	public int g;
	public int b;

	/*
	 * Return the euclidean distance between this point and another point p
	 * 
	 * @param p another point
	 * 
	 * @return the euclidean distance
	 */
	public abstract double getDistance(Point p);

	/*
	 * Return the difference in grayscale between this point and another point p
	 * 
	 * @param p another point
	 * 
	 * @return the grayscale difference
	 */
	public abstract int grayscaleDiff(Point p);

}
