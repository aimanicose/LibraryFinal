/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Doa.IProfile;
import Doa.ProfileImpl;
import Models.Profile;
import java.util.List;

/**
 *
 * @author YS
 */
public class ProfileServiceImpl implements IProfileService {
IProfile ip=new ProfileImpl();
    @Override
    public boolean addProfil(Profile p) {
        return ip.addProfil(p);
    }

    @Override
    public boolean deleteProfil(Profile p) {
        return ip.deleteProfil(p);
    }

    @Override
    public boolean updateProfil(Profile p) {
       return ip.updateProfil(p);
    }

    @Override
    public Profile selectProfil(Profile p) {
        return ip.selectProfil(p);
    }

    @Override
    public List<Profile> selectListProfil() {
        return ip.selectListProfil();
    }
    
}
