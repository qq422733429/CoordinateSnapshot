package com.thoughtworks.input.inputImplement;

import com.thoughtworks.input.InputInterface;
import com.thoughtworks.model.AnimalLocation;
import com.thoughtworks.model.Snapshot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class InputImplement implements InputInterface {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    /**
     * handle input string,throw exception when exception happend
     *
     * @param input String
     * @return HashMap<String,Snapshot>
     */
    @Override
    public HashMap<String, Snapshot> handleInputString(String input) {
        if (input.equals("")) {
            return null;
        }
        HashMap<String, Snapshot> dateMap = new HashMap<>();
        LinkedHashMap<String, AnimalLocation> animalMap = new LinkedHashMap<>();
        try {
            loadAllInformation(input, dateMap, animalMap);
            return dateMap;
        } catch (Exception e) {
            return handleException(e);
        }
    }

    private void loadAllInformation(String input, HashMap<String, Snapshot> dateMap, LinkedHashMap<String, AnimalLocation> animalMap) {
        int i = 0;
        String lines[] = input.split("\n");
        while (i < lines.length && lines[i].trim() != "") {
            i = loadEachSnapshot(dateMap, animalMap, i, lines);
        }
    }


    private int loadEachSnapshot(HashMap<String, Snapshot> dateMap, LinkedHashMap<String, AnimalLocation> animalMap, int i, String[] lines) {
        Snapshot snapshot = new Snapshot(lines[i++]);
        snapshot.setTime(checkDateStyle(lines[i++]));
        while (i < lines.length && lines[i].trim() != "") {
            loadEachAnimalLocation(animalMap, lines[i], snapshot);
            dateMap.put(snapshot.getId(), snapshot);
            i++;
            if (i < lines.length && !lines[i].contains(" ")) {
                break;
            }
        }
        return i;
    }

    private Date checkDateStyle(String line) {
        Date date = null;
        try {
            date = sdf.parse(line);
        } catch (ParseException e) {
            throw new IllegalArgumentException();
        }
        return date;
    }

    private void loadEachAnimalLocation(LinkedHashMap<String, AnimalLocation> animalMap, String line, Snapshot snapshot) {
        AnimalLocation animal = new AnimalLocation(line);
        if (animalMap.containsKey(animal.getName())) {
            animal.updateLocation(animalMap.get(animal.getName()).getLocation(), line, snapshot.getId());
            animalMap.put(animal.getName(), animal);
        } else {
            animalMap.put(animal.getName(), animal);
        }
        snapshot.getLocations().clear();
        for (AnimalLocation item : animalMap.values()) {
            snapshot.getLocations().add(item);
        }
    }

    private HashMap<String, Snapshot> handleException(Exception e) {
        if (e.getMessage()==null) {
            throw new IllegalArgumentException("Invalid format.");
        }
        String[] errors = e.getMessage().split(" ");
        if (!errors[0].equals("Conflict")) {
            throw new IllegalArgumentException("Invalid format.");
        } else {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
