/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;

import Models.Book;
import Models.Inventaire;
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
public class InventaireImpl implements IInventaire {
IUser iu=new UserImpl();
IBook ib=new BookImpl();
    @Override
    public boolean addInventaire(Inventaire i) {
        Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="insert into inventaire (UserID,BookID,DateSortie,DateEntree) values("+i.getUser().getUserID()+","+i.getBook().getBookID()+",'"+i.getDateSortie()+"','"+i.getDateEntree()+"')";
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
    public List<Inventaire> selectInventaire() {
        List<Inventaire> listinventaire=new ArrayList<Inventaire>();
        Book book=null;
        User u=null;
        Inventaire i=null;
                Connection c=null;
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();              
			String req="select * from inventaire";
                      
                        Statement st=c.createStatement();
                        s=st.executeQuery(req);
                        
			while(s.next())
			{    i=new Inventaire();
                             u=new User();
                             book=new Book();
                             u.setUserID(Integer.parseInt(s.getString("UserID")));
                             book.setBookID(Integer.parseInt(s.getString("BookID")));
                             u=iu.selectUser(u);
                             book=ib.selectBook(book);
                             i.setBook(book);
                             i.setUser(u);
                             i.setDateEntree(s.getString("DateEntree"));
                             i.setDateSortie(s.getString("DateSortie"));
                             listinventaire.add(i);
                              
                                
                              

			}
                        
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return listinventaire;
      
    }
    
}
