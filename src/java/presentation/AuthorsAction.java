package presentation;

import Models.Author;
import Service.AuthorServiceImpl;
import Service.IAuthorService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import java.util.ArrayList;
import java.util.List;

public class AuthorsAction extends ActionSupport {
  private int authorId;
  
  public String authorsList(){
    List<Author> authorsList = new ArrayList<Author>();
    IAuthorService authorsService = new AuthorServiceImpl();
    authorsList = authorsService.selectListAuthor();
    
    ServletActionContext.getRequest().getSession().setAttribute("auhtorsList", authorsList);
    return "success";
  }
    
  public String authorDetails(){
    Author author = new Author();
    author.setAuthorID(authorId);
    IAuthorService authorsService = new AuthorServiceImpl();
    author = authorsService.selectAuthor(author);
    
    ServletActionContext.getRequest().getSession().setAttribute("detailedAuthor", author);
    return "success";
  }

  public int getAuthorId() {
    return authorId;
  }

  public void setAuthorId(int authorId) {
    this.authorId = authorId;
  }
  
  
}