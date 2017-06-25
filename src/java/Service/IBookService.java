/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Models.Book;
import java.util.List;


/**
 *
 * @author YS
 */

public interface IBookService {
    
    boolean addBook(Book b);
   
    boolean deleteBook(Book b);
   
    boolean updateBook(Book b);
  
    Book selectBook(Book b);
    
    List<Book> selectListBook();
   
    List<Book> selectBookIdName();
       
}
