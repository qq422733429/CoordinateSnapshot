package com.thoughtworks;

import com.thoughtworks.coordinateSnapshot.CoordinateSnapshot;
import com.thoughtworks.coordinateSnapshot.coordinateSnapshotImplement.CoordinateSnapshotImplement;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateSnapshotTest {

    CoordinateSnapshot coordinateSnapshot = new CoordinateSnapshotImplement();

    @Test
    public void rightExampleTest() {
        String data = "e4e87cb2-8e9a-4749-abb6-26c59344dfee\n" +
                "2016/09/02 22:30:46\n" +
                "cat1 10 9\n" +
                "351055db-33e6-4f9b-bfe1-16f1ac446ac1\n" +
                "2016/09/02 22:30:52\n" +
                "cat1 10 9 2 -1\n" +
                "cat2 2 3\n" +
                "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155\n" +
                "2016/09/02 22:31:02\n" +
                "cat1 12 8 3 4";
        String id = "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155";
        String result = coordinateSnapshot.getSnapShot(data,id);
        assertEquals(result,"cat1 15 12\ncat2 2 3\n");
    }
    @Test
    public void wrongInvalidFormatExampleTest() {
        String data = "e4e87cb2-8e9a-4749-abb6-26c59344dfee\n" +
                "2016-9-33 22:30:46\n" +
                "cat1 10 9\n" +
                "351055db-33e6-4f9b-bfe1-16f1ac446ac1\n" +
                "2016/09/02 22:30:52\n" +
                "cat1 10 9 2 -1\n" +
                "cat2 2 3\n" +
                "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155\n" +
                "2016/09/02 22:31:02\n" +
                "cat1 12 8 3 4";
        String id = "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155";
        String result = coordinateSnapshot.getSnapShot(data,id);
        System.out.println(result);
        assertEquals(result,"Invalid format.");
    }
    @Test
    public void wrongConflictExampleTest() {
        String data = "e4e87cb2-8e9a-4749-abb6-26c59344dfee\n" +
                "2016/09/02 22:30:46\n" +
                "cat1 10 9\n" +
                "351055db-33e6-4f9b-bfe1-16f1ac446ac1\n" +
                "2016/09/02 22:30:52\n" +
                "cat1 10 9 2 -1\n" +
                "cat2 2 3\n" +
                "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155\n" +
                "2016/09/02 22:31:02\n" +
                "cat1 11 8 3 4";
        String id = "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155";
        String result = coordinateSnapshot.getSnapShot(data,id);
        assertEquals(result,"Conflict found at dcfa0c7a-5855-4ed2-bc8c-4accae8bd155");
    }
}
