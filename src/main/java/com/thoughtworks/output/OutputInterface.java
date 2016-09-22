package com.thoughtworks.output;

import com.thoughtworks.model.Snapshot;
import java.util.HashMap;

public interface OutputInterface {
    /**
     * find result from data map
     * @param dataMap
     * @param foundId
     * @return
     */
    public String handleInputString(HashMap<String,Snapshot> dataMap,String foundId);
}
