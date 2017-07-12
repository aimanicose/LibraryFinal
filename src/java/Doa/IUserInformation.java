/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;

import Models.UserInformation;
import java.util.List;

/**
 *
 * @author YS
 */
public interface IUserInformation {
    boolean addUserInformation(UserInformation ui);
    boolean deleteUserInformation(UserInformation ui);
    boolean updateUserInformation(UserInformation ui);
    List<UserInformation> selectUserInformation();
    UserInformation selectUserInformation(UserInformation ui);
}
