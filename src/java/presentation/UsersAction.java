package presentation;
import Models.Profile;
import Models.User;
import Models.UserInformation;
import Service.IUserService;
import Service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.ServletActionContext;

public class UsersAction extends ActionSupport {
  IUserService IU=new UserServiceImpl();
  
  public String getListUsers(){
    List<UserInformation> userInfo = new ArrayList<UserInformation>();
    userInfo = IU.selectInforamtion();
    ServletActionContext.getRequest().getSession().setAttribute("usersList", userInfo);
    return "success";
  }
}