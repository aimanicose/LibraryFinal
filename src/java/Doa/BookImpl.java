package Doa;

import Models.Author;
import Models.Book;
import Models.BookGenre;
import Models.Editor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YS
 */
public class BookImpl implements IBook {
  Select select=new Select();
  Author a=new Author();
  Editor e =new Editor();
  BookGenre bg=new BookGenre();
  
  @Override
  public boolean addBook(Book b) {
    Connection c=null;
    boolean bool=false;
    try
    {
      
      c=ConnectionManager.getInstance().etablirconnection();
      String req="insert into book (BookID,BookLanguage,BookName,BookPrice,PublicationDate,bookSummary,bookReferance,bookImageId,booksInStore,AuthorID,EditorID,GenreID) values("+b.getBookID()+",'"+b.getBookLanguage()+"','"+b.getBookName()+"',"+b.getBookPrice()+",'"+b.getBookPublicationDate()+"','"+b.getBookSummary()+"','"+b.getBookReferance()+"','"+b.getBookImageId()+"',"+b.getBooksInStore()+","+b.getBookAuthor().getAuthorID()+","+b.getBookEditor().getEditorID()+","+b.getBookGenre().getGenreID()+")";
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
  public boolean deleteBook(Book b) {
    Connection c=null;
    boolean bool=false;
    try
    {
      c=ConnectionManager.getInstance().etablirconnection();
      String req1="delete from preter WHERE  BookID = "+b.getBookID()+"";
      String req="delete from book WHERE  BookID = "+b.getBookID()+"";
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
  public boolean updateBook(Book b) {
    Connection c=null;
    boolean bool=false;
    try
    {
      c=ConnectionManager.getInstance().etablirconnection();
      String req="UPDATE book SET bookSummary = '"+b.getBookSummary()+"',bookReferance = '"+b.getBookReferance()+"',bookImageId = '"+b.getBookImageId()+"',booksInStore = '"+b.getBooksInStore()+"',BookLanguage = '"+b.getBookLanguage()+"',BookName = '"+b.getBookName()+"',BookPrice = "+b.getBookPrice()+",PublicationDate = '"+b.getBookPublicationDate()+"',AuthorID = "+b.getBookAuthor().getAuthorID()+",EditorID = "+b.getBookEditor().getEditorID()+",GenreID = "+b.getBookGenre().getGenreID()+" WHERE BookID = "+b.getBookID()+"";
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
  public Book selectBook(Book b) {
    
    Connection c=null;
    Book b1=null;
    ResultSet s;
    try
    {
      c=ConnectionManager.getInstance().etablirconnection();
      
      String req="select * from book where BookID="+b.getBookID()+"";
      
      Statement st=c.createStatement();
      
      
      s=st.executeQuery(req);
      
      
      
      while(s.next())
      {
        a.setAuthorID(Integer.parseInt(s.getString("AuthorID")));
        e.setEditorID(Integer.parseInt(s.getString("EditorID")));
        bg.setGenreID(Integer.parseInt(s.getString("GenreID")));
        a=select.selectAuthor(a);
        e=select.selectEditor(e);
        bg=select.selectBookGenre(bg);
        b1= new Book();
        b1.setBookID(Integer.parseInt(s.getString("BookID")));
        b1.setBookLanguage(s.getString("BookLanguage"));
        b1.setBookName(s.getString("BookName"));
        b1.setBookPrice(Double.parseDouble(s.getString("BookPrice")));
        b1.setBookPublicationDate(s.getString("PublicationDate"));
        b1.setBookSummary(s.getString("bookSummary"));
        b1.setBookReferance(s.getString("bookReferance"));
        b1.setBooksInStore(Integer.parseInt(s.getString("booksInStore")));
        b1.setBookImageId(s.getString("bookImageId"));
        b1.setBookAuthor(a);
        b1.setBookEditor(e);
        b1.setBookGenre(bg);
        
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
  @Override
  public List<Book> selectListBook() {
    List<Book> listbook=new ArrayList<Book>();
    Connection c=null;
    Book b1=null;
    ResultSet s;
    try
    {
      c=ConnectionManager.getInstance().etablirconnection();
      
      String req="select * from book";
      
      Statement st=c.createStatement();
      
      
      s=st.executeQuery(req);
      
      
      
      while(s.next())//s.getString("login"),s.getString("pwd"),s.getString("fk_profil").toString()
      {
        a.setAuthorID(Integer.parseInt(s.getString("AuthorID")));
        e.setEditorID(Integer.parseInt(s.getString("EditorID")));
        bg.setGenreID(Integer.parseInt(s.getString("GenreID")));
        a=select.selectAuthor(a);
        e=select.selectEditor(e);
        bg=select.selectBookGenre(bg);
        b1= new Book();
        b1.setBookID(Integer.parseInt(s.getString("BookID")));
        b1.setBookLanguage(s.getString("BookLanguage"));
        b1.setBookName(s.getString("BookName"));
        b1.setBookPrice(Double.parseDouble(s.getString("BookPrice")));
        b1.setBookPublicationDate(s.getString("PublicationDate"));
        b1.setBookSummary(s.getString("bookSummary"));
        b1.setBookReferance(s.getString("bookReferance"));
        b1.setBooksInStore(Integer.parseInt(s.getString("booksInStore")));
        b1.setBookImageId(s.getString("bookImageId"));
        b1.setBookAuthor(a);
        b1.setBookEditor(e);
        b1.setBookGenre(bg);
        listbook.add(b1);
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
  
  @Override
  public List<Book> selectBookIdName() {
    List<Book> listbook=new ArrayList<Book>();
    Connection c=null;
    Book b1=null;
    ResultSet s;
    try
    {
      c=ConnectionManager.getInstance().etablirconnection();
      
      String req="select BookId,BookName from book";
      
      Statement st=c.createStatement();
      
      
      s=st.executeQuery(req);
      
      
      
      while(s.next())
      {
        b1= new Book();
        b1.setBookID(Integer.parseInt(s.getString("BookID")));
        b1.setBookName(s.getString("BookName"));
        listbook.add(b1);
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
  
  @Override
  public int bookinstore() {
    int bookinstore=0;
    Connection c=null;
    ResultSet s;
    try
    {
      c=ConnectionManager.getInstance().etablirconnection();
      
      String req="SELECT sum(booksInStore) as sumbookinstore from book";
      
      Statement st=c.createStatement();
      
      
      s=st.executeQuery(req);
      
      
      
      while(s.next())
      {
        bookinstore=Integer.parseInt(s.getString("sumbookinstore"));
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    finally{
      ConnectionManager.getInstance().fermerConnection(c);
    }
    return bookinstore;
  }
  
  @Override
  public int bookoutstore() {
    int bookoutstore=0;
    Connection c=null;
    ResultSet s;
    try
    {
      c=ConnectionManager.getInstance().etablirconnection();
      
      String req="SELECT count(BookID) as bookoutstore from preter";
      
      Statement st=c.createStatement();
      
      
      s=st.executeQuery(req);
      
      
      
      while(s.next())
      {
        bookoutstore=Integer.parseInt(s.getString("bookoutstore"));
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    finally{
      ConnectionManager.getInstance().fermerConnection(c);
    }
    return bookoutstore;
  }
  
  public Book getBookID(Book book){
    Connection c=null;
    Book b1=null;
    ResultSet s;
    try
    {
      c=ConnectionManager.getInstance().etablirconnection();
      
      String req="select BookID from book where BookName="+book.getBookName()+"";
      Statement st=c.createStatement();
      s=st.executeQuery(req);
      
      while(s.next())
      {
        b1.setBookID(Integer.parseInt(s.getString("BookID")));
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
  
}

