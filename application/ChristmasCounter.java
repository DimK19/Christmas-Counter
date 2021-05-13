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

public class ChristmasCounter implements ActionListener
{
	
	public int month = 1;
	public int day = 1;
	public int year = 1980;
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
	public JLabel instructions;
	public JLabel answer;
	public JLabel imglab;
	JComboBox<String> monthBox;
	JComboBox<String> dayBox;
	JComboBox<String> yearBox;
	ImageIcon img1;

	ChristmasCounter()
	{
		JFrame jfrm = new JFrame("Christmas Counter");

		jfrm.setLayout(new FlowLayout());

		jfrm.setSize(300, 250);

		jfrm.setDefaultCloseOperation(3);

		jfrm.getContentPane().setBackground(this.CGREEN);

		this.monthBox = new JComboBox<String>(this.months);
		this.monthBox.setSelectedIndex(0);

		this.yearBox = new JComboBox<String>(this.years);
		this.yearBox.setSelectedIndex(0);

		this.dayBox = new JComboBox<String>(this.days);
		this.dayBox.setSelectedIndex(0);

		this.instructions = new JLabel("       Select date and press OK       ");
		this.instructions.setFont(this.instructions.getFont().deriveFont(14.0F));
		this.instructions.setForeground(Color.white);

		this.answer = new JLabel("              Days Until Christmas:                  ");
		this.answer.setFont(this.answer.getFont().deriveFont(13.0F));
		this.answer.setForeground(Color.white);

		JButton finalOk = new JButton("  OK  ");
		finalOk.setFocusable(false);
		finalOk.setForeground(Color.white);
		finalOk.setBackground(this.CRED);

		this.monthBox.addActionListener(new monthSelected());
		this.dayBox.addActionListener(new daySelected());
		this.yearBox.addActionListener(new yearSelected());
		finalOk.addActionListener(this);

		this.img1 = new ImageIcon(getClass().getResource("/images/snow.png"));
		this.imglab = new JLabel(this.img1);

		jfrm.setLocationRelativeTo(null);

		jfrm.add(this.instructions);
		jfrm.add(this.monthBox);
		jfrm.add(this.dayBox);
		jfrm.add(this.yearBox);
		jfrm.add(finalOk);
		jfrm.add(this.answer);
		jfrm.add(this.imglab);

		jfrm.setVisible(true);
	}

	public class monthSelected implements ActionListener
	{
		public void actionPerformed(ActionEvent e1)
		{
			ChristmasCounter.this.month = (ChristmasCounter.this.monthBox.getSelectedIndex() + 1);
		}
	}

	public class daySelected implements ActionListener
	{
		public void actionPerformed(ActionEvent e2)
		{
			ChristmasCounter.this.day = (ChristmasCounter.this.dayBox.getSelectedIndex() + 1);
		}
	}

	public class yearSelected implements ActionListener
	{
		public void actionPerformed(ActionEvent e3)
		{
			ChristmasCounter.this.year = (ChristmasCounter.this.yearBox.getSelectedIndex() + 1980);
		}
	}

	public void actionPerformed(ActionEvent fe)
	{
		Calculator c = new Calculator();
		this.answer.setText(c.getAnswer(this.month, this.day, this.year));
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
