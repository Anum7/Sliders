import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SliderAnswer {
	public static void main(String[] args){
		JFrame frame = new JFrame("Style Options");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MixedOptionsPanel());
		frame.pack();
		frame.setVisible(true);
	}
}



class MixedOptionsPanel extends JPanel{
	private JLabel saying;
	private JCheckBox bold;
	private JCheckBox italic;
	private JSlider slide;
//-----------------------------------------------------------------
// Sets up a panel with a label and some check boxes that
// control the style of the label's font.
//-----------------------------------------------------------------
	public MixedOptionsPanel(){
		saying = new JLabel("Say it with style!");
		saying.setFont(new Font("Helvetica", Font.PLAIN, 32));
		bold = new JCheckBox("Bold");
		bold.setBackground(Color.cyan);
		italic = new JCheckBox("Italic");
		italic.setBackground(Color.cyan);
		slide= new JSlider(JSlider.HORIZONTAL,0,72,36);
		slide.setMajorTickSpacing(10);
		slide.setMinorTickSpacing(3);
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);
		slide.setAlignmentX(Component.LEFT_ALIGNMENT);
		StyleListener listener = new StyleListener();
		bold.addItemListener(listener);
		italic.addItemListener(listener);
		slide.addChangeListener(listener);
		add(slide);
		add(saying);
		add(bold);
		add(italic);
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(300, 100));
	}
private class StyleListener implements ItemListener, ChangeListener{
	//--------------------------------------------------------------
	// Updates the style of the label font style.
	//--------------------------------------------------------------
	private int style, font;
	public void itemStateChanged(ItemEvent event){
		if (font==0){
			font=32;
		}
		style = Font.PLAIN;
		if (bold.isSelected())
			style = Font.BOLD;
		if (italic.isSelected())
			style += Font.ITALIC;
		saying.setFont(new Font("Helvetica", style, font));
		}
	public void stateChanged(ChangeEvent event){
		font=slide.getValue();
		saying.setFont(new Font("Helvetica", style, font));
	}
	}
}