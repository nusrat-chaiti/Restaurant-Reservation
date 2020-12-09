package Frame;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Entity.*;
import Repository.*;



public class Customer1 extends JFrame implements ActionListener
{

	private JButton foodlistBtn,showtableBtn,logoutbtn,backBtn;
	
	JPanel panel;
	User user;
	public Customer1(User user)
	{
		super("Welcome Customer ");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.user=user;
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		foodlistBtn = new JButton("FOOD LIST");
		foodlistBtn.setBounds(200, 100, 350, 60);
		//loadBtn.setBackground(Color.RED);
		foodlistBtn.addActionListener(this);
		panel.add(foodlistBtn);
		
		showtableBtn = new JButton("SELECT TABLE");
		showtableBtn.setBounds(200, 200, 350, 60);
		//loadBtn.setBackground(Color.RED);
		showtableBtn.addActionListener(this);
		panel.add(showtableBtn);
		
		backBtn = new JButton("BACK");
		backBtn.setBounds(290, 300, 180, 60);
		//backBtn.setBackground(Color.RED);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		
		logoutbtn = new JButton("LOGOUT");
		logoutbtn.setBounds(690, 10, 100, 30);
		//backBtn.setBackground(Color.RED);
		logoutbtn.addActionListener(this);
		panel.add(logoutbtn);
		
		
	    this.add(panel);
		
		
}

public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
	
		if(backBtn.getText().equals(command))
		{
			LoginFrame lf=new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(logoutbtn.getText().equals(command))
		{
			LoginFrame lf=new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(foodlistBtn.getText().equals(command))
		{
			Foodlist fl=new Foodlist(user);
			fl.setVisible(true);
			this.setVisible(false);
		}
		else if(showtableBtn.getText().equals(command))
		{
			Table1 t1=new Table1(user);
			t1.setVisible(true);
			this.setVisible(false);
		}
	}

}
		
		
		
		