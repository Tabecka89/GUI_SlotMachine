import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SlotMachinePanel extends JPanel implements iSlotMachine {

	private final static double SLOT_MACHINE_WIDTH_FRACTION = 0.8;
	private final static int RADIUS_DIVISOR = 6;
	private final static double SLOT_MACHINE_HEIGHT_DIVISOR = 1.4;

	private Square mainMachineCell = new Square(Color.black);
	private Square rightCell = new Square(Color.black);
	private Square leftCell = new Square(Color.black);
	private Square midCell = new Square(Color.black);
	private Random rand = new Random();//creating a random object
	//creating three Integers to hold the random values generated using the 'rand' variable
	private int num1;
	private int num2;
	private int num3;
	private JLabel label = new JLabel();//creating a label used for winning or losing the game
	private int state;//creating a state variable to determine whether to draw the shapes or just the empty squares (for 1st run)
	
	public SlotMachinePanel(int state) {//constructor to initialize the state and add the label
		this.state = state;
		this.add(label);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		this.setLayout(new BorderLayout());
		int panelWidth = getWidth();
		int panelHeight = getHeight();

		// get the shortest length when resized
		int minPanelLength = Math.min(panelWidth, panelHeight);

		double slotMachineWidth = minPanelLength * SLOT_MACHINE_WIDTH_FRACTION;

		int xCenter = panelWidth / 2;
		int yCenter = panelHeight / 2;

		// set the squares for the slot machine skeleton
		setSquares((int) slotMachineWidth, xCenter, yCenter);

		g.setColor(Color.black);

		mainMachineCell.draw(g);
		leftCell.draw(g);
		rightCell.draw(g);
		midCell.draw(g);

		
		switch(this.state){//switch case for the 'state' variable
		
			case 1://if state is 1 -> create 3 shapes using random numbers and place each one in a cell							
				
				Shape shape1 = createShape(this.num1, leftCell);
				Shape shape2 = createShape(this.num2, midCell);
				Shape shape3 = createShape(this.num3, rightCell);
				
				//draw the shapes
				shape1.draw(g);
				shape2.draw(g);
				shape3.draw(g);
				
				//if all shapes are the same-> add appropriate text and set it to the bottom center of the panel
				if (shape1.compareTo(shape2) == 0 && shape1.compareTo(shape3) == 0) {
					label.setText("You Won!");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					label.setVerticalAlignment(SwingConstants.BOTTOM);
					this.add(label);
				}
				//if at least one shape is'nt similar-> add appropriate text and set it to the bottom center of the panel
				else{
					label.setText("You Lost!");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					label.setVerticalAlignment(SwingConstants.BOTTOM);
					this.add(label);
				}
				
			default:
				break;
		}
	}

	private void setSquares(int slotMachinLength, int xCenter, int yCenter) {

		mainMachineCell.setWidth(slotMachinLength);
		mainMachineCell.setTopLeftX(xCenter - (slotMachinLength / 2));
		int mainBottomY = yCenter - slotMachinLength / 2;
		mainMachineCell.setTopLeftY((int) (mainBottomY / SLOT_MACHINE_HEIGHT_DIVISOR));

		//the code between lines 101-111 is used to determine the attributes of the cells. All of the sizes i used correspond with the size of the main cell in order to keep proportions.
		leftCell.setWidth(mainMachineCell.getWidth() / 4);
		leftCell.setTopLeftX(mainMachineCell.getTopLeftX() + slotMachinLength / 16);
		leftCell.setTopLeftY(mainMachineCell.getTopLeftY() + slotMachinLength / 16);

		rightCell.setWidth(mainMachineCell.getWidth() / 4);
		rightCell.setTopLeftX(xCenter + slotMachinLength / 2 - rightCell.getWidth() - slotMachinLength / 16);
		rightCell.setTopLeftY(mainMachineCell.getTopLeftY() + slotMachinLength / 16);

		midCell.setWidth(mainMachineCell.getWidth() / 4);
		midCell.setTopLeftX(xCenter - midCell.getWidth() / 2);
		midCell.setTopLeftY(mainMachineCell.getTopLeftY() + slotMachinLength / 16);

	}

	/**
	 * sets a FilledCircle size to fit the center of a cell
	 */
	public Shape createShape(int index, Square cell) {

		switch (index) {
		case 0:
			FilledCircle fc = new FilledCircle(Color.RED);
			setFilledCircle(fc, cell);
			return fc;

		case 1:
			SquareWithCircles swc = new SquareWithCircles(Color.BLACK);
			setSquareWithCircles(swc, cell);
			return swc;

		case 2:
			PizzaShape ps = new PizzaShape(Color.orange);
			setPizza(ps, cell);
			return ps;

		}

		return null;

	}

	/**
	 * sets a FilledCircle size to fit the center of a cell
	 */
	private void setFilledCircle(FilledCircle fc, Square cell) {

		int radius = (int) (cell.getWidth() / 3);
		fc.setRadius(radius);
		fc.setX(cell.getCenterX() + radius / 2);
		fc.setY(cell.getCenterY() + radius / 2);
	}

	/**
	 * sets a PizzaShape size to fit the center of a cell
	 */
	private void setPizza(PizzaShape ps, Square cell) {
		//determining attributes of a pizza shape, considering the size and location of the cell in order to keep proportions.
		int radius = cell.getWidth() / 3;
		ps.setRadius(radius);
		ps.setPizzaCenterX(cell.getCenterX() + radius / 2);
		ps.setPizzaCenterY(cell.getCenterY() + radius / 2);
		ps.setAngle1(0);
		ps.setAngle2(30);
	}

	/**
	 * sets a SquareWithCircles size to fit the center of a cell
	 */
	private void setSquareWithCircles(SquareWithCircles swc, Square cell) {
		//determining attributes of a square with circles, considering the size and location of the cell in order to keep proportions.
		int radius = cell.getWidth() / RADIUS_DIVISOR;
		swc.setRadius(radius);
		swc.setWidth(cell.getWidth() / 3);
		swc.setTopLeftX(cell.getCenterX() - swc.getWidth()/2);
		swc.setTopLeftY(cell.getCenterY() - swc.getWidth()/2);
	}

	@Override
	public void play() {
		//initializing num1,2,3 with random Integers between 0-2, and then calling repaint method in order to draw the panel again.
		this.num1 = rand.nextInt(3);
		this.num2 = rand.nextInt(3);
		this.num3 = rand.nextInt(3);
		this.repaint();
	}
	
	public void setState(int state){
		this.state = state;
	}
}
