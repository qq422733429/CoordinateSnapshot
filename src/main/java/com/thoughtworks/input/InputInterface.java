package com.thoughtworks.input;

import com.thoughtworks.model.Snapshot;
import java.util.HashMap;

/**
 * Created by peter on 2016/9/20 0020.
 */
public interface InputInterface {
    /**
     * 将输入的字符串进行处理，如果有内容错误或者格式错误直接抛出异常
     * @param input String
     * @return HashMap<String,Snapshot>
     */
    public HashMap<String,Snapshot> handleInputString(String input);
}
