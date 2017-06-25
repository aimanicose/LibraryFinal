/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Models.Inventaire;
import java.util.List;

/**
 *
 * @author YS
 */
public interface IInventaireService {
    
    boolean addInventaire(Inventaire i);
    
    List<Inventaire> selectInventaire();
}
