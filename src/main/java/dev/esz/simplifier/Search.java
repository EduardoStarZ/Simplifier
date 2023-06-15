package dev.esz.simplifier;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

/**
 * 
 * <p>
 * A Java class that can perform a {@link Search} in String data types
 * looking for specific a term in said target using the
 * {@link Matcher} and {@link Pattern} classes, and can distinguish case sensitive
 * terms found from others if defined so.
 * 
 * <p>
 * Then it can:
 * 
 * <ul>
 * 
 * <li>Determine if there's a valid match</li>
 * <li>Find the number of times said match is found on the target</li>
 * </ul>
 * 
 * </p>
 * 
 * <p> To use the class, create a {@link Search} object as the following:
 * 
 * <blockquote>
 * <pre>
 * 
 *  Search mySearch = new Search(myTerm, myTarget);
 * 
 * </pre>
 * </blockquote>
 * 
 * 
 * @see dev.esz.simplifier.Search
 * @see java.util.regex.Matcher
 * @see java.util.regex.Pattern
 * 
 * @author EduardoStarZ
 * @since 1.0.0
 */

public class Search {
        private final String term;
        private final String target;

        /**
         * <p>
         * A constructor for the Search class, defining the
         * term and target variables to be used on globally on
         * the class.
         * </p>
         * 
         * @param term A String to be searched for throughout the
         *             target
         * @param target A String that will be analysed in the search
         *               for a correspondent term
         * 
         * @since 1.0.0
         */

        public Search(String term, String target) {
                this.term = term;
                this.target = target;
        }

        /**
         * <p>
         * A method that uses the term and target variables
         * to do a check for identical terms, and returns a 
         * boolean value depending on it.
         * </p>
         * 
         * <p>
         * Example:
         * <blockquote>
         * 
         * <pre>
         * 
         * String term = "i";
         * String target = "I like cheese";
         * 
         * Search mySearch = new Search(term, target);
         * 
         * boolean hasMatch = mySearch.hasMatch();
         * // would return true
         * 
         * </pre>
         * 
         * </blockquote>
         * 
         * @return A boolean value depending on the result of the search.
         * 
         * @since 1.0.0
         */
        public boolean hasMatch() {

                Pattern pattern = Pattern.compile(term);

                Matcher matcher = pattern.matcher(target);

                return matcher.find();
        }

        /**
         * <p>
         * A method that receives a boolean to determine whether
         * the search should be sensitive to different cases,
         * returning then a boolean.
         * </p>
         * 
         * <p>
         * Example:
         * <blockquote>
         * 
         * <pre>
         * 
         * String term = "i";
         * String target = "I like cheese";
         * 
         * Search mySearch = new Search(term, target);
         * 
         * boolean hasMatch = mySearch.hasMatch(caseSensitive:"true");
         * // would return true
         * 
         * </pre>
         * 
         * </blockquote>
         * 
         * @param caseSensitive A boolean that determines if the search should
         *                      be case-sensitive
         * @return A boolean value depending on the result of the search.
         * 
         * @since 1.0.0
         */
        public boolean hasMatch(boolean caseSensitive) {

                Pattern pattern = Pattern.compile(term);

                if (caseSensitive) {
                        pattern = Pattern.compile(term, Pattern.CASE_INSENSITIVE);
                }

                Matcher matcher = pattern.matcher(target);

                return matcher.find();
        }

         /**
         * <p>
         * A method that uses the defined term and target variables
         * to find the number of times that a term is found in the target.
         * 
         * Example:
         * <blockquote>
         * 
         * <pre>
         * 
         * String term = "i";
         * String target = "I like cheese";
         * 
         * Search mySearch = new Search(term, target);
         * 
         * int index = mySearch.indexOf();
         * // would return 2, since the caseSensitive boolean wasn't declared
         * 
         * </pre>
         * 
         * </blockquote>
         * </p>
         * 
         * @return An integer with the amount of times said term has been found in the target.
         * @since 1.0.0
         */
        public int indexOf() {
                ArrayList<String> index = new ArrayList<String>();

                Pattern pattern = Pattern.compile(term);

                Matcher matcher = pattern.matcher(target);

                while (matcher.find()) {
                        index.add(matcher.group());
                }

                return index.size();
        }

        /**
         * <p>
         * A method that uses the defined term and target variables
         * to find the number of times that a term is found in the target.
         * 
         * Example:
         * <blockquote>
         * 
         * <pre>
         * 
         * String term = "i";
         * String target = "I like cheese";
         * 
         * Search mySearch = new Search(term, target);
         * 
         * int index = mySearch.indexOf(caseSensitive:"true");
         * // would return 1, since the first "I" is capitalized
         * 
         * </pre>
         * 
         * </blockquote>
         * </p>
         * 
         * @param caseSensitive A boolean that determines if the search
         *                      should be case-sensitive
         * @return An integer with the amount of times said term has been found in the target.
         * @since 1.0.0
         */
        public int indexOf(boolean caseSensitive) {
                ArrayList<String> index = new ArrayList<String>();

                Pattern pattern = Pattern.compile(term);

                if (caseSensitive) {
                        pattern = Pattern.compile(term, Pattern.CASE_INSENSITIVE);
                }

                Matcher matcher = pattern.matcher(target);

                while (matcher.find()) {
                        index.add(matcher.group());
                }

                return index.size();
        }
}