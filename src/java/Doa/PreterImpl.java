/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;

import Models.Book;
import Models.Inventaire;
import Models.Preter;
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
public class PreterImpl implements IPreter {
IUser iu=new UserImpl();
IBook ib=new BookImpl();
    @Override
    public boolean addPreter(Preter p) {
         Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="insert into preter (UserID,BookID,DateSortie,Message) values("+p.getUser().getUserID()+","+p.getBook().getBookID()+",'"+p.getDateSortie()+"','"+p.getMessage()+"')";
			//String req="insert into preter (UserID,BookID,DateSortie,Message) values("+p.getUser().getUserID()+","+p.getBook().getBookID()+",'"+p.getDateSortie()+"','"+p.getMessage()+"')";
                        Statement st=c.createStatement();
			st.execute(req);
			bool=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		return bool;
    }

    @Override
    public boolean deletePreter(Preter p) {
         Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="delete from preter WHERE UserID = "+p.getUser().getUserID()+"";
			Statement st=c.createStatement();
			st.execute(req);
			bool=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		return bool;
    }

    @Override
    public boolean updatePreter(Preter p) {
        Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="Update preter SET BookID="+p.getBook().getBookID()+",DateSortie='"+p.getDateSortie()+"',Message='"+p.getMessage()+"' WHERE UserID = "+p.getUser().getUserID()+"";
			Statement st=c.createStatement();
			st.execute(req);
			bool=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		return bool;
    }

    @Override
    public List<Preter> selectPreter() {
        List<Preter> listpreter=new ArrayList<Preter>();
        Book book=null;
        User u=null;
        Preter p=null;
                Connection c=null;
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();              
			String req="select * from preter";
                      
                        Statement st=c.createStatement();
                        s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{    p=new Preter();
                             u=new User();
                             book=new Book();
                             u.setUserID(Integer.parseInt(s.getString("UserID")));
                             book.setBookID(Integer.parseInt(s.getString("BookID")));
                             u=iu.selectUser(u);
                             book=ib.selectBook(book);
                             p.setBook(book);
                             p.setUser(u);
                             p.setMessage(s.getString("Message"));
                             p.setDateSortie(s.getString("DateSortie"));
                             listpreter.add(p);
                              
                                
                              

			}
                        
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return listpreter;
    }
    
}
