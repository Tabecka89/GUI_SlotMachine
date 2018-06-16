import java.awt.Color;
import java.awt.Graphics;

public class FilledCircle extends Shape {
	private int radius;
	private int x;
	private int y;
	
	public FilledCircle(Color c){
		super(c);//using the 'draw' method found in the 'Shape' class in order to determine the color of the circle.
	}

		
	@Override
	public void draw(Graphics g){//drawing the circle using sizes determined in 'setFilledCircle' method found in the 'SlotMachinePanel' class.
		super.draw(g);
		g.fillOval(x-radius, y-radius, radius, radius);
		
	}
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int getCenterX() {
		return x;	
	}

	@Override
	public int getCenterY() {
		return y;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof FilledCircle){//if the object 'o' is a filled circle and is the same color as 'this'-> return 0.
			if(super.compareTo(o) == 0);
			return 0;
		}
		return -1;
	}
	
}

