package Frame;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Entity.*;
import Repository.*;
public class Foodlist extends JFrame implements ActionListener
{
	private JLabel Foodname, Price;
	private JTextField foodnameTF, priceTF;
	
	private JButton searchBtn, refreshBtn,backBtn,showBtn ,tablelistBtn,logoutbtn;
	private JPanel panel;
	private JTable FoodListTable;
	private JScrollPane FoodListTableSP;
	//private Fooditem fi;
	private FooditemRepo fr;
	private UserRepo ur;
	private User user;
	public Foodlist(User user)
	{
	    super("Foodlist");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user=user;
		
		fr = new FooditemRepo();
		ur=new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);

        String data[][] = {{"", "", ""}};
		
		String head[] = {"Id", "FoodName", "Price"};
		
		FoodListTable = new JTable(data,head);
		FoodListTableSP = new JScrollPane(FoodListTable);
		FoodListTableSP.setBounds(30, 30, 200, 270);
		FoodListTable.setEnabled(false);
		panel.add(FoodListTableSP);
		
		
		Foodname = new JLabel("Food Name:");
		Foodname.setBounds(300,60,100,40);
		panel.add(Foodname);
		
		Price = new JLabel("Price:");
		Price.setBounds(300,150,100,40);
		panel.add(Price);
		
		foodnameTF = new JTextField();
		foodnameTF.setBounds(400,60,150,40);
		panel.add(foodnameTF);
		
		priceTF = new JTextField();
		priceTF.setBounds(400,150,150,40);
		panel.add(priceTF);
		
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
		
		tablelistBtn = new JButton("TABLE LIST");
		tablelistBtn .setBounds(220,330,120,50);
		tablelistBtn .addActionListener(this);
		panel.add(tablelistBtn );
		
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
		else if(tablelistBtn.getText().equals(command))
		{
			Table1 t1=new Table1(user);
			t1.setVisible(true);
			this.setVisible(false);
		}
		else if(logoutbtn.getText().equals(command))
		{
			LoginFrame lf=new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(refreshBtn.getText().equals(command))
		{
			foodnameTF.setText("");
			priceTF.setText("");
			
			searchBtn.setEnabled(true);
			foodnameTF.setEnabled(true);
			
		}
		
		else if(command.equals(showBtn.getText()))
		{
			String data[][] = fr.getAllFooditem();
			String head[] = {"FoodId", "FoodName", "Price"};
			
			panel.remove(FoodListTableSP);
			
			FoodListTable= new JTable(data,head);
			FoodListTable.setEnabled(false);
			FoodListTableSP = new JScrollPane(FoodListTable);
			FoodListTableSP.setBounds(30, 30, 200, 270);
			panel.add(FoodListTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		
		if(command.equals(searchBtn.getText()))
		{
			if(!foodnameTF.getText().equals("") || !priceTF.getText().equals(null))
			{
				Fooditem f = fr.searchFooditem(foodnameTF.getText());
				if(f!= null)
				{
					foodnameTF.setText(f.getFoodName());
					priceTF.setText(f.getPrice()+"");
					
					
					foodnameTF.setEnabled(false);
					priceTF.setEnabled(true);
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