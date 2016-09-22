package com.thoughtworks.outputTest;

import com.thoughtworks.input.InputInterface;
import com.thoughtworks.model.AnimalLocation;
import com.thoughtworks.model.Snapshot;
import com.thoughtworks.output.OutputInterface;
import com.thoughtworks.output.outputImplement.OutputImplement;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class outputStringTest {
    HashMap<String,Snapshot> dataMap = new HashMap<>();
    OutputInterface output = new OutputImplement();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    //mock dateMap
    @Mock
    InputInterface inputInterface;

    @Before
    public void setUp() throws Exception {
        Snapshot first = new Snapshot("e4e87cb2-8e9a-4749-abb6-26c59344dfee");
        first.setTime(sdf.parse("2016/09/02 22:30:46"));
        AnimalLocation animalLocation1 =new AnimalLocation("cat1 10 9");
        first.getLocations().add(animalLocation1);
        dataMap.put("e4e87cb2-8e9a-4749-abb6-26c59344dfee",first);

        Snapshot second = new Snapshot("351055db-33e6-4f9b-bfe1-16f1ac446ac1");
        second.setTime(sdf.parse("2016/09/02 22:30:52"));
        AnimalLocation animalLocation2 =new AnimalLocation("cat1 12 8");
        AnimalLocation animalLocation3 =new AnimalLocation("cat2 2 3");
        second.getLocations().add(animalLocation2);
        second.getLocations().add(animalLocation3);
        dataMap.put("351055db-33e6-4f9b-bfe1-16f1ac446ac1",second);

        Snapshot third = new Snapshot("dcfa0c7a-5855-4ed2-bc8c-4accae8bd155");
        third.setTime(sdf.parse("2016/09/02 22:31:02"));
        AnimalLocation animalLocation4 =new AnimalLocation("cat1 15 12");
        third.getLocations().add(animalLocation4);
        third.getLocations().add(animalLocation3);
        dataMap.put("dcfa0c7a-5855-4ed2-bc8c-4accae8bd155",third);

        initMocks(this);

        when(inputInterface.handleInputString(null)).thenReturn(dataMap);

    }

    /**
     * test the third snapshot
     */
    @Test
    public void rightExampleThirdOutputTest(){
        String result = output.handleInputString(dataMap,"dcfa0c7a-5855-4ed2-bc8c-4accae8bd155");
        assertEquals(result,"cat1 15 12\ncat2 2 3\n");
    }

    /**
     * test the second snapshot
     */
    @Test
    public void rightExampleOutputTestSecond(){
        String result = output.handleInputString(dataMap,"351055db-33e6-4f9b-bfe1-16f1ac446ac1");
        assertEquals(result,"cat1 12 8\ncat2 2 3\n");
    }

    /**
     * test the first snapshot
     */
    @Test
    public void rightExampleOutputTestFirst(){
        String result = output.handleInputString(dataMap,"e4e87cb2-8e9a-4749-abb6-26c59344dfee");
        assertEquals(result,"cat1 10 9\n");
    }
    /**
     * test empty input map
     */
    @Test
    public void emptyInputMapTest(){
        HashMap<String,Snapshot> dataMap =null;
        String result = output.handleInputString(dataMap,null);
        assertEquals(result,"empty date in datamap");
    }

    /**
     * test null id
     */
    @Test
    public void nullIdTest(){
        String result = output.handleInputString(dataMap,null);
        assertEquals(result,"there is no history data id null");
    }
    /**
     * test wrong id
     */
    @Test
    public void wrongIdTest(){
        String result = output.handleInputString(dataMap,"1");
        assertEquals(result,"there is no history data id 1");
    }

}
