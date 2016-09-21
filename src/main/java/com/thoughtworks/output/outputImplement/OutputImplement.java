package com.thoughtworks.output.outputImplement;

import com.thoughtworks.model.AnimalLocation;
import com.thoughtworks.model.Snapshot;
import com.thoughtworks.output.OutputInterface;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by peter on 2016/9/21 0021.
 */
public class OutputImplement implements OutputInterface {
    /**
     * find result from data map
     *
     * @param dataMap
     * @param foundId
     * @return
     */
    @Override
    public String handleInputString(HashMap<String, Snapshot> dataMap, String foundId) {
        if (dataMap == null || dataMap.size() == 0) {
            return "empty date in datamap";
        }
        if (!dataMap.containsKey(foundId)) {
            return "there is no history data id "+foundId;
        }
        LinkedList<AnimalLocation> list = dataMap.get(foundId).getLocations();
        StringBuffer stringBuffer = new StringBuffer();
        for (AnimalLocation item : list) {
            stringBuffer.append(item.toString());
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }
}
