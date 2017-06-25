/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Doa.IInventaire;
import Doa.InventaireImpl;
import Models.Inventaire;
import java.util.List;



/**
 *
 * @author YS
 */
public class InventaireServiceImpl implements IInventaireService {
IInventaire ii=new InventaireImpl();
    @Override
    public boolean addInventaire(Inventaire i) {
        return ii.addInventaire(i);
    }

    @Override
    public List<Inventaire> selectInventaire() {
         return ii.selectInventaire();
    }

}
