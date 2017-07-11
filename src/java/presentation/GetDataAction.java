package presentation;

import Models.Book;
import Models.Preter;
import Service.BookServiceImpl;
import Service.IBookService;
import Service.IPreterService;
import Service.PreterServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.ServletActionContext;


public class GetDataAction {
  
  private InputStream stream;
  private InputStream notificationsList;
  
  public String getData(){
    List<Book> bookList = new ArrayList<Book>();
    IBookService bookService = new BookServiceImpl();
    bookList = bookService.selectBookIdName();
    GsonBuilder gb = new GsonBuilder();
    Gson s = gb.create();
    String jsonResponse = s.toJson(bookList);
    stream = new ByteArrayInputStream(jsonResponse.getBytes());
    return SUCCESS;
  }
  
  public String getNotifications(){
    List<Preter> lateBorrows = new ArrayList<Preter>();
    List<String> notification = new ArrayList<String>();
    IPreterService preterService = new PreterServiceImpl();
    lateBorrows = preterService.latebookslist();
    
    for(Preter p:lateBorrows){
      String notifBorrow = "The user \""+p.getUser().getUserInformation().getUserLastName()+"\" has exceeded the 6 months borrowing period for the book \""+p.getBook().getBookName()+"\"";
      notification.add(notifBorrow);
    }
    
    List<Book> emptyBooks = new ArrayList<Book>();
    IBookService bookService = new BookServiceImpl();
    emptyBooks = bookService.ListBookZero();
    
    for(Book b:emptyBooks){
      String notifBook = "The are no more copies of the book \""+b.getBookName()+"\" in the library";
      notification.add(notifBook);
    }
    
    GsonBuilder gb = new GsonBuilder();
    Gson s = gb.create();
    String jsonResponse = s.toJson(notification);
    notificationsList = new ByteArrayInputStream(jsonResponse.getBytes());
    return SUCCESS;
  }

  
  public InputStream getStream() {
    return stream;
  }

  public InputStream getNotificationsList() {
    return notificationsList;
  }

  public void setNotificationsList(InputStream notificationsList) {
    this.notificationsList = notificationsList;
  }
  
  
}
