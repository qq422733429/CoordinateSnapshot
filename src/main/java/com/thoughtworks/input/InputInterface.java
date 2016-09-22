package com.thoughtworks.input;

import com.thoughtworks.model.Snapshot;
import java.util.HashMap;

public interface InputInterface {
    /**
     * handle input string,throw exception when exception happend
     * @param input String
     * @return HashMap<String,Snapshot>
     */
    public HashMap<String,Snapshot> handleInputString(String input);
}
