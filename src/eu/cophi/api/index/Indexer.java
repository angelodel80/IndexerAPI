/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cophi.api.index;

import eu.cophi.model.api.Document;
import eu.cophi.modules.index.builtin.CophiIndexer;
import java.io.File;
import java.util.Map;

/**
 *
 * @author Angelo Del Grosso
 */
final public class Indexer {

    private Iindex impl = null;
    
    private Indexer() {
        this(new CophiIndexer());
    }

    private Indexer(Iindex idxProvider){
        impl = idxProvider;
    }
    
    public static Indexer createIndexer(){
        return new Indexer();
    }
    
    public void add(Document cophiDoc){
        impl.initialize(cophiDoc);
    }
    
    public void index(){
        impl.index();
    }
    
    public Index getTokenIdx(){
        return impl.getIdx();
    }
    
    abstract public static class Index {

        abstract public Map<String, Integer> getIndex();
        abstract public void setIndex(Map<String,Integer> mapIdx);
        
    }
    
    public interface Iindex{
        public void initialize(Document cophiDoc);
        public void index();
        public Index getIdx();
    }

}
