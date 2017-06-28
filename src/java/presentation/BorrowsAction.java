/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;


import Models.Preter;
import Service.AuthorServiceImpl;
import Service.IAuthorService;
import Service.IPreterService;
import Service.PreterServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author YS
 */
public class BorrowsAction extends ActionSupport {
    public String redirectBorrows(){
    List<Preter> pretersList = new ArrayList<Preter>();
        IPreterService pretersService=new PreterServiceImpl();
    pretersList = pretersService.selectPreter();
    System.out.println(pretersList.get(0).getBook().getBookName());
    
    ServletActionContext.getRequest().getSession().setAttribute("pretersList", pretersList);
    System.out.println(ServletActionContext.getRequest().getSession().getAttribute("pretersList"));
    return "success";
  }
}
