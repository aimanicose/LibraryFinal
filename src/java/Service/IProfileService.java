/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Models.Profile;
import java.util.List;

/**
 *
 * @author YS
 */
public interface IProfileService {
    
    boolean addProfil(Profile p);
    
    boolean deleteProfil(Profile p);
    
    boolean updateProfil(Profile p);
    
    Profile selectProfil(Profile p);
    
    List<Profile> selectListProfil();
}
