/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;

import Models.User;
import java.util.List;

/**
 *
 * @author YS
 */
public interface IUser {
    boolean addUser(User u);
    boolean deleteUser(User u);
    boolean updateUser(User u);
    User selectUser(User u);
    List<User> selectListUser();
    int getUserID(User u);
}
