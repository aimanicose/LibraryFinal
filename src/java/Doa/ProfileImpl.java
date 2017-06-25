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
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author YS
 */
public class ProfileImpl implements IProfile {
Select select=new Select();
    @Override
    public boolean addProfil(Profile p) {
         Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="insert into profil (ProfilID,ProfilName) values("+p.getProfileID()+",'"+p.getProfileName()+"')";
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
    public boolean deleteProfil(Profile p) {
        Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        String req3="delete from profil WHERE ProfilID = "+p.getProfileID()+"";
			String req2="delete from user WHERE ProfilID = "+p.getProfileID()+"";
                        String req1="delete from userinformation where UserID IN ( select UserID from user WHERE ProfilID = "+p.getProfileID()+")";
			String req4="delete from preter where UserID IN ( select UserID from user WHERE ProfilID = "+p.getProfileID()+")";
                        Statement st=c.createStatement(); 
                        st.execute(req4);
			st.execute(req1);
                        st.execute(req2);
                        st.execute(req3);
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
    public boolean updateProfil(Profile p) {
        Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="UPDATE profil SET ProfilName = '"+p.getProfileName()+"' WHERE ProfilID = "+p.getProfileID()+"";
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
    public Profile selectProfil(Profile p) {
        Profile p1=null;
        List<User> listuser=null;
                Connection c=null;
		
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from profil where ProfilID="+p.getProfileID()+"";
                      
                        Statement st=c.createStatement();
                      
                           listuser = select.selectusers(p);
                      
                             s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{
			     p1=new Profile();
                             p1.setProfileID(Integer.parseInt(s.getString("ProfilID")));
                             p1.setProfileName(s.getString("ProfilName"));
                             p1.setUsersList(listuser);            
			}
                        
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return p1;
    }
    
   
    @Override
    public List<Profile> selectListProfil() {
        List<Profile> listprofil=new ArrayList<Profile>();
        List<User> listuser=null;
        Profile p1=null;
                Connection c=null;
		
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from profil";
                      
                        Statement st=c.createStatement();
                      
                           
                      
                             s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{    listuser=new ArrayList<User>();
			     p1=new Profile();
                             p1.setProfileID(Integer.parseInt(s.getString("ProfilID")));
                             p1.setProfileName(s.getString("ProfilName"));
                             listuser=select.selectusers(p1);
                             p1.setUsersList(listuser);  
                             listprofil.add(p1);
			}
                        
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return listprofil;
    }
    
}
