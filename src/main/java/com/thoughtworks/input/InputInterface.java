package com.thoughtworks.input;

import com.thoughtworks.model.Snapshot;
import java.util.HashMap;

/**
 * Created by peter on 2016/9/20 0020.
 */
public interface InputInterface {
    /**
     * handle input string,throw exception when exception happend
     * @param input String
     * @return HashMap<String,Snapshot>
     */
    public HashMap<String,Snapshot> handleInputString(String input);
}
