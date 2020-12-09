package Frame;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Entity.*;
import Repository.*;

public class MFoodHome extends JFrame implements ActionListener
{
	private JLabel fIdlbl,fNamelbl,fPricelbl;
	private JTextField fidTf,fnameTf,fpriceTf;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable foodTable;
    private JScrollPane foodTableSP;
	private User user;
	private ManagerRepo mr;
	
	
	public MFoodHome(User user)
	{
		super("FOOD HOME");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.user = user;
		
		mr =new ManagerRepo();
		panel = new JPanel();
		panel.setLayout(null);

		String data[][] = {{"", "", ""}};
		
		String head[] = {"FoodId", "FoodName","Salary"};
		
		foodTable=new JTable(data,head);
		foodTableSP=new JScrollPane(foodTable);
		foodTableSP.setBounds(30,30,200,270);
		foodTable.setEnabled(false);
		panel.add(foodTableSP);
		
	    fIdlbl=new JLabel("ID :  ");
		fIdlbl.setBounds(400,40,50,30);
		panel.add(fIdlbl);
		
		fidTf=new JTextField();
		fidTf.setBounds(450,35,130,40);
		panel.add(fidTf);
		
		fNamelbl=new JLabel("NAME : ");
		fNamelbl.setBounds(400,85,50,30);
		panel.add(fNamelbl);
		
		fnameTf=new JTextField();
		fnameTf.setBounds(450,85,130,40);
		panel.add(fnameTf);
		
		
		fPricelbl=new JLabel("PRICE : ");
		fPricelbl.setBounds(400,135,50,30);
		panel.add(fPricelbl);
		
		
		fpriceTf=new JTextField();
		fpriceTf.setBounds(450,135,130,40);
		panel.add(fpriceTf);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(30,330,90,40);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(130,330,90,40);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(230,330,90,40);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(330,330,90,40);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(430,330,90,40);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(530,330,90,40);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(630,330,90,40);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
		

		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
	    String command = ae.getActionCommand();
		if(command.equals(loadBtn.getText()))
		{
			if(!fidTf.getText().equals("") || !fidTf.getText().equals(null))
			{
				Fooditem f=mr.searchFood(fidTf.getText());
				if(f!=null)
				{
					fnameTf.setText(f.getFoodName());
					fidTf.setText(f.getFoodId());
					fpriceTf.setText(f.getPrice()+"");
					
					fidTf.setEnabled(false);
					fnameTf.setEnabled(true);
					fpriceTf.setEnabled(true);
			        updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);		
						
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
			else if(command.equals(insertBtn.getText()))
			{
				Fooditem f=new Fooditem();				
				f.setFoodId(fidTf.getText());
				f.setFoodName(fnameTf.getText());
				f.setPrice(Double.parseDouble(fpriceTf.getText()));
				mr.insertFoodInDB(f);
				
				JOptionPane.showMessageDialog(this, "Inserted, Id: "+fidTf.getText()+"and FoodName: "+fnameTf.getText());
				
				fidTf.setText("");
				fnameTf.setText("");
				fpriceTf.setText("");
				
				loadBtn.setEnabled(true);
			    insertBtn.setEnabled(true);
				updateBtn.setEnabled(false);
			    deleteBtn.setEnabled(false);
			    refreshBtn.setEnabled(false);
				
			}
			else if(command.equals(refreshBtn.getText()) )
			{
			 fidTf.setText("");
			 fnameTf.setText("");
			 fidTf.setText("");
			
             fidTf.setEnabled(true);
			 loadBtn.setEnabled(true);
			 insertBtn.setEnabled(true);
			 updateBtn.setEnabled(false);
			 deleteBtn.setEnabled(false);
			 refreshBtn.setEnabled(false);
			}
			else if(command.equals(updateBtn.getText()))
			{
				Fooditem fi=new Fooditem();
				fi.setFoodId(fidTf.getText());
				fi.setFoodName(fnameTf.getText());
				fi.setPrice(Double.parseDouble(fpriceTf.getText()));
				
				mr.updateFoodInDB(fi);
				JOptionPane.showMessageDialog(this, "Updated");
				
				fidTf.setText("");
				fnameTf.setText("");
				fpriceTf.setText("");
				fidTf.setEnabled(true);
			    fnameTf.setEnabled(true);
			    fpriceTf.setEnabled(true);
				loadBtn.setEnabled(true);
			    insertBtn.setEnabled(true);
			    updateBtn.setEnabled(false);
			    deleteBtn.setEnabled(false);
			    refreshBtn.setEnabled(false);

			
			}
			else if(command.equals(deleteBtn.getText()))
			{
				mr.deleteFoodFromDB(fidTf.getText());
				JOptionPane.showMessageDialog(this,"Deleted");
				fidTf.setText("");
				fnameTf.setText("");
				fpriceTf.setText("");
			
			    fidTf.setEnabled(true);
			    fnameTf.setEnabled(true);
			    fpriceTf.setEnabled(true);
	
			    loadBtn.setEnabled(true);
			    insertBtn.setEnabled(true);
			    updateBtn.setEnabled(false);
			    deleteBtn.setEnabled(false);
			    refreshBtn.setEnabled(false);
				
			}
			else if(command.equals(getAllBtn.getText()))
			{
				String data[][] = mr.getAllFood();
			    String head[] = {"FoodId", "FoodName", "Price"};
				panel.remove(foodTableSP);
				foodTable= new JTable(data,head);
				foodTableSP =new JScrollPane(foodTable);
				foodTableSP.setBounds(30,30,200,270);
				panel.add(foodTableSP);
				panel.revalidate();
			    panel.repaint();
				
				
			}
			else if(command.equals(backBtn.getText()))
			 {
				  ManagerHome mh = new ManagerHome(user);
			      mh.setVisible(true);
			      this.setVisible(false);
				  
			 }
		  
			
		 }
			
					
				
				
		
	
}
		
		