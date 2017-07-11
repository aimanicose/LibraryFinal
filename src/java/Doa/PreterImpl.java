/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;

import Models.Book;
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
Select select=new Select();
IBook ib=new BookImpl();
    @Override
    public boolean addPreter(Preter p) {
         Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="insert into preter (UserID,BookID,DateSortie,Message,Statut,DateEntree) values("+p.getUser().getUserID()+",(Select bookId from Book where bookName = '"+p.getBook().getBookName()+"'),'"+p.getDateSortie()+"','"+p.getMessage()+"','"+p.getStatut()+"','"+p.getDateEntree()+"')";
			String req1="Update book SET booksInStore=booksInStore - 1 WHERE BookName = '"+p.getBook().getBookName()+"'";
                        Statement st=c.createStatement();
                        st.execute(req);
			st.execute(req1);
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
                        String req1="Update book SET booksInStore=booksInStore + 1 WHERE BookID = "+p.getBook().getBookID()+"";
			Statement st=c.createStatement();
			st.execute(req);
                        st.execute(req1);
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
			String req="Update preter SET BookID="+p.getBook().getBookID()+",DateSortie='"+p.getDateSortie()+"',Message='"+p.getMessage()+"',Reference='"+p.getReference()+"',Statut='"+p.getStatut()+"',DateEntree='"+p.getDateEntree()+"' WHERE UserID = "+p.getUser().getUserID()+"";
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
                             u=select.selectUser(u);
                             book=ib.selectBook(book);
                             p.setBook(book);
                             p.setUser(u);
                             p.setMessage(s.getString("Message"));
                             p.setDateSortie(s.getString("DateSortie"));
                             p.setReference(s.getString("Reference"));
                             p.setDateEntree(s.getString("DateEntree"));
                             p.setStatut(s.getString("Statut"));
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
