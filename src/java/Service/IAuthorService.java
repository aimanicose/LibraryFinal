/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Models.Author;
import java.util.List;

/**
 *
 * @author YS
 */
public interface IAuthorService {
    
    boolean addAuthor(Author a);
    
    boolean deleteAuthor(Author a);
    
    boolean updateAuthor(Author a);
    
    Author selectAuthor(Author a);
    
    List<Author> selectListAuthor();
}
