package Frame;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Entity.*;
import Repository.*;


public class LoginFrame extends JFrame implements ActionListener, MouseListener
{
	private JLabel title, userLabel, passLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton loginBtn, signupBtn, refreshBtn,exitBtn,showBtn;
	private JPanel panel;
	
	public LoginFrame()
	{
		super("KFC");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("KFC");
		title.setBounds(300, 50, 350, 30);
	    panel.add(title);
		
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(300, 100, 60, 30);
		panel.add(userLabel);
		
		
		userTF = new JTextField();
		userTF.setBounds(370, 100, 100, 30);
		userTF.setBackground(Color.CYAN);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(300, 150, 70, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(370, 150, 100, 30);
		passPF.setBackground(Color.CYAN);
		passPF.setEchoChar('*');
		panel.add(passPF);
		
		showBtn = new JButton("Show");
		showBtn.setBounds(480, 150, 80, 30);
		showBtn.setBackground(Color.RED);
		showBtn.addMouseListener(this);
		panel.add(showBtn);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(300, 250, 80, 30);
		loginBtn.setBackground(Color.RED);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		
		signupBtn = new JButton("Sign Up");
		signupBtn.setBounds(390, 250, 80, 30);
		signupBtn.setBackground(Color.RED);
		signupBtn.addActionListener(this);
		panel.add(signupBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(480, 250, 80, 30);
		refreshBtn.setBackground(Color.RED);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(390, 300, 80, 30);
		exitBtn.setBackground(Color.RED);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		this.add(panel);
		
		
}

public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			UserRepo ur = new UserRepo();
			User user = ur.getUser(userTF.getText(), passPF.getText());
			
			if(user != null)
			{
				if(user.getStatus() == 0 )
				{
					ManagerHome mg = new ManagerHome(user);
					mg.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getStatus() == 1)
				{
					Customer1 cf = new Customer1(user);
					cf.setVisible(true);
					this.setVisible(false);
				}
				else{}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild Id or Password");
			}
			
		}
		else if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		else if(refreshBtn.getText().equals(command))
		{
			userTF.setText("");
			passPF.setText("");
		}
		/*else if(command.equals(regBtn.getText()))
		{
			RegistrationFrame rf = new RegistrationFrame(this);
			rf.setVisible(true);
			this.setVisible(false);
		}
		else{}*/
	}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me)
	{
		passPF.setEchoChar((char)0);
	}
	public void mouseReleased(MouseEvent me)
	{
		passPF.setEchoChar('*');
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
}
