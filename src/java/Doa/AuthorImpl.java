/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Doa;

import Models.Author;
import Models.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YS
 */
public class AuthorImpl implements IAuthor {
  Select sb=new Select();
  @Override
  public boolean addAuthor(Author a) {
    
    Connection c=null;
    boolean bool=false;
    try
    {
      c=ConnectionManager.getInstance().etablirconnection();
      String req="insert into author (AuthorID,AuthorBirthDate,AuthorFirstname,AuthorLastname,AuthorPenname,AuthorNationality ,AuthorSexe,AuthorBiography,AuthorImageID) values("+a.getAuthorID()+",'"+a.getAuthorBirthDate()+"','"+a.getAuthorFirstName()+"','"+a.getAuthorLastName()+"','"+a.getAuthorPenName()+"','"+a.getAuthorNationality()+"','"+a.getAuthorSexe()+"','"+a.getAuthorBiography()+"','"+a.getAuthorImageID()+"')";
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
  public boolean deleteAuthor(Author a) {
    Connection c=null;
    boolean bool=false;
    try
    {
      c=ConnectionManager.getInstance().etablirconnection();
      String req1="delete from book WHERE AuthorID = "+a.getAuthorID()+"";
      String req="delete from author WHERE AuthorID = "+a.getAuthorID()+"";
      Statement st=c.createStatement();
      st.execute(req1);
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
  public boolean updateAuthor(Author a) {
    Connection c=null;
    boolean bool=false;
    try
    {
      c=ConnectionManager.getInstance().etablirconnection();
      String req="UPDATE author SET AuthorBirthDate = '"+a.getAuthorBirthDate()+"',AuthorFirstname  = '"+a.getAuthorFirstName()+"',AuthorLastname = '"+a.getAuthorLastName()+"',AuthorPenname = '"+a.getAuthorPenName()+"',AuthorNationality = '"+a.getAuthorNationality()+"',AuthorSexe = '"+a.getAuthorSexe()+"',AuthorBiography = '"+a.getAuthorBiography()+"',AuthorImageID = '"+a.getAuthorImageID()+"' WHERE AuthorID = "+a.getAuthorID()+"";
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
  public Author selectAuthor(Author a) {
    List<Book> listbook=null;
    Connection c=null;
    Author a1=null;
    ResultSet s;
    try
    {
      c=ConnectionManager.getInstance().etablirconnection();
      
      String req="select * from author where AuthorID="+a.getAuthorID()+"";
      
      Statement st=c.createStatement();
      
      listbook = sb.selectBooks(a);
      
      s=st.executeQuery(req);
      
      
      
      while(s.next())
      {
        a1= new Author();
        a1.setAuthorID(Integer.parseInt(s.getString("AuthorID")));
        a1.setAuthorBirthDate(s.getString("AuthorBirthDate"));
        a1.setAuthorFirstName(s.getString("AuthorFirstname"));
        a1.setAuthorLastName(s.getString("AuthorLastname"));
        a1.setAuthorPenName(s.getString("AuthorPenname"));
        a1.setAuthorNationality(s.getString("AuthorNationality"));
        a1.setAuthorSexe(s.getString("AuthorSexe"));
        a1.setAuthorBiography(s.getString("AuthorBiography"));
        a1.setAuthorImageID(s.getString("AuthorImageID"));
        a1.setBookList(listbook);
        
      }
      
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    finally{
      ConnectionManager.getInstance().fermerConnection(c);
    }
    
    return a1;
  }
  
  
  @Override
  public List<Author> selectListAuthor() {
    List<Author> listauthor=new ArrayList<Author>();
    List<Book> listbook=null;
    Connection c=null;
    Author a1=null;
    ResultSet s;
    try
    {
      c=ConnectionManager.getInstance().etablirconnection();
      String req="select * from author";
      Statement st=c.createStatement();
      s=st.executeQuery(req);
      
      
      
      while(s.next())
      {
        listbook = new ArrayList<Book>();
        a1= new Author();
        a1.setAuthorID(Integer.parseInt(s.getString("AuthorID")));
        a1.setAuthorBirthDate(s.getString("AuthorBirthDate"));
        a1.setAuthorFirstName(s.getString("AuthorFirstname"));
        a1.setAuthorLastName(s.getString("AuthorLastname"));
        a1.setAuthorPenName(s.getString("AuthorPenname"));
        a1.setAuthorNationality(s.getString("AuthorNationality"));
        a1.setAuthorSexe(s.getString("AuthorSexe"));
        a1.setAuthorBiography(s.getString("AuthorBiography"));
        a1.setAuthorImageID(s.getString("AuthorImageID"));
        listbook=sb.selectBooks(a1);
        a1.setBookList(listbook);
        listauthor.add(a1);
        
      }
      
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    finally{
      ConnectionManager.getInstance().fermerConnection(c);
    }
    
    return listauthor;
  }
}
