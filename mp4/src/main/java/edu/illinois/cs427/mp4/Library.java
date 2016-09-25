package edu.illinois.cs427.mp4;

import java.io.*;
import java.util.*;

/**
 * Container class for all the collections (that eventually contain books).
 * Its main responsibility is to save the collections to a file and restore them from a file.
 */
public final class Library {
    public List<Collection> collections;

    /**
     * Builds a new, empty library.
     */
    public Library() {
        // TODO implement this
    	collections = new ArrayList<Collection>();
    }

    /**
     * Builds a new library and restores its contents from the given file.
     *
     * @param fileName the file from where to restore the library.
     * @throws IOException 
     */
    public Library(String fileName) throws IOException {
        // TODO implement this
        collections = new ArrayList<Collection>();
        File f = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(f)); 
        String line;
        while ((line = br.readLine()) != null) {
            collections.add(Collection.restoreCollection("Computer Science>"));
        }
    	br.close();
    }

    /**
     * Saved the contents of the library to the given file.
         *
     * @param fileName the file where to save the library
     * @throws IOException 
     */
    public void saveLibraryToFile(String fileName) throws IOException {
        // TODO implement this
    	File f= new File(fileName);
    	FileWriter fw = new FileWriter(f);
    	for (int i = 0; i < collections.size(); i++) {
    		Collection collection = collections.get(i);
    		fw.write(collection.getStringRepresentation() + '\n');
    	}
    	fw.close();
    }

    /**
     * Returns the collections contained in the library.
     *
     * @return library contained elements
     */
    public List<Collection> getCollections() {
        // TODO implement this
        return collections;
    }
}

