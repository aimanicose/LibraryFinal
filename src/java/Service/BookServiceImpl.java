/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Service;

import Doa.BookImpl;
import Doa.IBook;
import Models.Book;
import java.util.List;

public class BookServiceImpl implements IBookService {
  IBook IB=new BookImpl();
  
  @Override
  public boolean addBook(Book b) {
    return IB.addBook(b);
  }
  
  @Override
  public boolean deleteBook(Book b) {
    return IB.deleteBook(b);
  }
  
  @Override
  public boolean updateBook(Book b) {
    return IB.updateBook(b);
  }
  
  @Override
  public Book selectBook(Book b) {
    return IB.selectBook(b);
  }
  
  @Override
  public List<Book> selectListBook() {
    
    return IB.selectListBook();
  }
  @Override
  public List<Book> selectBookIdName() {
    return IB.selectBookIdName();
  }
  @Override
  public int bookinstore()
  {
    return IB.bookinstore();
  }
  @Override
  public int bookoutstore()
  {
    return IB.bookoutstore();
  }
  
  public Book getBookID(Book b){
     return IB.getBookID(b);
  }

    @Override
    public List<Book> ListBookZero() {
        return IB.ListBookZero();
    }
  
}
