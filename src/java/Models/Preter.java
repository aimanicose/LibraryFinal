package Models;


/**
 * @author YS
 * @version 1.0
 * @created 09-juin-2017 22:24:31
 */
public class Preter {

	private Book Book;
	private User User;
        private String DateSortie;
        private String Message;
        

    /**
     * @return the Book
     */
    public Book getBook() {
        return Book;
    }

    /**
     * @param Book the Book to set
     */
    public void setBook(Book Book) {
        this.Book = Book;
    }

    /**
     * @return the User
     */
    public User getUser() {
        return User;
    }

    /**
     * @param User the User to set
     */
    public void setUser(User User) {
        this.User = User;
    }

    /**
     * @return the DateSortie
     */
    public String getDateSortie() {
        return DateSortie;
    }

    /**
     * @param DateSortie the DateSortie to set
     */
    public void setDateSortie(String DateSortie) {
        this.DateSortie = DateSortie;
    }

    /**
     * @return the Message
     */
    public String getMessage() {
        return Message;
    }

    /**
     * @param Message the Message to set
     */
    public void setMessage(String Message) {
        this.Message = Message;
    }

	

}