package Frame;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Entity.*;
import Repository.*;

public class Table1 extends JFrame implements ActionListener
{
	private JLabel tableId, numofchairs;
	private JTextField tableidTF, numofchairsTF;
	private JButton searchBtn, refreshBtn,backBtn,showBtn ,bookBtn,logoutbtn;
	private JPanel panel;
	private JTable TableListTable;
	private JScrollPane TableListTableSP;
	//private Table t;
	private TableRepo tr;
	private UserRepo ur;
	private User user;
	
	public Table1(User user)
	{
	    super("TABLE MANAGEMENT");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user=user;
		
		tr = new TableRepo();
		ur=new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);

        String data[][] = {{"", ""}};
		
		String head[] = {"TableId", "NumberOfChairs"};
		
		TableListTable = new JTable(data,head);
		TableListTableSP = new JScrollPane(TableListTable);
		TableListTableSP.setBounds(30, 30, 200, 270);
		TableListTable.setEnabled(false);
		panel.add(TableListTableSP);
		
		
		tableId= new JLabel("Table Id:");
		tableId.setBounds(300,60,100,40);
		panel.add(tableId);
		
		numofchairs = new JLabel("Number Of Chairs:");
		numofchairs.setBounds(300,150,100,40);
		panel.add(numofchairs);
		
		tableidTF = new JTextField();
		tableidTF.setBounds(400,60,150,40);
		panel.add(tableidTF);
		
		numofchairsTF = new JTextField();
		numofchairsTF.setBounds(400,150,150,40);
		panel.add(numofchairsTF);
		
		searchBtn = new JButton("SEARCH");
		searchBtn.setBounds(410,210,120,50);
		searchBtn.addActionListener(this);
		panel.add(searchBtn);
		
		refreshBtn = new JButton("REFRESH");
		refreshBtn.setBounds(410,330,120,50);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);
		
		backBtn = new JButton("BACK");
		backBtn.setBounds(600,330,120,50);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		showBtn = new JButton("Get All");
		showBtn.setBounds(50,330,120,50);
		showBtn.addActionListener(this);
		panel.add(showBtn);
		
		bookBtn = new JButton("BOOK NOW");
		bookBtn .setBounds(220,330,120,50);
		bookBtn.addActionListener(this);
		panel.add(bookBtn );
		
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
			Customer1 cf=new Customer1(user);
			cf.setVisible(true);
			this.setVisible(false);
		}
		else if(bookBtn.getText().equals(command))
		{
			if(!tableidTF.getText().equals("") || !numofchairsTF.getText().equals(null))
			{
				String Id= user.getUserId();
				String f = tr.updateTableStatus(tableidTF.getText(),Id);
				if(f!= null)
				{
					JOptionPane.showMessageDialog(this,"Table Booked"); 
					 
					
					
					 /*tableidTF.setEnabled(false);
					 numofchairsTF.setEnabled(true);
					 //empDesignationTF.setEnabled(true);
					 ////empSalaryTF.setEnabled(true);
					
					 //updateBtn.setEnabled(true);
					 //deleteBtn.setEnabled(true);
					 //refreshBtn.setEnabled(true);
					 //insertBtn.setEnabled(false);
					 searchBtn.setEnabled(false);*/
					
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
			    }   
			}	
		}
		else if(logoutbtn.getText().equals(command))
		{
			LoginFrame lf=new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(refreshBtn.getText().equals(command))
		{
			tableidTF.setText("");
			numofchairsTF.setText("");
			
			searchBtn.setEnabled(true);
			tableidTF.setEnabled(true);
			
		}
		
		else if(command.equals(showBtn.getText()))
		{
			String data[][] = tr.getAllTable();
			String head[] = {"TableId", "NumChair"};
			
			panel.remove(TableListTableSP);
			
			TableListTable= new JTable(data,head);
			TableListTable.setEnabled(false);
			TableListTableSP = new JScrollPane(TableListTable);
			TableListTableSP.setBounds(30, 30, 200, 270);
			panel.add(TableListTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		
		else if(command.equals(searchBtn.getText()))
		{
			if(!tableidTF.getText().equals("") || !numofchairsTF.getText().equals(null))
			{
				Table t = tr.searchTable(tableidTF.getText());
				if(t!= null)
				{
					 tableidTF.setText(t.getTableId());
					 tableidTF.setText(t.getTableId());
					 numofchairsTF.setText(t.getNumberOfChairs()+"");
					 
					
					
					 tableidTF.setEnabled(false);
					 numofchairsTF.setEnabled(true);
					 //empDesignationTF.setEnabled(true);
					 ////empSalaryTF.setEnabled(true);
					
					 //updateBtn.setEnabled(true);
					 //deleteBtn.setEnabled(true);
					 //refreshBtn.setEnabled(true);
					 //insertBtn.setEnabled(false);
					 searchBtn.setEnabled(false);
					
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
	}
	
}


