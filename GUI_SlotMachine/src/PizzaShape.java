import java.awt.Color;
import java.awt.Graphics;

public class PizzaShape extends Shape {
	private int pizzaCenterX;
	private int pizzaCenterY;
	private int radius;
	private int angle1;
	private int angle2;
	
	
	
	
	public PizzaShape(Color c){//using the 'draw' method found in the 'Shape' class in order to determine the color of the pizza shape.
		super(c);
	}

	@Override
	public void draw(Graphics g){//drawing the square with circles using sizes determined in the 'setPizzaShape' method found in the 'SlotMachinePanel' class.
		super.draw(g);
		for(int i = 0; i < 360; i+=40){
			g.fillArc(pizzaCenterX-radius, pizzaCenterY-radius, radius, radius, angle1+i, angle2);
		}
	}
	
	
	public int getPizzaCenterX() {
		return pizzaCenterX;
	}


	public void setPizzaCenterX(int pizzaCenterX) {
		this.pizzaCenterX = pizzaCenterX;
	}


	public int getPizzaCenterY() {
		return pizzaCenterY;
	}


	public void setPizzaCenterY(int pizzaCenterY) {
		this.pizzaCenterY = pizzaCenterY;
	}


	public int getRadius() {
		return radius;
	}


	public void setRadius(int radius) {
		this.radius = radius;
	}


	public int getAngle1() {
		return angle1;
	}


	public void setAngle1(int angle1) {
		this.angle1 = angle1;
	}


	public int getAngle2() {
		return angle2;
	}


	public void setAngle2(int angle2) {
		this.angle2 = angle2;
	}


	@Override
	public int getCenterX() {
		return pizzaCenterX;
	}

	@Override
	public int getCenterY() {
		return pizzaCenterY;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof PizzaShape){//if the object 'o' is a pizza shape and is the same color as 'this'-> return 0.
			if(super.compareTo(o) == 0);
			return 0;
		}
		return -1;
	}
}
