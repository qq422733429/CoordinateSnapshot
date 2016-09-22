package com.thoughtworks.coordinateSnapshot;

public interface CoordinateSnapshot {
    /**
     * get snapshot string according to history data and id
     * @param historyData
     * @param id
     * @return String
     */
    public String getSnapShot(String historyData, String id);
}
