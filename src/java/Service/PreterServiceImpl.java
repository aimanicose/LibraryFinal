/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Doa.IPreter;
import Doa.PreterImpl;
import Models.Preter;
import java.util.List;

/**
 *
 * @author YS
 */
public class PreterServiceImpl implements IPreterService {
IPreter ip=new PreterImpl();
    @Override
    public boolean addPreter(Preter p) {
        return ip.addPreter(p);
    }

    @Override
    public boolean deletePreter(Preter p) {
        return ip.deletePreter(p);
    }

    @Override
    public boolean updatePreter(Preter p) {
        return ip.updatePreter(p);
    }

    @Override
    public List<Preter> selectPreter() {
       return ip.selectPreter();
    }

    @Override
    public List<Preter> latebookslist() {
        return ip.latebookslist();
    }
    
}
