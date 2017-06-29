package presentation;

import Models.Author;
import Models.Book;
import Models.BookGenre;
import Models.Editor;
import Models.Preter;
import Models.User;
import Service.BookServiceImpl;
import Service.IBookService;
import Service.IPreterService;
import Service.PreterServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.struts2.ServletActionContext;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class BooksAction extends ActionSupport {
  private File fileUpload;
  private String fileUploadContentType;
  private String fileUploadFileName;
  private InputStream stream;
  private InputStream inOutBooks;
  private int bookId;
  private List<Object> authorEditorInfo;
  private List<Book> borrowBookList;
  private User borrowUser;
  private String borrowDate;
  private String borrowSumary;
  private String bookAuthor;
  private String bookEditor;
  private String bookGenre;
  private Book beanBook;
  
  
  
  public String redirectBooks(){
    List<Book> bookList = new ArrayList<Book>();
    IBookService bookService = new BookServiceImpl();
    bookList = bookService.selectListBook();
    ServletActionContext.getRequest().getSession().setAttribute("booksList", bookList);
    return "success";
  }
  
  public String bookDetails(){
    Book book = new Book();
    book.setBookID(bookId);
    IBookService bookService = new BookServiceImpl();
    book = bookService.selectBook(book);
    ServletActionContext.getRequest().getSession().setAttribute("detailedBook", book);
    return "success";
  }
  
  public String deleteBook(){
    String str;
    List<Book> bookList = new ArrayList<Book>();
    IBookService bookService = new BookServiceImpl();
    Book book = new Book();
    book.setBookID(bookId);
    boolean deleted = bookService.deleteBook(book);
    if(deleted){
      bookList = bookService.selectListBook();
      ServletActionContext.getRequest().getSession().setAttribute("booksList", bookList);
      str = "success";
    }else{
      str = "failure";
    }
    
    stream = new ByteArrayInputStream(str.getBytes());
    return SUCCESS;
    
  }
  
  
  public String updateBook(){
    List<Book> bookList = new ArrayList<Book>();
    IBookService bookService = new BookServiceImpl();
    Author testA = new Author();
    testA.setAuthorFirstName(bookAuthor);
    Editor testE = new Editor();
    testE.setEditorName(bookEditor);
    BookGenre testG = new BookGenre();
    testG.setGenreName(bookGenre);
    
    beanBook.setBookEditor(testE);
    beanBook.setBookAuthor(testA);
    beanBook.setBookGenre(testG);
    
    boolean updated = bookService.updateBook(beanBook);
    if(updated == true){
      bookList =  bookService.selectListBook();
      ServletActionContext.getRequest().getSession().setAttribute("booksList", bookList);
      return "success";
    }else{
      return "failure";
    }
  }
  
  public String addBook() throws IOException
  {
    List<Book> bookList = new ArrayList<Book>();
    IBookService bookService = new BookServiceImpl();
    Book book = new Book();
    Author a=new Author();
    a.setAuthorLastName(bookAuthor);
    Editor e=new Editor();
    e.setEditorName(getBookEditor());
    BookGenre bg=new BookGenre();
    bg.setGenreName(getBookGenre());
    book.setBookPrice(beanBook.getBookPrice());

    bg.setGenreName(bookGenre);

    book.setBookAuthor(a);
    book.setBookEditor(e);
    book.setBookGenre(bg);
    book.setBookImageId(fileUploadFileName);
    book.setBookLanguage(beanBook.getBookLanguage());
    book.setBookName(beanBook.getBookName());
    book.setBookPublicationDate(beanBook.getBookPublicationDate());
    book.setBookReferance(beanBook.getBookReferance());
    book.setBookSummary(beanBook.getBookSummary());
    book.setBooksInStore(beanBook.getBooksInStore());
    Image img = ImageIO.read(fileUpload);
    BufferedImage bi = (BufferedImage)img;
    File f = new File("C:\\Users\\YS\\Documents\\NetBeansProjects\\LibraryFinal\\web\\vues\\img\\bookCovers\\"+fileUploadFileName+".png");
    ImageIO.write(bi, "png", f);
    boolean add = bookService.addBook(book);
    bookList=bookService.selectListBook();
    ServletActionContext.getRequest().getSession().setAttribute("booksList", bookList);
    return "success";
  }
  public String authorEditorInfo(){
    authorEditorInfo = new ArrayList<Object>();
    return "json";
  }
  
  public String bookAllocation(){
    IPreterService preter = new PreterServiceImpl();
  
    for(Book book:borrowBookList){
      Preter p =  new Preter();
      p.setBook(book);
      p.setDateSortie(borrowDate);
      p.setMessage(borrowSumary);
      p.setUser(borrowUser);
      p.setStatut("OUT");
      preter.addPreter(p);
    }
    
    return "success";
  }
  
  public String booksNumber(){
    List<String> booksNumber = new ArrayList<String>();
    IBookService bookService = new BookServiceImpl();
    booksNumber.add(Integer.toString(bookService.bookinstore()));
    booksNumber.add(Integer.toString(bookService.bookoutstore()));
    GsonBuilder gb = new GsonBuilder();
    Gson s = gb.create();
    String jsonResponse = s.toJson(booksNumber);
    inOutBooks = new ByteArrayInputStream(jsonResponse.getBytes());
    return SUCCESS;
  }
// file name of the upload file is included in content-disposition header like this:
//form-data; name="dataFile"; filename="PHOTO.JPG"
  
  public int getBookId() {
    return bookId;
  }
  
  public void setBookId(int bookId) {
    this.bookId = bookId;
  }
  
  public InputStream getStream() {
    return stream;
  }
  
  public List<Object> getAuthorEditorInfo() {
    return authorEditorInfo;
  }
  
  public void setAuthorEditorInfo(List<Object> authorEditorInfo) {
    this.authorEditorInfo = authorEditorInfo;
  }
  
  public List<Book> getBorrowBookList() {
    return borrowBookList;
  }
  
  public void setBorrowBookList(List<Book> borrowBookList) {
    this.borrowBookList = borrowBookList;
  }
  
  
  
  public User getBorrowUser() {
    return borrowUser;
  }
  
  public void setBorrowUser(User borrowUser) {
    this.borrowUser = borrowUser;
  }
  
  public String getBorrowDate() {
    return borrowDate;
  }
  
  public void setBorrowDate(String borrowDate) {
    this.borrowDate = borrowDate;
  }
  
  public String getBorrowSumary() {
    return borrowSumary;
  }
  
  public void setBorrowSumary(String borrowSumary) {
    this.borrowSumary = borrowSumary;
  }
  
  public InputStream getInOutBooks() {
    return inOutBooks;
  }
  
  public void setInOutBooks(InputStream inOutBooks) {
    this.inOutBooks = inOutBooks;
  }
  public String getFileUploadContentType() {
    return fileUploadContentType;
  }
  
  public void setFileUploadContentType(String fileUploadContentType) {
    this.fileUploadContentType = fileUploadContentType;
  }
  
  public String getFileUploadFileName() {
    return fileUploadFileName;
  }
  
  public void setFileUploadFileName(String fileUploadFileName) {
    this.fileUploadFileName = fileUploadFileName;
  }
  
  public File getFileUpload() {
    return fileUpload;
  }
  
  public void setFileUpload(File fileUpload) {
    this.fileUpload = fileUpload;
  }

  public Book getBeanBook() {
    return beanBook;
  }

  public void setBeanBook(Book beanBook) {
    this.beanBook = beanBook;
  }

    /**
     * @return the bookAuthor
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * @param bookAuthor the bookAuthor to set
     */
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    /**
     * @return the bookEditor
     */
    public String getBookEditor() {
        return bookEditor;
    }

    /**
     * @param bookEditor the bookEditor to set
     */
    public void setBookEditor(String bookEditor) {
        this.bookEditor = bookEditor;
    }

    /**
     * @return the bookGenre
     */
    public String getBookGenre() {
        return bookGenre;
    }

    /**
     * @param bookGenre the bookGenre to set
     */
    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }
}
