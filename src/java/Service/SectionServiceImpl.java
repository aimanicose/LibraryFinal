/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Doa.ISection;
import Doa.SectionImpl;
import Models.Section;
import java.util.List;

/**
 *
 * @author YS
 */
public class SectionServiceImpl implements ISectionService {
ISection is=new SectionImpl();
    @Override
    public boolean addSection(Section s) {
        return is.addSection(s);
    }

    @Override
    public boolean deleteSection(Section s) {
       return is.deleteSection(s);
    }

    @Override
    public boolean updateSection(Section s) {
        return is.updateSection(s);
    }

    @Override
    public Section selectSection(Section s) {
        return is.selectSection(s);
    }

    @Override
    public List<Section> selectListSection() {
        return is.selectListSection();
    }
    
}
