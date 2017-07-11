package presentation;

import Models.Book;
import Service.BookServiceImpl;
import Service.IBookService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.ServletActionContext;


public class GetDataAction {
  
  private InputStream stream;
  
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
   
    
    return SUCCESS;
  }
  
  public InputStream getStream() {
    return stream;
  }
}
