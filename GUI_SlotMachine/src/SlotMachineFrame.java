import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SlotMachineFrame extends JFrame implements ActionListener {
	private SlotMachinePanel p;//created a panel as an attribute in order to access 'SlotMachinePanel' class from the action method

		public SlotMachineFrame(int w, int h){
			this.setLayout(new BorderLayout());
			JButton playButton = new JButton("Play");
			p = new SlotMachinePanel(0);//creating a new panel with 0 state
			
			this.add(p);
			this.add(playButton, BorderLayout.WEST);
			playButton.addActionListener(this);
			this.setSize(w, h);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setAlwaysOnTop(true);
			this.setVisible(true);
		}

	public void actionPerformed(ActionEvent e) {//an action method regarding the event of a button being clicked
		p.setState(1);//changing the state in the 'SlotMachinePanel' class in order to show the graphic shapes
		p.play();//calling play method on the event of the 'Play' button being clicked
	}
}
	
