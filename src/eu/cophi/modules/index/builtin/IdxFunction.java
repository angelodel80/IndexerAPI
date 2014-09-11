/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cophi.modules.index.builtin;

import java.text.Collator;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author Angelo Del Grosso
 */
public class IdxFunction {
    
    public static Map<String, Integer> index(String[] tokens, Locale locale) {
        
        Map<String, Integer> retMap = new TreeMap<String, Integer>(Collator.getInstance(locale));
        
        for (String token : tokens) {
            int frq = 0;
            try {
                frq = retMap.get(token).intValue();
            } catch (NullPointerException npe) {
            } finally {
                retMap.put(token,Integer.valueOf((frq+1)));
            }
        }
        return retMap;
    }
}
