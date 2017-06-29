package presentation;


import Models.Profile;
import Models.User;
import Models.UserInformation;
import Service.IUserService;
import Service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class AuthAction extends ActionSupport {
  IUserService IU=new UserServiceImpl();
  private User bean;
  private User autheticationUser;
  private UserInformation beanui;
  private Profile beanp;
  

  public String connectUser(){
    
    autheticationUser = IU.selectUser(bean) ;
    
    
    if(autheticationUser == null)
    {
      return "error";
    }
    else
    {
      ServletActionContext.getRequest().getSession().setAttribute("userSession", autheticationUser.getLogin());
      return "success"; 
    }

   
  }
  
  @Override
  public void validate(){
    if(bean == null){
        return;
    }
    if(bean.getLogin().trim().length() == 0){
        addFieldError("errorLogin", "Required");
    }
  }

  public User getBean() {
    return bean;
  }

  public void setBean(User bean) {
    this.bean = bean;
  }
  public String logout(){
    
    
      ServletActionContext.getRequest().getSession().invalidate();
      return "success"; 
    

   
  }
   public String addUser(){

    bean.setUserInformation(beanui); 
    bean.setUserProfile(beanp);
    IU.addUser(bean);   
    return "success"; 
    

   
  }

    /**
     * @return the beanui
     */
    public UserInformation getBeanui() {
        return beanui;
    }

    /**
     * @param beanui the beanui to set
     */
    public void setBeanui(UserInformation beanui) {
        this.beanui = beanui;
    }

    /**
     * @return the beanp
     */
    public Profile getBeanp() {
        return beanp;
    }

    /**
     * @param beanp the beanp to set
     */
    public void setBeanp(Profile beanp) {
        this.beanp = beanp;
    }
}
