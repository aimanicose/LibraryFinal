/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;


import Models.Profile;
import Models.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YS
 */
public class UserImpl implements IUser {
Select select =new Select();
    @Override
    public boolean addUser(User u) {
         Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="insert into user (UserID,login,password,ProfilID) values("+u.getUserID()+",'"+u.getLogin()+"','"+u.getPassword()+"',"+u.getUserProfile().getProfileID()+")";
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
    public boolean deleteUser(User u) {
        Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        String req1="delete from user WHERE  UserID  = "+u.getUserID()+"";
			String req="delete from userinformation WHERE UserID = "+u.getUserID()+"";
                        String req2="delete from preter WHERE UserID = "+u.getUserID()+"";
			Statement st=c.createStatement();
                        st.execute(req2);
                        st.execute(req);
                        st.execute(req1);
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
    public boolean updateUser(User u) {
       Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="UPDATE user SET login = '"+u.getLogin()+"',password = '"+u.getPassword()+"',ProfilID = "+u.getUserProfile().getProfileID()+" WHERE EditorID = "+u.getUserID()+"";
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
    public List<User> selectListUser() {
        User u=null;
        Profile p1=null;
        List<User> listuser=null;
                Connection c=null;
		
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from user";
                      
                        Statement st=c.createStatement();
                        s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{
			     u=new User();
                             p1=new Profile();
                             p1.setProfileID(Integer.parseInt(s.getString("ProfilID")));
                             u.setUserID(Integer.parseInt(s.getString("UserID")));
                             u.setLogin(s.getString("login"));
                             u.setPassword(s.getString("password"));
                             u.setUserProfile(select.selectprofile(p1));
                             u.setUserInformation(select.selectuserinformation(u));
                             listuser.add(u);
                 

			}
                        
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return listuser;
    }

    @Override
    public User selectUser(User u) {
        User u1=null;
        Profile p1=null;
        
                Connection c=null;
		
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from user where login ='"+u.getLogin()+"' and password='"+u.getPassword()+"' ";
                      
                        Statement st=c.createStatement();
                        s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{
			     u1=new User();
                             p1=new Profile();
                             p1.setProfileID(Integer.parseInt(s.getString("ProfilID")));
                             u1.setUserID(Integer.parseInt(s.getString("UserID")));
                             u1.setLogin(s.getString("login"));
                             u1.setPassword(s.getString("password"));
                             u1.setUserProfile(select.selectprofile(p1));
                             u1.setUserInformation(select.selectuserinformation(u1));
                             
                 

			}
                        
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return u1;
    }
    
}
