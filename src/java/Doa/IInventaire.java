/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;

import Models.Inventaire;
import java.util.List;

/**
 *
 * @author YS
 */
public interface IInventaire {
    boolean addInventaire(Inventaire i);
    
    List<Inventaire> selectInventaire();
}
