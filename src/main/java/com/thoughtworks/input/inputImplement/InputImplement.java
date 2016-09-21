package com.thoughtworks.input.inputImplement;

import com.thoughtworks.input.InputInterface;
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
     * handle input string,throw exception when exception happend
     *
     * @param input String
     * @return HashMap<String,Snapshot>
     */
    @Override
    public HashMap<String, Snapshot> handleInputString(String input) {
        HashMap<String, Snapshot> dateMap = new HashMap<>();
        HashMap<String, AnimalLocation> animalMap = new HashMap<>();
        try {
            String lines[] = input.split("\n");
            for (int i = 0; i < lines.length; i++) {
                while (i < lines.length && lines[i].trim() != "") {
                    Snapshot snapshot = new Snapshot(lines[i++]);
                    try {
                        snapshot.setTime(new Date(lines[i++]));
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException("Invalid format.");
                    }
                    while (i < lines.length && lines[i].trim() != "") {
                        AnimalLocation animal = new AnimalLocation(lines[i]);
                        if (animalMap.containsKey(animal.getName())) {
                            animal.updateLocation(animalMap.get(animal.getName()).getLocation(), lines[i], snapshot.getId());
                            animalMap.put(animal.getName(), animal);
                            snapshot.getLocations().add(animal);
                        } else {
                            snapshot.getLocations().add(animal);
                            animalMap.put(animal.getName(), animal);
                        }
                        dateMap.put(snapshot.getId(), snapshot);
                        i++;
                        if (i < lines.length && !lines[i].contains(" ")) {
                            break;
                        }
                    }
                }
            }
            return dateMap;
        } catch (Exception e) {
            String[] errors = e.getMessage().split(" ");
            if (!errors[0].equals("Conflict")) {
                throw new IllegalArgumentException("Invalid format.");
            } else {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }
}