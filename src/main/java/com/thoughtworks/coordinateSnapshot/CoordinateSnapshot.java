package com.thoughtworks.coordinateSnapshot;

/**
 * Created by peter on 2016/9/22 0022.
 */
public interface CoordinateSnapshot {
    /**
     * get snapshot string according to history data and id
     * @param historyData
     * @param id
     * @return String
     */
    public String getSnapShot(String historyData, String id);
}
