package Doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
  
  private static ConnectionManager instance;
  
  private ConnectionManager(){
  }
  
  public static ConnectionManager getInstance() {
    if(instance==null){
      instance=new ConnectionManager();
    }
    return instance;
  }
  
  public static void setInstance(ConnectionManager instance) {
    ConnectionManager.instance = instance;
  }
  
  public Connection etablirconnection(){
    Connection c=null;
    try{
      Class.forName("com.mysql.jdbc.Driver");
      c=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbibleo","root","");
    }
    catch(ClassNotFoundException e){
      e.printStackTrace();
    }
    catch(SQLException e){
      e.printStackTrace();
    }
    catch(Exception e){
      e.printStackTrace();
    }
    return c;
  }
  
  public void fermerConnection(Connection c)
  {
    if(c!=null)
    {
      try{
        c.close();
      }catch(SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  
}
