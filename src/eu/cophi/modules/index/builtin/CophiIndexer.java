/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eu.cophi.modules.index.builtin;

import eu.cophi.api.index.Indexer;
import eu.cophi.model.api.Document;
import java.util.Map;

/**
 *
 * @author Angelo Del Grosso
 */
public class CophiIndexer implements Indexer.Iindex {
    Document doc;
    Indexer.Index idx;
    
    @Override
    public void initialize(Document cophiDoc) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        doc = cophiDoc;
        idx = new IndexImpl();
    }

    @Override
    public void index() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        idx.setIndex(IdxFunction.index(doc.getTokens()));
    }

    @Override
    public Indexer.Index getIdx() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return idx;
    }
    
    private static class IndexImpl extends Indexer.Index{
        Map<String, Integer> idx;
        
        @Override
        public Map<String, Integer> getIndex() {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return idx;
        }

        @Override
        public void setIndex(Map<String, Integer> mapIdx) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            idx = mapIdx;
        }
        
    }
    
}
