/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;

import Models.Book;
import Models.Editor;
import Models.UserInformation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YS
 */
public class UserInformationImpl implements IUserInformation {

    @Override
    public boolean addUserInformation(UserInformation ui) {
         Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="insert into userinformation (UserID,UserAddress,UserBirthdate,UserEmail,UserFirstname,UserLastname) values("+ui.getUserID()+",'"+ui.getUserAddress()+"','"+ui.getUserBirthDate()+"','"+ui.getUserEmail()+"','"+ui.getUserFirstName()+"','"+ui.getUserLastName()+"')";
			Statement st=c.createStatement();
			st.execute(req);
			bool=true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		return bool;
    }

    @Override
    public boolean deleteUserInformation(UserInformation ui) {
        Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="delete from userinformation WHERE UserID = "+ui.getUserID()+"";
			Statement st=c.createStatement();
			st.execute(req);
			bool=true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		return bool;
    }

    @Override
    public boolean updateUserInformation(UserInformation ui) {
        Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="UPDATE userinformation SET UserAddress = '"+ui.getUserAddress()+"',UserBirthdate = '"+ui.getUserBirthDate()+"',UserEmail = '"+ui.getUserEmail()+"',UserFirstname = '"+ui.getUserFirstName()+"',UserLastname = '"+ui.getUserLastName()+"' WHERE UserID = "+ui.getUserID()+"";
			Statement st=c.createStatement();
			st.execute(req);
			bool=true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		return bool;
    }

    @Override
    public UserInformation selectUserInformation(UserInformation ui) {
        
                UserInformation userinformation=null;
                Connection c=null;
		
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from userinformation where UserID ="+ui.getUserID()+"";
                      
                        Statement st=c.createStatement();
                        s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{
			     userinformation=new UserInformation();
                             userinformation.setUserID(Integer.parseInt(s.getString("UserID")));
                             userinformation.setUserFirstName(s.getString("UserFirstname"));
                             userinformation.setUserAddress(s.getString("UserAddress"));
                             userinformation.setUserBirthDate(s.getString("UserBirthdate"));
                             userinformation.setUserEmail(s.getString("UserEmail"));
                             userinformation.setUserLastName(s.getString("UserLastname"));
			}
                        
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return userinformation;
    }
    
}
