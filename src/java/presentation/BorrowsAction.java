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
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.ServletActionContext;

public class BorrowsAction extends ActionSupport {
  
  private String borrowReference;
  private String returnDate;
  private String newStatus;
  private InputStream stream;
  
  public String redirectBorrows(){
    List<Preter> pretersList = new ArrayList<Preter>();
    IPreterService pretersService=new PreterServiceImpl();
    pretersList = pretersService.selectPreter();
    ServletActionContext.getRequest().getSession().setAttribute("pretersList", pretersList);
    return "success";
  }
  
  public String updateBorrows(){
    String str;
    Preter newPret = new Preter();
    newPret.setReference(borrowReference);
    newPret.setDateEntree(returnDate);
    newPret.setStatut(newStatus);
    
    IPreterService pretersService=new PreterServiceImpl();
    boolean updated = pretersService.updatePreter(newPret);
     if(updated){
      str = "success";
    }else{
      str = "failure";
    }
    stream = new ByteArrayInputStream(str.getBytes());
    return SUCCESS;
  }
  
  public String getBorrowReference() {
    return borrowReference;
  }
  
  public void setBorrowReference(String borrowReference) {
    this.borrowReference = borrowReference;
  }
  
  public String getReturnDate() {
    return returnDate;
  }
  
  public void setReturnDate(String returnDate) {
    this.returnDate = returnDate;
  }
  
  public String getNewStatus() {
    return newStatus;
  }
  
  public void setNewStatus(String newStatus) {
    this.newStatus = newStatus;
  }

  public InputStream getStream() {
    return stream;
  }

  public void setStream(InputStream stream) {
    this.stream = stream;
  }
  
  
}
