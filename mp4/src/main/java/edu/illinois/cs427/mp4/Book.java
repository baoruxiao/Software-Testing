package edu.illinois.cs427.mp4;
import java.util.*;
/**
 * This class contains the information needed to represent a book.
 */
public final class Book extends Element {
    private String title;
    private String author;
    /**
     * Builds a book with the given title and author.
     *
     * @param title the title of the book
     * @param author the author of the book
     */
    public Book(String title, String author) {
        this.title = title;
	this.author = author;
    }
    /**
     * Builds a book from the string representation, 
     * which contains the title and author of the book. 
     *
     * @param stringRepresentation the string representation
     */
    public Book(String stringRepresentation) {
     	this.title = stringRepresentation.substring(0, stringRepresentation.indexOf(">"));
	this.author = stringRepresentation.substring(stringRepresentation.indexOf(">")+1); 
    }
    /**
     * Returns the string representation of the given book.
     * The representation contains the title and author of the book.
     *
     * @return the string representation
     */
    public String getStringRepresentation() {
        return (this.title + ">" + this.author);
    }
    /**
     * Returns all the collections that this book belongs to directly and indirectly.
     * Consider the following. 
     * (1) Computer Science is a collection. 
     * (2) Operating Systems is a collection under Computer Science. 
     * (3) The Linux Kernel is a book under Operating System collection. 
     * Then, getContainingCollections method for The Linux Kernel should return a list 
     * of these two collections (Operating Systems, Computer Science), starting from 
     * the direct collection to more indirect collections.
     *
     * @return the list of collections
     */
    public List<Collection> getContainingCollections() {
	List<Collection> list = new ArrayList<Collection>();
	Collection parent = this.getParentCollection();
	list.add(parent);
	if(parent.getParentCollection() != null){
		list.add(parent);
		list = getParentsParents(parent, list);
	}

    return list;
    }
    
    private static List<Collection> getParentsParents(Collection parent, List<Collection> list) {
    	Collection gp = parent.getParentCollection();
    	if(gp!=null){
    		list.add(gp);
    		list = (getParentsParents(gp, list));
    	}
    	return list;
    }
    /**
     * Returns the title of the book.
     *
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }
    /**
     * Returns the author of the book.
     *
     * @return the author
     */
    public String getAuthor() {
        return this.author;
    }
}
