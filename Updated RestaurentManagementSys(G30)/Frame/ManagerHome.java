package Frame;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Entity.*;
import Repository.*;

public class ManagerHome extends JFrame implements ActionListener
{
	private JButton tableBtn,foodBtn,backBtn,logoutBtn;
	private JPanel panel;
	private User user;
	public ManagerHome(User user)
	{
		super("KFC");
		this.setSize(800,450);
		this.user=user;
		panel = new JPanel();
		panel.setLayout(null);
		
		tableBtn= new JButton("TABLE");
		tableBtn.setBounds(200,200,350,60);
		tableBtn.addActionListener(this);
		panel.add(tableBtn);
		
		foodBtn= new JButton("FOOD");
		foodBtn.setBounds(200,100,350,60);
		foodBtn.addActionListener(this);
		panel.add(foodBtn);
		
		backBtn= new JButton("Back");
		backBtn.setBounds(290,300,180,60);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		logoutBtn=new JButton("Logout");
		logoutBtn.setBounds(690,10,80,30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(tableBtn.getText()))
		{
			        MTableHome mt = new MTableHome(user);
					mt.setVisible(true);
					this.setVisible(false);
		}
		else if(command.equals(foodBtn.getText()))
		{
			MFoodHome mf=new MFoodHome(user);
			mf.setVisible(true);
			this.setVisible(false);
			
		}
		else if(command.equals(backBtn.getText()))
		{
			LoginFrame lf1=new LoginFrame();
			lf1.setVisible(true);
			this.setVisible(false);
			
		}
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf2=new LoginFrame();
			lf2.setVisible(true);
			this.setVisible(false);
			
		}
		
	
	
}}