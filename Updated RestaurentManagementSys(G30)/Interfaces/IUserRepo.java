package Interfaces;
import java.lang.*;
import Entity.*;

public interface IUserRepo
{
	User getUser(String userId, String password);
	void insertUser(User u);
	void updateUser(User u);
	void deleteUser(String userId);
}