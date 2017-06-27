/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;

import Models.Author;
import Models.Book;
import Models.BookGenre;
import Models.Editor;
import Models.Profile;
import Models.User;
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
public class Select {
    public Author selectAuthor(Author a)
    {
        Connection c=null;
		Author a1=null;
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from author where AuthorID="+a.getAuthorID()+"";
                      
                        Statement st=c.createStatement();
                      
              
                      
                             s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{
			     a1= new Author();
                             a1.setAuthorID(Integer.parseInt(s.getString("AuthorID")));
                             a1.setAuthorBirthDate(s.getString("AuthorBirthDate"));
                             a1.setAuthorFirstName(s.getString("AuthorFirstname"));
                             a1.setAuthorLastName(s.getString("AuthorLastname"));
                             a1.setAuthorNationality(s.getString("AuthorNationality"));
                             a1.setAuthorSexe(s.getString("AuthorSexe"));
                             a1.setAuthorBiography(s.getString("AuthorBiography"));
                             a1.setAuthorImageID(s.getString("AuthorImageID"));
                             

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
    public Editor selectEditor(Editor e)
    {
        Connection c=null;
		Editor e1=null;
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from editor where EditorID="+e.getEditorID()+"";
                      
                        Statement st=c.createStatement();
                      
                         
                      
                             s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{
			     e1=new Editor();
                             e1.setEditorID(Integer.parseInt(s.getString("EditorID")));
                             e1.setEditorName(s.getString("EditorName"));
                             e1.setEditorAddress(s.getString("EditorAddress"));
                          
                             
                             

			}
                        
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return e1;
    }
    public BookGenre selectBookGenre(BookGenre bg)
    {
        Connection c=null;
		BookGenre b1=null;
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();              
			String req="select * from bookgenre where GenreID="+bg.getGenreID()+"";
                      
                        Statement st=c.createStatement();
                        s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{
			     b1=new BookGenre();
                             b1.setGenreID(Integer.parseInt(s.getString("GenreID")));
                             b1.setGenreName(s.getString("GenreName"));
			}
                        
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return b1;
    }
    public List<Book> selectBooks(Author a) {
        List<Book> listbook=new ArrayList<Book>();
        Author author=new Author();
        Editor editor=new Editor();
        BookGenre bookgenre=new BookGenre();
        
                Connection c=null;
		Book b=null;
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from book where AuthorID="+a.getAuthorID()+"";
                        Statement st=c.createStatement();
                      
                      
                             s=st.executeQuery(req);
                        
			
			
			while(s.next())//s.getString("login"),s.getString("pwd"),s.getString("fk_profil").toString()
			{
			     b= new Book();
                             b.setBookID(Integer.parseInt(s.getString("BookID")));
                             b.setBookLanguage(s.getString("BookLanguage"));
                             b.setBookName(s.getString("BookName"));
                             b.setBookPrice(Double.parseDouble(s.getString("BookPrice")));
                             b.setBookPublicationDate(s.getString("PublicationDate"));
                             b.setBookSummary(s.getString("bookSummary"));
                             b.setBookReferance(s.getString("bookReferance"));
                             b.setBooksInStore(Integer.parseInt(s.getString("booksInStore")));
                             b.setBookImageId(s.getString("bookImageId"));
                             author=selectAuthor(a);
                             editor.setEditorID(Integer.parseInt(s.getString("EditorID")));
                             bookgenre.setGenreID(Integer.parseInt(s.getString("GenreID")));
                             editor=selectEditor(editor);
                             bookgenre=selectBookGenre(bookgenre);
                             b.setBookAuthor(author);
                             b.setBookEditor(editor);
                             b.setBookGenre(bookgenre);
                             listbook.add(b);

			}
                        
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return listbook;
    }
    public List<Book> selectBooks(Editor e) {
        List<Book> listbook=new ArrayList<Book>();
        Author author=new Author();
        Editor editor=new Editor();
        BookGenre bookgenre=new BookGenre();        
        Connection c=null;
		Book b=null;
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from book where EditorID="+e.getEditorID()+"";
                      
                        Statement st=c.createStatement();
                      
                      
                             s=st.executeQuery(req);
                        
			
			
			while(s.next())//s.getString("login"),s.getString("pwd"),s.getString("fk_profil").toString()
			{
			     b= new Book();
                             b.setBookID(Integer.parseInt(s.getString("BookID")));
                             b.setBookLanguage(s.getString("BookLanguage"));
                             b.setBookName(s.getString("BookName"));
                             b.setBookPrice(Double.parseDouble(s.getString("BookPrice")));
                             b.setBookPublicationDate(s.getString("PublicationDate"));
                             b.setBookSummary(s.getString("bookSummary"));
                             b.setBookReferance(s.getString("bookReferance"));
                             b.setBooksInStore(Integer.parseInt(s.getString("booksInStore")));
                             b.setBookImageId(s.getString("bookImageId"));
                             author.setAuthorID(Integer.parseInt(s.getString("AuthorID")));
                             editor.setEditorID(Integer.parseInt(s.getString("EditorID")));
                             bookgenre.setGenreID(Integer.parseInt(s.getString("GenreID")));
                             author=selectAuthor(author);
                             editor=selectEditor(editor);
                             bookgenre=selectBookGenre(bookgenre);
                             b.setBookAuthor(author);
                             b.setBookEditor(editor);
                             b.setBookGenre(bookgenre);
                             listbook.add(b);

			}
                        
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return listbook;
    }
    public List<Book> selectBooks(BookGenre bg) {
        List<Book> listbook=new ArrayList<Book>();
        Author author=new Author();
        Editor editor=new Editor();
        BookGenre bookgenre=new BookGenre();
                Connection c=null;
		Book b=null;
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from book where GenreID="+bg.getGenreID()+"";
                      
                        Statement st=c.createStatement();
                     
                        s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{
                            
			    b= new Book();
                             b.setBookID(Integer.parseInt(s.getString("BookID")));
                             b.setBookLanguage(s.getString("BookLanguage"));
                             b.setBookName(s.getString("BookName"));
                             b.setBookPrice(Double.parseDouble(s.getString("BookPrice")));
                             b.setBookPublicationDate(s.getString("PublicationDate"));
                             b.setBookSummary(s.getString("bookSummary"));
                             b.setBookReferance(s.getString("bookReferance"));
                             b.setBooksInStore(Integer.parseInt(s.getString("booksInStore")));
                             b.setBookImageId(s.getString("bookImageId"));
                             author.setAuthorID(Integer.parseInt(s.getString("AuthorID")));
                             editor.setEditorID(Integer.parseInt(s.getString("EditorID")));
                             bookgenre.setGenreID(Integer.parseInt(s.getString("GenreID")));
                             author=selectAuthor(author);
                             editor=selectEditor(editor);
                             bookgenre=selectBookGenre(bookgenre);
                             b.setBookAuthor(author);
                             b.setBookEditor(editor);
                             b.setBookGenre(bookgenre);
                             listbook.add(b);

			}
                        
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return listbook;
    }
    public UserInformation selectuserinformation(User u)
    {
                UserInformation ui=null;
                Connection c=null;
		
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from userinformation where UserID ="+u.getUserID()+"";
                      
                        Statement st=c.createStatement();
                        s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{
			     ui=new UserInformation();
                             ui.setUserID(Integer.parseInt(s.getString("UserID")));
                             ui.setUserFirstName(s.getString("UserFirstname"));
                             ui.setUserAddress(s.getString("UserAddress"));
                             ui.setUserBirthDate(s.getString("UserBirthdate"));
                             ui.setUserEmail(s.getString("UserEmail"));
                             ui.setUserLastName(s.getString("UserLastname"));
			}
                        
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return ui;
    }
    public List<User> selectusers(Profile p) {
        Profile p1=null;
        User u=null;
        List<User> listuser=null;
                Connection c=null;
		
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from user where ProfilID="+p.getProfileID()+"";
                      
                        Statement st=c.createStatement();
                        s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{
                             p1=new Profile();
			     u=new User();
                             p1.setProfileID(Integer.parseInt(s.getString("ProfilID")));
                             u.setUserID(Integer.parseInt(s.getString("UserID")));
                             u.setLogin(s.getString("login"));
                             u.setPassword(s.getString("password"));
                             u.setUserProfile(selectprofile(p1));
                             u.setUserInformation(selectuserinformation(u));
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
    public Profile selectprofile(Profile p)
    {
         Profile p1=null;
       
                Connection c=null;
		
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from profil where ProfilID="+p.getProfileID()+"";
                      
                        Statement st=c.createStatement();
                      
                      
                             s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{
			     p1=new Profile();
                             p1.setProfileID(Integer.parseInt(s.getString("ProfilID")));
                             p1.setProfileName(s.getString("ProfilName"));
                                     
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
}
