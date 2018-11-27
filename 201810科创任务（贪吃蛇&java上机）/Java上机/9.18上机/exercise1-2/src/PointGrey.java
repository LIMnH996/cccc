
public class PointGrey extends Point {
	private int greyscale; // [0, 255] from black to white

	// TODO: add a constructor for PointGrey
	PointGrey(int x, int y, int grey_t) {
		px = x;
		py = y;
		grey = grey_t;
	}

	@Override
	public double getDistance(Point p) {
		// TODO: fill this function up
		return Math.pow((Math.pow(super.px - p.px, 2) + Math.pow(super.py - p.py, 2)), 0.5); // to be replaced
	}

	@Override
	public int grayscaleDiff(Point p) {
		// TODO: fill this function up
		return 0; // to be replaced
	}

}