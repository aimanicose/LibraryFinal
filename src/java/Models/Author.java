package Models;

import java.io.Serializable;
import java.util.List;


/**
 * @author Not-Aimane
 * @version 1.0
 * @created 09-juin-2017 22:24:30
 */
public class Author implements Serializable {

	private String authorBirthDate;
	private String authorFirstName;
	private int authorID;
	private String authorLastName;
        private String authorPenName;
	private String authorNationality;
	private String authorSexe;
	private List<Book> bookList;
        private String authorBiography;
        private String authorImageID;

    /**
     * @return the authorBirthDate
     */
    public String getAuthorBirthDate() {
        return authorBirthDate;
    }

    /**
     * @param authorBirthDate the authorBirthDate to set
     */
    public void setAuthorBirthDate(String authorBirthDate) {
        this.authorBirthDate = authorBirthDate;
    }

    /**
     * @return the authorFirstName
     */
    public String getAuthorFirstName() {
        return authorFirstName;
    }

    /**
     * @param authorFirstName the authorFirstName to set
     */
    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    /**
     * @return the authorID
     */
    public int getAuthorID() {
        return authorID;
    }

    /**
     * @param authorID the authorID to set
     */
    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    /**
     * @return the authorLastName
     */
    public String getAuthorLastName() {
        return authorLastName;
    }

    /**
     * @param authorLastName the authorLastName to set
     */
    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    /**
     * @return the authorNationality
     */
    public String getAuthorNationality() {
        return authorNationality;
    }

    /**
     * @param authorNationality the authorNationality to set
     */
    public void setAuthorNationality(String authorNationality) {
        this.authorNationality = authorNationality;
    }

    /**
     * @return the authorSexe
     */
    public String getAuthorSexe() {
        return authorSexe;
    }

    /**
     * @param authorSexe the authorSexe to set
     */
    public void setAuthorSexe(String authorSexe) {
        this.authorSexe = authorSexe;
    }

    /**
     * @return the bookList
     */
    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * @param bookList the bookList to set
     */
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

  public String getAuthorBiography() {
    return authorBiography;
  }

  public void setAuthorBiography(String authorBiography) {
    this.authorBiography = authorBiography;
  }

  public String getAuthorImageID() {
    return authorImageID;
  }

  public void setAuthorImageID(String authorImageID) {
    this.authorImageID = authorImageID;
  }

  public String getAuthorPenName() {
    return authorPenName;
  }

  public void setAuthorPenName(String authorPenName) {
    this.authorPenName = authorPenName;
  }
}

	