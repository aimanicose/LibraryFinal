/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Doa.IUser;
import Doa.IUserInformation;
import Doa.UserImpl;
import Doa.UserInformationImpl;
import Models.User;
import java.util.List;

/**
 *
 * @author YS
 */
public class UserServiceImpl implements IUserService {
IUser iu=new UserImpl();
IUserInformation iui=new UserInformationImpl();

    @Override
    public boolean addUser(User u) {
       boolean bool=iu.addUser(u);
       iui.addUserInformation(u.getUserInformation());
       return bool;
    }

    @Override
    public boolean deleteUser(User u) {
        return iu.deleteUser(u);
    }

    @Override
    public boolean updateUser(User u) {
       boolean bool=iu.updateUser(u);
       iui.updateUserInformation(u.getUserInformation());
       return bool;
    }

    @Override
    public User selectUser(User u) {
        return iu.selectUser(u);
    }

    @Override
    public List<User> selectListUser() {
        return iu.selectListUser();
    }
    
}
