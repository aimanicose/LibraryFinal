/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;

import Models.Editor;
import java.util.List;

/**
 *
 * @author YS
 */
public interface IEditor {
     boolean addEditor(Editor e);
    boolean deleteEditor(Editor e);
    boolean updateEditor(Editor e);
    Editor selectEditor(Editor e);
    List<Editor> selectListEditor();
}
