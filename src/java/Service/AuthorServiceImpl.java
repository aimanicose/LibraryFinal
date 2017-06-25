/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Doa.AuthorImpl;
import Doa.IAuthor;
import Models.Author;
import java.util.List;

/**
 *
 * @author YS
 */
public class AuthorServiceImpl implements IAuthorService {
IAuthor ia=new AuthorImpl();

    @Override
    public boolean addAuthor(Author a) {
        return ia.addAuthor(a);
    }

    @Override
    public boolean deleteAuthor(Author a) {
        return ia.deleteAuthor(a);
    }

    @Override
    public boolean updateAuthor(Author a) {
        return ia.updateAuthor(a);
    }

    @Override
    public Author selectAuthor(Author a) {
        return ia.selectAuthor(a);
    }

    @Override
    public List<Author> selectListAuthor() {
        return ia.selectListAuthor();
    }
    
}
