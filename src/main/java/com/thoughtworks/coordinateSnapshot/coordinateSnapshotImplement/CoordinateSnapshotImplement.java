package com.thoughtworks.coordinateSnapshot.coordinateSnapshotImplement;

import com.thoughtworks.coordinateSnapshot.CoordinateSnapshot;
import com.thoughtworks.input.InputInterface;
import com.thoughtworks.input.inputImplement.InputImplement;
import com.thoughtworks.model.Snapshot;
import com.thoughtworks.output.OutputInterface;
import com.thoughtworks.output.outputImplement.OutputImplement;

import java.util.HashMap;

/**
 * Created by peter on 2016/9/22 0022.
 */
public class CoordinateSnapshotImplement implements CoordinateSnapshot {

    /**
     * get snapshot string according to history data and id
     *
     * @param historyData
     * @param id
     * @return String
     */
    @Override
    public String getSnapShot(String historyData, String id) {
        String result;
        try {
            InputInterface inputInterface = new InputImplement();
            HashMap<String, Snapshot> dateMap = inputInterface.handleInputString(historyData);
            OutputInterface outputInterface = new OutputImplement();
            result = outputInterface.handleInputString(dateMap, id);
        } catch (Exception e) {
            result=e.getMessage();
        }
       return result;
    }
}
