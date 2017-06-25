/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Models.Section;
import java.util.List;

/**
 *
 * @author YS
 */
public interface ISectionService {
    
    boolean addSection(Section s);
    
    boolean deleteSection(Section s);
    
    boolean updateSection(Section s);
    
    Section selectSection(Section s);
    
    List<Section> selectListSection();
}
