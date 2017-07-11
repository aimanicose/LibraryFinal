package Service;

import Models.Book;
import java.util.List;

public interface IBookService {
  
  boolean addBook(Book b);
  
  boolean deleteBook(Book b);
  
  boolean updateBook(Book b);
  
  Book selectBook(Book b);
  
  List<Book> selectListBook();
  
  List<Book> selectBookIdName();
  
  int bookinstore();
  
  int bookoutstore();
  
  Book getBookID(Book b);
  
  List<Book> ListBookZero();
}
