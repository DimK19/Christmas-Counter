package application;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ChristmasCounter
{
	int month = 1, day = 1, year = 1980;
	Color CRED = new Color(128, 0, 0);
	Color CGREEN = new Color(0, 64, 0);
	String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };
	String[] days, years;
	JLabel instructionLabel, answerLabel, imageLabel;
	JComboBox<String> monthBox, dayBox, yearBox;
	ImageIcon image;
	JFrame frame;
	JButton finalOKButton;
	
	ChristmasCounter()
	{
	    // initialize string arrays
	    days = new String[31];
	    years = new String[101];
	    for(int i = 0; i < 31; ++i) days[i] = Integer.toString(i + 1);
	    for(int i = 0; i <= 100; ++i) years[i] = Integer.toString(i + 1980);
	    
		this.frame = new JFrame("Christmas Counter");

		this.frame.setLayout(new FlowLayout());

		this.frame.setSize(300, 250);

		this.frame.setDefaultCloseOperation(3);

		this.frame.getContentPane().setBackground(this.CGREEN);

		this.monthBox = new JComboBox<String>(this.months);
		this.monthBox.setSelectedIndex(0);

		this.yearBox = new JComboBox<String>(this.years);
		this.yearBox.setSelectedIndex(0);

		this.dayBox = new JComboBox<String>(this.days);
		this.dayBox.setSelectedIndex(0);

		this.instructionLabel = new JLabel("       Select date and press OK       ");
		this.instructionLabel.setFont(this.instructionLabel.getFont().deriveFont(14.0F));
		this.instructionLabel.setForeground(Color.white);

		this.answerLabel = new JLabel("              Days Until Christmas:                  ");
		this.answerLabel.setFont(this.answerLabel.getFont().deriveFont(13.0F));
		this.answerLabel.setForeground(Color.white);

		this.finalOKButton = new JButton("  OK  ");
		this.finalOKButton.setFocusable(false);
		this.finalOKButton.setForeground(Color.white);
		this.finalOKButton.setBackground(this.CRED);

		this.monthBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		        month = (monthBox.getSelectedIndex() + 1);
		    }
		});
		
		this.dayBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
	        {
	            day = (dayBox.getSelectedIndex() + 1);
	        }
		});
		
		this.yearBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		        year = (yearBox.getSelectedIndex() + 1980);
		    }
		});
		
		// finalOKButton.addActionListener(this);
		// would work if actionPerformed were defined as a class method
		
		this.finalOKButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		        Calculator c = new Calculator();
		        answerLabel.setText(c.getAnswer(month, day, year));
		    }
		});

		this.image = new ImageIcon(getClass().getResource("/images/snow.png"));
		this.imageLabel = new JLabel(this.image);

		frame.setLocationRelativeTo(null);

		frame.add(this.instructionLabel);
		frame.add(this.monthBox);
		frame.add(this.dayBox);
		frame.add(this.yearBox);
		frame.add(this.finalOKButton);
		frame.add(this.answerLabel);
		frame.add(this.imageLabel);

		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new ChristmasCounter();
			}
		});
	}
}
