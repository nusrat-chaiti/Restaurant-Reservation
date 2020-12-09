package Repository;
import java.lang.*;
import Entity.*;
import Interfaces.*;

public class UserRepo implements IUserRepo
{
	DatabaseConnection dbc;
	
	public UserRepo()
	{
		dbc = new DatabaseConnection();
	}
	public User getUser(String userId, String pass)
	{
		User user = null;
		String query = "Select * from user where UserId = '"+userId+"' and Password = '"+pass+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				user = new User();
				user.setUserId(dbc.result.getString("UserId"));
				user.setPassword(dbc.result.getString("Password"));
				user.setStatus(dbc.result.getInt("Status"));
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		return user;
	}
	public void insertUser(User u)
	{
		String query = "INSERT INTO user VALUES ('"+u.getUserId()+"','"+u.getPassword()+"',"+u.getStatus()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void updateUser(User u){}
	public void deleteUser(String userId)
	{
		String query = "DELETE from user  WHERE UserId='"+userId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
}