package dev.esz.simplifier;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * <p>
 * A Java class to iterate through any kind of {@link Collection}
 * with any data type and print their values, with the possibility to
 * add a prefix and a suffix, as well as print the information on a single line
 * or in different lines.
 *
 * </p>
 *
 * <p>
 * Ex:
 * </p>
 *
 * <blockquote>
 * 
 * <pre>
 * 
 * Collections myIterator = new Collections();
 * ArrayList<String> list = new ArrayList<String>();
 * // supose this array contains "my", "name", "is", "x"
 * 
 * myIterator.out(list);
 * // this will output "mynameisx"
 * 
 * </pre>
 * 
 * </blockquote>
 * 
 * @see java.util.Collection
 * @see java.util.Iterator
 * @see dev.esz.simplifier.Collections
 * 
 * @author EduardoStarZ
 * @since 1.0.0
 */
public class Collections {

    public Collections() {
    }

    /**
     * <p>
     * A method that prints a whole Collection
     * through an {@link Iterator}.
     * 
     * @param collection
     * 
     * @since 1.0.0
     */
    public void out(Collection collection) {
        Iterator it = collection.iterator();

        while (it.hasNext()) {
            System.out.print(it.next());
        }
    }

    /**
     * <p>
     * A method that prints a whole Collection
     * through an {@link Iterator}, allowing to print each
     * element of the collection on different lines.
     * 
     * @param collection
     * @param printLine
     * 
     * @since 1.0.0
     */
    public void out(Collection collection, boolean printLine) {
        Iterator it = collection.iterator();

        while (it.hasNext()) {
            System.out.print(it.next());

            if (printLine == true) {
                System.out.print("\n");
            }
        }
    }

    /**
     * <p>
     * A method that prints a whole Collection
     * through an {@link Iterator}, allowing to set a prefix and a
     * suffix of type string to the print statement.
     * 
     * @param collection
     * @param prefix
     * @param suffix
     * 
     * @since 1.0.0
     */
    public void out(Collection collection, String prefix, String suffix) {
        Iterator it = collection.iterator();

        while (it.hasNext()) {
            System.out.print(prefix + it.next() + suffix);
        }
    }

    /**
     * <p>
     * A method that prints a whole Collection
     * through an {@link Iterator}, allowing to set a prefix and a
     * suffix of type string to the print statement and allowing to print each
     * element of the collection on different lines.
     * 
     * @param collection
     * @param prefix
     * @param suffix
     * @param printLine
     * 
     * @since 1.0.0
     */
    public void out(Collection collection, String prefix, String suffix, boolean printLine) {
        Iterator it = collection.iterator();

        while (it.hasNext()) {
            System.out.print(prefix + "" + it.next() + "" + suffix);

            if (printLine == true) {
                System.out.print("\n");
            }
        }
    }

    /**
     * A method that receives a collection and set the collection items with the
     * declared prefix for all items.
     * 
     * @param collection
     * @param prefix
     * @return The collection with all the items concatenated with the prefix.
     */
    public Collection set(Collection collection, String prefix) {
        Iterator it = collection.iterator();
        ArrayList getCol = new ArrayList<>();

        while (it.hasNext()) {
            getCol.add(prefix + it.next());
        }

        collection.clear();

        collection.addAll(getCol);

        return collection;
    }

    /**
     * A method that receives a collection and set the collection items with the
     * declared prefix and suffix for all items.
     * 
     * @param collection
     * @param prefix
     * @param suffix
     * @return The collection with all the items concatenated with the prefix and suffix.
     */
    public Collection set(Collection collection, String prefix, String suffix) {
        Iterator it = collection.iterator();
        ArrayList getCol = new ArrayList<>();

        while (it.hasNext()) {
            getCol.add(prefix + it.next() + suffix);
        }

        collection.clear();

        collection.addAll(getCol);

        return collection;
    }
}