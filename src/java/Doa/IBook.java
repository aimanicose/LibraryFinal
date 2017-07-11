/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;

import Models.Book;
import java.util.List;

/**
 *
 * @author YS
 */
public interface IBook {
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
