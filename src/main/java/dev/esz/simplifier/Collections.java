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
 * // suppose this array contains "my ", "name ", "is ", "x"
 * 
 * myIterator.out(list);
 * // this will output "my name is x"
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
public class Collections<T> {

    public Collections() {}

    /**
     * <p>
     * A method that prints a whole Collection
     * through an {@link Iterator}.
     * 
     * @param collection A generic type collection
     * 
     * @since 1.0.0
     */
    public void out(Collection<T> collection) {
        Iterator<T> it = collection.iterator();

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
     * @param collection A generic type collection
     * @param printLine A boolean to indicate whether the method should or not
     *                  print a new line for each Collection item
     * 
     * @since 1.0.0
     */
    public void out(Collection<T> collection, boolean printLine) {
        Iterator<T> it = collection.iterator();

        while (it.hasNext()) {
            System.out.print(it.next());

            if (printLine) {
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
     * @param collection A generic type collection
     * @param prefix A String that acts as a prefix for all the Collection
     *               items
     * @param suffix A String that acts as a suffix for all the Collection
     *               items
     * 
     * @since 1.0.0
     */
    public void out(Collection<T> collection, String prefix, String suffix) {
        Iterator<T> it = collection.iterator();

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
     * @param collection A generic type collection
     * @param prefix A String that acts as a prefix for all the Collection
     *               items
     * @param suffix A String that acts as a suffix for all the Collection
     *               items
     * @param printLine A boolean to indicate whether the method should or not
     *                  print a new line for each Collection item
     * 
     * @since 1.0.0
     */
    public void out(Collection<T> collection, String prefix, String suffix, boolean printLine) {
        Iterator<T> it = collection.iterator();

        while (it.hasNext()) {
            System.out.print(prefix + it.next() + suffix);

            if (printLine) {
                System.out.print("\n");
            }
        }
    }

    /**
     * A method that receives a collection and set the collection items with the
     * declared prefix for all items.
     * 
     * @param collection A generic type collection
     * @param prefix A String that acts as a prefix for all the Collection
     *               items
     * @return A String collection with all the items concatenated with the prefix.
     */
    public Collection<String> set(Collection<T> collection, String prefix) {
        Iterator<T> it = collection.iterator();
        Collection<String> getCol = new ArrayList<>();

        while (it.hasNext()) {
            getCol.add(prefix + it.next());
        }

        return getCol;
    }

    /**
     * A method that receives a collection and set the collection items with the
     * declared prefix and suffix for all items.
     * 
     * @param collection A generic type collection
     * @param prefix A String that acts as a prefix for all the Collection
     *               items
     * @param suffix A String that acts as a suffix for all the Collection
     *               items
     *
     * @return A String collection with all the items concatenated with the prefix and suffix.
     */
    public Collection<String> set(Collection<T> collection, String prefix, String suffix) {
        Iterator<T> it = collection.iterator();
        Collection<String> getCol = new ArrayList<>();

        while (it.hasNext()) {
            getCol.add(prefix + it.next() + suffix);
        }

        return getCol;
    }
}