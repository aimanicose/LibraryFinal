package presentation;

import Models.Author;
import Service.AuthorServiceImpl;
import Service.IAuthorService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import java.util.ArrayList;
import java.util.List;

public class AuthorsAction extends ActionSupport {

  public String authorsList(){
    List<Author> authorsList = new ArrayList<Author>();
    IAuthorService authorsService = new AuthorServiceImpl();
    authorsList = authorsService.selectListAuthor();
    
    ServletActionContext.getRequest().getSession().setAttribute("auhtorsList", authorsList);
    return "success";
  }
}