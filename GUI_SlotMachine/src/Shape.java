import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements iDrawnShape, Comparable {
	
	private Color color;
	
	public Shape(Color c){
		this.color = c;
	}
	
	@Override
	public void draw(Graphics g){
		g.setColor(this.color);
	}
	
	@Override
	public int compareTo(Object o){
		if(this.color == ((Shape)o).color){
			return 0;
		}
		return -1;
	}
	
	public abstract int getCenterX();
	public abstract int getCenterY();
	
	

}
