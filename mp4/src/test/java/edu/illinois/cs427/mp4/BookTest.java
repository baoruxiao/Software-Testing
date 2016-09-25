package edu.illinois.cs427.mp4;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import java.lang.*;

public class BookTest {

	@Test
    public void testBookConstructor1() {
        //TODO implement this
        Book book1 = new Book("Computer Vision", "David Forsyth");
        assertTrue(book1 instanceof Book);
    }

    @Test
    public void testGetStringRepresentation1() {
        //TODO implement this
        Book book1 = new Book("Computer Vision", "David Forsyth");
        String temp =  book1.getStringRepresentation();
        assertEquals("Computer Vision>David Forsyth", temp);
    }

    @Test
    public void testGetContainingCollections1() {
        //TODO implement this
        Book book1 = new Book("Computer Vision", "David Forsyth");
        Collection collection1 = new Collection("Computer Science");
        book1.setParentCollection(collection1);
        List<Collection> list1 = book1.getContainingCollections();
        Collection parent = list1.get(0); 
       	assertEquals(parent.getStringRepresentation(), "Computer Science>");
    }
}
