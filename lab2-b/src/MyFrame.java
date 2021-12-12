import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	
	static final long serialVersionUID =1;
	
	private static final int WIDTH = 400;
	private static final int HEIGHT = 320;
	
	private static double mem1=0;
	private static double mem2=0;
	private static double mem3=0;
	private Double result;
	
	private JTextField textField;
	
	private JTextField textFieldResult;
	
	private ButtonGroup radioButtons = new ButtonGroup();
	private ButtonGroup setVar = new ButtonGroup();
	
	private Box hboxFormulaType = Box.createHorizontalBox();
	private int formulaId = 1;
	
	private Box setVarButton = Box.createHorizontalBox();
	
	public Double calculate1(Double x, Double y, Double z) {
		//return Math.sin(Math.log(y)+Math.sin(Math.PI*y*y))*Math.pow(x*x+Math.sin(z)+Math.pow(Math.E, Math.cos(z)), 0.25);
		return x+y+z;
	}
	
	public Double calculate2(Double x, Double y, Double z) {
		return Math.pow(Math.cos(Math.pow(Math.E, x))+Math.log((1+y)*(1+y))+Math.sqrt(Math.pow(Math.E, Math.cos(x))+Math.pow(Math.sin(Math.PI*z), 2))+Math.sqrt(1/x)+Math.cos(y*y), Math.sin(z));
	}
	
	private void addRadioButton(String buttonName, final int formulaId) {
		JRadioButton button = new JRadioButton(buttonName);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					MyFrame.this.formulaId = formulaId;
					}
			});
		radioButtons.add(button);
		hboxFormulaType.add(button);
	}
	
	public MyFrame() {
	super("Вычисление формулы");
	setSize(WIDTH, HEIGHT);
	Toolkit kit = Toolkit.getDefaultToolkit();
	
	setLocation((kit.getScreenSize().width - WIDTH)/2,
	(kit.getScreenSize().height - HEIGHT)/2);
	
	hboxFormulaType.add(Box.createHorizontalGlue());
	addRadioButton("Формула 1", 1);
	addRadioButton("Формула 2", 2);
	radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
	hboxFormulaType.add(Box.createHorizontalGlue());
	
	hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
	JLabel labelFor = new JLabel("");
	textField = new JTextField("0", 10);
	textField.setMaximumSize(textField.getPreferredSize());
	Box hboxVariables = Box.createHorizontalBox();
	
	setVarButton.add(Box.createHorizontalGlue());
	JRadioButton X = new JRadioButton("X", true);
	setVar.add(X);
	setVarButton.add(X);
	JRadioButton Y = new JRadioButton("Y", false);
	setVar.add(Y);
	setVarButton.add(Y);
	JRadioButton Z = new JRadioButton("Z", false);
	setVar.add(Z);
	setVarButton.add(Z);
	radioButtons.setSelected(setVar.getElements().nextElement().getModel(), true);
	setVarButton.add(Box.createHorizontalGlue());
	
	hboxVariables.setBorder(BorderFactory.createLineBorder(Color.RED));
	hboxVariables.add(Box.createHorizontalGlue());
	hboxVariables.add(labelFor);
	hboxVariables.add(Box.createHorizontalStrut(10));
	hboxVariables.add(textField);
	hboxVariables.add(Box.createHorizontalGlue());

	JLabel labelForResult = new JLabel("Результат:");
	textFieldResult = new JTextField("0", 10);
	textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());
	
	Box hboxResult = Box.createHorizontalBox();
	hboxResult.add(Box.createHorizontalGlue());
	hboxResult.add(labelForResult);
	hboxResult.add(Box.createHorizontalStrut(10));
	hboxResult.add(textFieldResult);
	hboxResult.add(Box.createHorizontalGlue());
	hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
	
	X.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ev) {
			mem1=Double.parseDouble(textField.getText());
		}
	});
	Y.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ev) {
			mem2=Double.parseDouble(textField.getText());
		}
	});
	Z.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ev) {
			mem3=Double.parseDouble(textField.getText());
		}
	});
	
	JButton MC = new JButton("MC");
	MC.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ev) {
			if((X.isSelected())) {
				mem1=0;
			}
			else if((Y.isSelected())) {
				mem2=0;
			}
			else if((Z.isSelected())) {
				mem3=0;
			}
			textField.setText("0");
			textFieldResult.setText("0");
		}
	});
	
	JButton buttonCalc = new JButton("Вычислить");
	buttonCalc.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ev) {
			try {
				if (formulaId==1)
					result = calculate1(mem1, mem2, mem3);
				else
					result = calculate2(mem1, mem2, mem3);
				textFieldResult.setText(result.toString());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(MyFrame.this,
						"Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	});
	JButton M2 = new JButton("M+");
	M2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ev) {
			if((X.isSelected())) {
				mem1+=result;
				result=mem1;
				textFieldResult.setText(result.toString());
			}
			else if((Y.isSelected())) {
				mem2+=result;
				result=mem2;
				textFieldResult.setText(result.toString());
			}
			else if((Z.isSelected())) {
				mem3+=result;
				result=mem3;
				textFieldResult.setText(result.toString());
			}
		}
	});
	Box hboxButtons = Box.createHorizontalBox();
	hboxButtons.add(Box.createHorizontalGlue());
	hboxButtons.add(buttonCalc);
	hboxButtons.add(Box.createHorizontalStrut(30));
	hboxButtons.add(MC);
	hboxButtons.add(Box.createHorizontalStrut(30));
	hboxButtons.add(M2);
	hboxButtons.add(Box.createHorizontalGlue());
	hboxButtons.setBorder(
	BorderFactory.createLineBorder(Color.GREEN));
	Box contentBox = Box.createVerticalBox();
	contentBox.add(Box.createVerticalGlue());
	contentBox.add(hboxFormulaType);
	contentBox.add(setVarButton);
	contentBox.add(hboxVariables);
	contentBox.add(hboxResult);
	contentBox.add(hboxButtons);
	contentBox.add(Box.createVerticalGlue());
	getContentPane().add(contentBox, BorderLayout.CENTER);
	}


	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
