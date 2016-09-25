package edu.illinois.cs427.mp4;
import java.util.*;
/**
 * Represents a collection of books or (sub)collections.
 */
public final class Collection extends Element {
    List<Element> elements;
    private String name;
    
    /**
     * Creates a new collection with the given name.
     *
     * @param name the name of the collection
     */
    public Collection(String name) {
        this.name = name;
	this.elements = new ArrayList<Element>();
    }
    // constructor that also takes elements list
    private Collection(String name, List<Element> elements)
    {
	this.name = name;
	this.elements = elements;
    }
    /**
     * Restores a collection from its given string representation.
     *
     * @param stringRepresentation the string representation
     */
    public static Collection restoreCollection(String stringRepresentation) {
	String s = stringRepresentation;
	String name = s.substring(0, s.indexOf(">"));
	s = s.substring(s.indexOf(">")+1);
	Collection coll = new Collection(name);
	List<Element> elements = getElementsFromString(s);
	for(Element a : elements)
	{
		coll.addElement(a);
	}
	return coll;
    }
    // Helper function for Restore Collection
    private static List<Element> getElementsFromString(String in) {
	List<Element> elements = new ArrayList<Element>();
	while(in.length()>0)
	{
		in = in.substring(1);
		if(in.substring(0,1).equals("~"))
		{
			elements.add(new Book(in.substring(1, in.indexOf("`"))));
		}
		else
		{
			elements.add(Collection.restoreCollection(in.substring(1, in.indexOf("'"))));
		}
		if(in.indexOf("`") == -1)
			return elements;
		in = in.substring(in.indexOf("`"));
	}
	return elements;
    }
    /**
     * Returns the string representation of a collection. 
     * The string representation should have the name of this collection, 
     * and all elements (books/subcollections) contained in this collection.
     *
     * @return string representation of this collection
     */
    public String getStringRepresentation() {
        String representation = this.name+">";
	for(Element a : this.elements){
		if(a instanceof Book) {
			Book temp = (Book)a;
			representation+=("`~"+(temp.getTitle()));
		}
		else if(a instanceof Collection) {
			Collection temp = (Collection)a;
			representation+=("`|"+(temp.getName()));
		}
	}
        return representation;
    }
    /**
     * Returns the name of the collection.
     *
     * @return the name
     */
    public String getName() { 
        return this.name;
    }
    
    /**
     * Adds an element to the collection.
     * If parentCollection of given element is not null,
     * do not actually add, but just return false.
     * (explanation: if given element is already a part of  
     * another collection, you should have deleted the element 
     * from that collection before adding to another collection)
     *
     * @param element the element to add
     * @return true on success, false on fail
     */
    public boolean addElement(Element element) { 
        if(element.getParentCollection()!=null)
		return false;
	element.setParentCollection(this);
	elements.add(element);
	return true;
    }
    
    /**
     * Deletes an element from the collection.
     * Returns false if the collection does not have 
     * this element.
     * Hint: Do not forget to clear parentCollection
     * of given element 
     *
     * @param element the element to remove
     * @return true on success, false on fail
     */
    public boolean deleteElement(Element element) {
        int index = elements.indexOf(element);
	if(index == -1)
		return false;
	elements.remove(index);
	Collection parent = element.getParentCollection();
	if(parent != null)
	{
		parent.deleteElement(element);
	}
        return true;
    }
    
    /**
     * Returns the list of elements.
     * 
     * @return the list of elements
     */
    public List<Element> getElements() { 
        return elements;
    }
}
