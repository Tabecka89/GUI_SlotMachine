import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {
	private int width;
	private int TopLeftX;
	private int TopLeftY;
	
	public Square(Color c){
		super(c);
	}
	
	@Override
	public void draw(Graphics g){
		super.draw(g);//using the 'draw' method found in the 'Shape' class in order to determine the color of the square.
		g.drawRect(TopLeftX, TopLeftY, width, width);//drawing the square using the sizes determined in the 'setSquares' method found in the 'SlotMachinePanel' class.
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}

	public int getTopLeftX() {
		return TopLeftX;
	}

	public void setTopLeftX(int TopLeftX) {
		this.TopLeftX = TopLeftX;
	}

	public int getTopLeftY() {
		return TopLeftY;
	}

	public void setTopLeftY(int TopLeftY) {
		this.TopLeftY = TopLeftY;
	}

	@Override
	public int getCenterX(){
		int CenterX = TopLeftX+(width/2);
		return CenterX;
	}
	
	@Override
	public int getCenterY(){
		int CenterY = TopLeftY+(width/2);
		return CenterY;
		
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Square){//if the object 'o' is a square and is the same color as 'this'-> return 0.
			if(super.compareTo(o) == 0);
			return 0;
		}
		return -1;
	}
}
