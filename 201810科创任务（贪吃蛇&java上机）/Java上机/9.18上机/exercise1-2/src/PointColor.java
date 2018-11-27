
public class PointColor extends Point {
	private int greyscale; // [0, 255] from black to white

	// TODO: add a constructor for PointGrey
	PointColor(int x, int y, int tr, int tg, int tb) {
		px = x;
		py = y;
		r = tr;
		g = tg;
		b = tb;
		grey = (r + g + b) / 3;
	}

	@Override
	public double getDistance(Point p) {
		// TODO: fill this function up
		return Math.pow((Math.pow(super.px - p.px, 2) + Math.pow(super.py - p.py, 2)), 0.5); // to be replaced
	}

	@Override
	public int grayscaleDiff(Point p) {
		// TODO: fill this function up
		return super.grey - p.grey; // to be replaced
	}

}