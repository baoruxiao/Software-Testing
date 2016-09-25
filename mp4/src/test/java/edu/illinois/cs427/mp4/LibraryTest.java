package edu.illinois.cs427.mp4;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import java.io.*;
import java.lang.*;

public class LibraryTest {
    @Test
    public void testLibraryConstructorFromFile1() throws IOException {
        //TODO implement this
        Library testLib = new Library("test.txt");
        List<Collection> testCols = testLib.getCollections();
        Collection testCol = testCols.get(0);
        assertEquals(testCol.getStringRepresentation(), "Computer Science>");
    }

    @Test
    public void testSaveLibraryToFile1() throws IOException {
        //TODO implement this
        Library testLib = new Library("test.txt");
        testLib.saveLibraryToFile("text_save.txt");
        Library testLib_save = new Library("text_save.txt");
        List<Collection> testCols = testLib_save.getCollections();
        Collection testCol = testCols.get(0);
        assertEquals(testCol.getStringRepresentation(), "Computer Science>");
    }
}
