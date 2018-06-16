import java.awt.Color;
import java.awt.Graphics;

public class SquareWithCircles extends Shape {
	private int width;
	private int topLeftX;
	private int topLeftY;
	private int radius;
	
	
	public SquareWithCircles(Color c){
		super(c);//using the 'draw' method found in the 'Shape' class in order to determine the color of the square with circles.
	}
	
	
	@Override
	public void draw(Graphics g){//drawing the square with circles using sizes determined in the 'setSquareWithCircles' method found in the 'SlotMachinePanel' class.
		super.draw(g);
		g.drawRect(topLeftX, topLeftY, width, width);
		g.fillOval(topLeftX-radius/2, topLeftY+radius/2, radius, radius);
		g.fillOval(topLeftX+width-radius/2, topLeftY+radius/2, radius, radius);
	}

	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getTopLeftX() {
		return topLeftX;
	}


	public void setTopLeftX(int topLeftX) {
		this.topLeftX = topLeftX;
	}


	public int getTopLeftY() {
		return topLeftY;
	}


	public void setTopLeftY(int topLeftY) {
		this.topLeftY = topLeftY;
	}


	public int getRadius() {
		return radius;
	}


	public void setRadius(int radius) {
		this.radius = radius;
	}


	
	@Override
	public int compareTo(Object o) {
		if(o instanceof SquareWithCircles){//if the object 'o' is a square with circles and is the same color as 'this'-> return 0.
			if(super.compareTo(o) == 0);
			return 0;
		}
		return -1;
	}


	@Override
	public int getCenterX() {
		return topLeftX+width/2;
	}

	@Override
	public int getCenterY() {
		return topLeftY+width/2;
	}
}
	