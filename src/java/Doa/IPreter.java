/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;

import Models.Preter;
import java.util.List;

/**
 *
 * @author YS
 */
public interface IPreter {
    boolean addPreter(Preter p);
    boolean deletePreter(Preter p);
    boolean updatePreter(Preter p);
    List<Preter> selectPreter();
}
