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
	String[] days = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
			"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	String[] years = { "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991",
			"1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004",
			"2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017",
			"2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030",
			"2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043",
			"2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056",
			"2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069",
			"2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080" };
	JLabel instructionLabel, answerLabel, imageLabel;
	JComboBox<String> monthBox, dayBox, yearBox;
	ImageIcon image;
	JFrame frame;
	JButton finalOKButton;

	ChristmasCounter()
	{
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
