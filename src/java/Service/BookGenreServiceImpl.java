/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Doa.BookGenreImpl;
import Doa.IBookGenre;
import Models.BookGenre;
import java.util.List;

/**
 *
 * @author YS
 */
public class BookGenreServiceImpl implements IBookGenreService {
IBookGenre bookgenre=new BookGenreImpl();
    @Override
    public boolean addBookGenre(BookGenre bg) {
        return bookgenre.addBookGenre(bg);
    }

    @Override
    public boolean deleteBookGenre(BookGenre bg) {
        return bookgenre.deleteBookGenre(bg);
    }

    @Override
    public boolean updateBookGenre(BookGenre bg) {
        return bookgenre.updateBookGenre(bg);
    }

    @Override
    public BookGenre selectBookGenre(BookGenre bg) {
        return bookgenre.selectBookGenre(bg);
    }

    @Override
    public List<BookGenre> selectListBookGenre() {
        return bookgenre.selectListBookGenre();
    }
    
}
