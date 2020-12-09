package Frame;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Entity.*;
import Repository.*;

public class MTableHome extends JFrame implements ActionListener
{
	private JLabel tIdlbl,tnOfclbl,tstatuslbl;
	private JTextField tidTf,tnOfcTf,tstatusTf;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable tTable;
    private JScrollPane tTableSP;
	private User user;
	private ManagerRepo mr;
	public MTableHome(User user)
	{
		super("TABLE HOME");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.user = user;
		
		mr =new ManagerRepo();
		panel = new JPanel();
		panel.setLayout(null);

		String data[][] = {{"", "", ""}};
		String head[] = {"TableId", "NumberOfChairs","TableStatus"};
		
		tTable=new JTable(data,head);
		tTableSP=new JScrollPane(tTable);
		tTableSP.setBounds(30,30,200,270);
		tTable.setEnabled(false);
		panel.add(tTableSP);
		
		tIdlbl=new JLabel("ID :  ");
		tIdlbl.setBounds(400,40,50,30);
		panel.add(tIdlbl);
		
		tidTf=new JTextField();
		tidTf.setBounds(450,35,130,40);
		panel.add(tidTf);
		
		tnOfclbl=new JLabel("No Of Chairs:");
		tnOfclbl.setBounds(400,85,50,30);
		panel.add(tnOfclbl);
		
		tnOfcTf=new JTextField();
		tnOfcTf.setBounds(450,85,130,40);
		panel.add(tnOfcTf);
		
		tstatuslbl=new JLabel("Status :");
		tstatuslbl.setBounds(400,135,50,30);
		panel.add(tstatuslbl);
		
		tstatusTf=new JTextField();
		tstatusTf.setBounds(450,135,130,40);
		panel.add(tstatusTf);
		
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
			if(!tidTf.getText().equals("") || !tidTf.getText().equals(null))
			{
				Table t=mr.searchTable(tidTf.getText());
				if(t!=null)
				{
					tidTf.setText(t.getTableId());
					tnOfcTf.setText((t.getNumberOfChairs()+""));
					tstatusTf.setText(t.getTableStatus());
					
					tidTf.setEnabled(false);
					tnOfcTf.setEnabled(true);
					tstatusTf.setEnabled(true);
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
			Table t=new Table();
			t.setTableId(tidTf.getText());
			t.setNumberOfChairs(Integer.parseInt(tnOfcTf.getText()));
			t.setTableStatus(tstatusTf.getText());
			mr.insertTableInDB(t);
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+tidTf.getText()+"and NumberOfChairs: "+tnOfcTf.getText());
			tidTf.setText("");
			tnOfcTf.setText("");
			tstatusTf.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
		    updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
			{
			 tidTf.setText("");
			 tnOfcTf.setText("");
			 tstatusTf.setText("");
			
             tidTf.setEnabled(true);
			 loadBtn.setEnabled(true);
			 insertBtn.setEnabled(true);
			 updateBtn.setEnabled(false);
			 deleteBtn.setEnabled(false);
			 refreshBtn.setEnabled(false);
			 
			}
			else if(command.equals(updateBtn.getText()))
			{
				Table t=new Table();
				t.setTableId(tidTf.getText());
				t.setNumberOfChairs(Integer.parseInt(tnOfcTf.getText()));
				t.setTableStatus(tstatusTf.getText());
				
				mr.updateTableInDB(t);
				JOptionPane.showMessageDialog(this, "Updated");
				tidTf.setText("");
				tnOfcTf.setText("");
				tstatusTf.setText("");
				tidTf.setEnabled(true);
			    tnOfcTf.setEnabled(true);
			    tstatusTf.setEnabled(true);
				loadBtn.setEnabled(true);
			    insertBtn.setEnabled(true);
			    updateBtn.setEnabled(false);
			    deleteBtn.setEnabled(false);
			    refreshBtn.setEnabled(false);
				
			}
			else if(command.equals(deleteBtn.getText()))
			{
				mr.deleteTableFromDB(tidTf.getText());
				JOptionPane.showMessageDialog(this,"Deleted");
				tidTf.setText("");
				tnOfcTf.setText("");
				tstatusTf.setText("");
			
			    tidTf.setEnabled(true);
			    tnOfcTf.setEnabled(true);
			    tstatusTf.setEnabled(true);
	
			    loadBtn.setEnabled(true);
			    insertBtn.setEnabled(true);
			    updateBtn.setEnabled(false);
			    deleteBtn.setEnabled(false);
			    refreshBtn.setEnabled(false);
				
			}
			else if(command.equals(getAllBtn.getText()))
			{
				String data[][] = mr.getAllTable();
			    String head[] = {"TableId", "NumberOfChairs", "TableStatus"};
				panel.remove(tTableSP);
				tTable= new JTable(data,head);
				tTableSP =new JScrollPane(tTable);
				tTableSP.setBounds(30,30,200,270);
				panel.add(tTableSP);
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