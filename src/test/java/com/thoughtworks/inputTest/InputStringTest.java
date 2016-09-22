package com.thoughtworks.inputTest;

import com.thoughtworks.input.InputInterface;
import com.thoughtworks.input.inputImplement.InputImplement;
import com.thoughtworks.model.Snapshot;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by peter on 2016/9/20 0020.
 */
public class InputStringTest {
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    /**
     * test example input
     */
    @Test
    public void rightInputTestWithThreeSnapshot(){
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
        InputInterface inputInterface = new InputImplement();
        HashMap<String,Snapshot> result = inputInterface.handleInputString(data);
        assertThat(result, is(notNullValue()));
    }

    /**
     * test right two snapshot
     */
    @Test
    public void rightInputTestWithTwoSnapshot(){
        String data = "e4e87cb2-8e9a-4749-abb6-26c59344dfee\n" +
                "2016/09/02 22:30:46\n" +
                "cat1 10 9\n" +
                "351055db-33e6-4f9b-bfe1-16f1ac446ac1\n" +
                "2016/09/02 22:30:52\n" +
                "cat1 10 9 2 -1\n" +
                "cat2 2 3\n";
        InputInterface inputInterface = new InputImplement();
        HashMap<String,Snapshot> result = inputInterface.handleInputString(data);
        assertThat(result, is(notNullValue()));
    }

    /**
     * test right fout snapshot
     */
    @Test
    public void rightInputTestWithfourSnapshot(){
        String data = "e4e87cb2-8e9a-4749-abb6-26c59344dfee\n" +
                "2016/09/02 22:30:46\n" +
                "cat1 10 9\n" +
                "351055db-33e6-4f9b-bfe1-16f1ac446ac1\n" +
                "2016/09/02 22:30:52\n" +
                "cat1 10 9 2 -1\n" +
                "cat2 2 3\n"+
                "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155\n" +
                "2016/09/02 22:31:02\n" +
                "cat1 12 8 3 4\n"+
                "351055db-33e7-4f9b-bfe1-16f1ac446ac1\n" +
                "2016/09/02 22:32:59\n" +
                "cat1 15 12 2 -1\n";
        InputInterface inputInterface = new InputImplement();
        HashMap<String,Snapshot> result = inputInterface.handleInputString(data);
        assertThat(result, is(notNullValue()));
    }
    /**
     * test wrong example input with Invalid format.expected exception is IllegalArgumentException
     */
    @Test
    public void wrongInputTestWithBadTimeFormat(){
        String data = "e4e87cb2-8e9a-4749-abb6-26c59344dfee\n" +
                "2016/09/0222 22:30:46\n" +
                "cat1 10 9\n" +
                "351055db-33e6-4f9b-bfe1-16f1ac446ac1\n" +
                "2016/09/02 22:30:52\n" +
                "cat1 10 9 2 -1\n" +
                "cat2 2 3\n" +
                "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155\n" +
                "2016/09/02 22:31:02\n" +
                "cat1 12 8 3 4";
        try {
            InputInterface inputInterface = new InputImplement();
            inputInterface.handleInputString(data);
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), containsString("Invalid format."));
        }
    }
    /**
     * test wrong example input with Invalid format.expected exception is IllegalArgumentException
     */
    @Test
    public void wrongInputTestWithTwoNewline(){
        String data = "e4e87cb2-8e9a-4749-abb6-26c59344dfee\n\n" +
                "2016/09/0222 22:30:46\n" +
                "cat1 10 9\n" +
                "351055db-33e6-4f9b-bfe1-16f1ac446ac1\n" +
                "2016/09/02 22:30:52\n" +
                "cat1 10 9 2 -1\n" +
                "cat2 2 3\n" +
                "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155\n" +
                "2016/09/02 22:31:02\n" +
                "cat1 12 8 3 4";
        try {
            InputInterface inputInterface = new InputImplement();
            inputInterface.handleInputString(data);
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), containsString("Invalid format."));
        }
    }
    /**
     * test wrong example input with Bad Data
     */
    @Test
    public void wrongInputTestWithBadData(){
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
        try {
            InputInterface inputInterface = new InputImplement();
            inputInterface.handleInputString(data);
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), containsString("Conflict found at dcfa0c7a-5855-4ed2-bc8c-4accae8bd155"));
        }
    }
    /**
     * test wrong example input with empty input
     */
    @Test
    public void wrongInputTestWithEmptyInput(){
        String data="";
        InputInterface inputInterface = new InputImplement();
        HashMap<String,Snapshot> result = inputInterface.handleInputString(data);
        assertThat(result, is(nullValue()));
    }
}
