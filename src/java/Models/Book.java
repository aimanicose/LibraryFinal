package Models;

import java.io.Serializable;


/**
 * @author Not-Aimane
 * @version 1.0
 * @created 09-juin-2017 22:24:30
 */
public class Book implements Serializable {
  
  private Author bookAuthor;
  private Editor bookEditor;
  private BookGenre bookGenre;
  private int bookID;
  private String bookLanguage;
  private String bookName;
  private double bookPrice;
  private String bookPublicationDate;
  private String bookSummary;
  private String bookReferance;
  private String bookImageId;
  private int booksInStore;
  
  
  public Book() {
  }
  
  /**
   * @return the bookAuthor
   */
  public Author getBookAuthor() {
    return bookAuthor;
  }
  
  /**
   * @param bookAuthor the bookAuthor to set
   */
  public void setBookAuthor(Author bookAuthor) {
    this.bookAuthor = bookAuthor;
  }
  
  /**
   * @return the bookEditor
   */
  public Editor getBookEditor() {
    return bookEditor;
  }
  
  /**
   * @param bookEditor the bookEditor to set
   */
  public void setBookEditor(Editor bookEditor) {
    this.bookEditor = bookEditor;
  }
  
  /**
   * @return the bookGenre
   */
  public BookGenre getBookGenre() {
    return bookGenre;
  }
  
  /**
   * @param bookGenre the bookGenre to set
   */
  public void setBookGenre(BookGenre bookGenre) {
    this.bookGenre = bookGenre;
  }
  
  /**
   * @return the bookID
   */
  public int getBookID() {
    return bookID;
  }
  
  /**
   * @param bookID the bookID to set
   */
  public void setBookID(int bookID) {
    this.bookID = bookID;
  }
  
  /**
   * @return the bookLanguage
   */
  public String getBookLanguage() {
    return bookLanguage;
  }
  
  /**
   * @param bookLanguage the bookLanguage to set
   */
  public void setBookLanguage(String bookLanguage) {
    this.bookLanguage = bookLanguage;
  }
  
  /**
   * @return the bookName
   */
  public String getBookName() {
    return bookName;
  }
  
  /**
   * @param bookName the bookName to set
   */
  public void setBookName(String bookName) {
    this.bookName = bookName;
  }
  
  /**
   * @return the bookPrice
   */
  public double getBookPrice() {
    return bookPrice;
  }
  
  /**
   * @param bookPrice the bookPrice to set
   */
  public void setBookPrice(double bookPrice) {
    this.bookPrice = bookPrice;
  }
  
  /**
   * @return the bookPublicationDate
   */
  public String getBookPublicationDate() {
    return bookPublicationDate;
  }
  
  /**
   * @param bookPublicationDate the bookPublicationDate to set
   */
  public void setBookPublicationDate(String bookPublicationDate) {
    this.bookPublicationDate = bookPublicationDate;
  }
  
  /**
   * @return the bookSummary
   */
  public String getBookSummary() {
    return bookSummary;
  }
  
  /**
   * @param bookSummary the bookSummary to set
   */
  public void setBookSummary(String bookSummary) {
    this.bookSummary = bookSummary;
  }
  
  /**
   * @return the bookReferance
   */
  public String getBookReferance() {
    return bookReferance;
  }
  
  /**
   * @param bookReferance the bookReferance to set
   */
  public void setBookReferance(String bookReferance) {
    this.bookReferance = bookReferance;
  }
  
  /**
   * @return the bookImageId
   */
  public String getBookImageId() {
    return bookImageId;
  }
  
  /**
   * @param bookImageId the bookImageId to set
   */
  public void setBookImageId(String bookImageId) {
    this.bookImageId = bookImageId;
  }
  
  /**
   * @return the booksInStore
   */
  public int getBooksInStore() {
    return booksInStore;
  }
  
  /**
   * @param booksInStore the booksInStore to set
   */
  public void setBooksInStore(int booksInStore) {
    this.booksInStore = booksInStore;
  }
}