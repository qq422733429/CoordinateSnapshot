package com.thoughtworks.input;

import com.thoughtworks.model.AnimalLocation;
import com.thoughtworks.model.Snapshot;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by peter on 2016/9/20 0020.
 */
public class InputImplement implements InputInterface {



    /**
     * 将输入的字符串进行处理，如果有内容错误或者格式错误直接抛出异常
     *
     * @param input String
     * @return HashMap<String,Snapshot>
     */
    @Override
    public HashMap<String, Snapshot> handleInputString(String input) {
        HashMap<String,Snapshot> dateMap = new HashMap<>();
        HashMap<String,AnimalLocation> animalMap=new HashMap<>();
        String lines[] = input.split("\n");
        for (int i = 0; i < lines.length; i++) {
            while (i<lines.length&&lines[i].trim()!=""){
                Snapshot snapshot = new Snapshot();
                snapshot.setLocations(new LinkedList<AnimalLocation>());
                snapshot.setId(lines[i++]);
                snapshot.setTime(new Date(lines[i++]));
                while (i<lines.length&&lines[i].trim() != "") {
                    AnimalLocation animal = new AnimalLocation(lines[i]);
                    if (animalMap.containsKey(animal.getName())) {
                        animal.updateLocation(animalMap.get(animal.getName()).getLocation(),lines[i]);
                        animalMap.put(animal.getName(),animal);
                        snapshot.getLocations().add(animal);
                    } else {
                        snapshot.getLocations().add(animal);
                        animalMap.put(animal.getName(), animal);
                    }
                    dateMap.put(snapshot.getId(), snapshot);
                    i++;
                    if (i<lines.length&&!lines[i].contains(" ")) {
                        break;
                    }
                }
            }
        }

        return dateMap;
    }
}
