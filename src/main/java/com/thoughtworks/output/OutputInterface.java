package com.thoughtworks.output;

import com.thoughtworks.model.Snapshot;
import java.util.HashMap;

/**
 * Created by peter on 2016/9/21 0021.
 */
public interface OutputInterface {
    /**
     * find result from data map
     * @param dataMap
     * @param foundId
     * @return
     */
    public String handleInputString(HashMap<String,Snapshot> dataMap,String foundId);
}
