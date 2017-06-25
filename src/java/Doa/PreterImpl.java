/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;

import Models.Preter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author YS
 */
public class PreterImpl implements IPreter {

    @Override
    public boolean addPreter(Preter p) {
         Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="insert into inventaire (UserID,BookID,DateSortie,Message) values("+p.getUser().getUserID()+","+p.getBook().getBookID()+",'"+p.getDateSortie()+"','"+p.getMessage()+"')";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updatePreter(Preter p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Preter> selectPreter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
