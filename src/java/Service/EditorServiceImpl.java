/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Doa.EditorImpl;
import Doa.IEditor;
import Models.Editor;
import java.util.List;

/**
 *
 * @author YS
 */
public class EditorServiceImpl implements IEditorService {
IEditor ie = new EditorImpl();

    @Override
    public boolean addEditor(Editor e) {
       return ie.addEditor(e);
    }

    @Override
    public boolean deleteEditor(Editor e) {
        return ie.deleteEditor(e);
    }

    @Override
    public boolean updateEditor(Editor e) {
        return ie.updateEditor(e);
    }

    @Override
    public Editor selectEditor(Editor e) {
        return ie.selectEditor(e);
    }

    @Override
    public List<Editor> selectListEditor() {
        return ie.selectListEditor();
    }
    
}
