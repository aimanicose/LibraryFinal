/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Models.Author;
import Models.Book;
import Models.BookGenre;
import Models.Editor;
import Models.Inventaire;
import Models.Preter;
import Models.Profile;
import Models.Section;
import Models.User;
import Models.UserInformation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author YS
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        IBookService IB=new BookServiceImpl();
       IAuthorService ia=new AuthorServiceImpl();
       IBookGenreService ibg=new BookGenreServiceImpl();
       IEditorService ie=new EditorServiceImpl();
       IProfileService ip=new ProfileServiceImpl();
       ISectionService is=new SectionServiceImpl();
       IUserService iu = new UserServiceImpl();
       IInventaireService iis=new InventaireServiceImpl();
       IPreterService ips=new PreterServiceImpl();
      
      User u=new User();
       Book b=new Book();
       u.setUserID(1);
       
       b.setBookID(1);
       Preter p=new Preter();
       p.setBook(b);
       p.setUser(u);
       p.setMessage("test1");
       p.setDateSortie("2017-01-17");
       ips.addPreter(p);
       
    // System.out.println(IB.bookoutstore());
       
  
      /*Gson objGson = new GsonBuilder().setPrettyPrinting().create();
       System.out.println("1.Convert list of book objects to Json");
       String json = objGson.toJson(ips.selectPreter());
       System.out.println(json);*/
           //FileWriter fileWriter = new FileWriter("D:\\books.json");
           // fileWriter.write(json);
           // fileWriter.close();
           //System.out.println(IB.selectListString());
    /*Profile p=new Profile();
       p.setProfileID(1);
       u.setLogin("aaa");
       u.setPassword("123");
       u.setUserID(6);
       u.setUserProfile(p);
       UserInformation ui=new UserInformation();
       ui.setUserID(u.getUserID());
       ui.setUserBirthDate("1955-05-02");
       u.setUserInformation(ui);
       iu.updateUser(u);*/
       
       
       
       
       
       /*BookGenre bg=new BookGenre();
       bg.setGenreID(12);
       s.setGenre(bg);
       s.setSectionID(12);
       s.setNomberBook(14);
       is.addSection(s);*/
       
     
      
     
    
   
    }
    
}
