package dev.esz.simplifier;

import java.util.Arrays;
import java.util.Collections;
import org.apache.commons.lang3.ArrayUtils;

/**
 * <p>
 * A Java class that uses the quicksorting algorithym of the {@link ArrayUtils}
 * class
 * and sorts any kind of data type (either primitive or wrapper). Stored on
 * arrays, these data are sorted based on it's value (ascending order by default
 * but it can be defined to do it on descending order)
 * </p>
 * 
 * <p>
 * Example:
 * </p>
 * 
 * <blockquote>
 * 
 * <pre>
 * 
 *      Sorter mySorter = new Sorter;
 *      int[] myInts = {1, 9, 4, 6, 2, 4};
 * 
 *      myInts = mySorter.sort(sort: myInts, descendingOrder: false);
 * 
 *      for(int i=0; i<=myInts.length-1; i++) {
 *              System.out.Print(myInts[i]+" ");
 *      }
 * 
 *      //this would output "1 2 4 4 6 9 "
 * 
 * </pre>
 * 
 * </blockquote>
 * 
 * @see org.apache.commons.lang3.ArrayUtils
 * @see java.util.Collections
 * @see java.util.Arrays
 * 
 * @author EduardoStarZ
 * 
 * @since 1.0.0
 */

public class Sorter {

        /**
         * <p>
         * A method to sort Arrays of Strings into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of strings with the contents it previously had sorted, without
         * adding or removing elements
         * 
         * @since 1.0.0
         */
        public static String[] sort(String[] sort) {
                Arrays.sort(sort);
                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of Strings into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of strings with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static String[] sort(String[] sort, boolean descendingOrder) {
                Arrays.sort(sort);

                if (descendingOrder) {
                        Arrays.sort(sort, Collections.reverseOrder());
                }

                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of integers (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of integers with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static int[] sort(int[] sort) {

                Arrays.sort(sort);

                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of integers (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of integers with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static int[] sort(int[] sort, boolean descendingOrder) {

                Integer[] objSort = ArrayUtils.toObject(sort);

                if (descendingOrder) {
                        Arrays.sort(objSort, Collections.reverseOrder());
                } else {
                        Arrays.sort(objSort);
                }

                sort = ArrayUtils.toPrimitive(objSort);

                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of integers (Wrapper type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of integers with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static Integer[] sort(Integer[] sort) {

                Arrays.sort(sort);

                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of integers (Wrapper type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of integers with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static Integer[] sort(Integer[] sort, boolean descendingOrder) {

                if (descendingOrder) {
                        Arrays.sort(sort, Collections.reverseOrder());
                } else {
                        Arrays.sort(sort);
                }

                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of longs (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of longs with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static long[] sort(long[] sort) {

                Arrays.sort(sort);

                return sort;
        }

         /**
         * <p>
         * A method to sort Arrays of longs (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of longs with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static long[] sort(long[] sort, boolean descendingOrder) {

                Long[] objSort = ArrayUtils.toObject(sort);

                if (descendingOrder) {
                        Arrays.sort(objSort, Collections.reverseOrder());
                } else {
                        Arrays.sort(objSort);
                }

                sort = ArrayUtils.toPrimitive(objSort);

                return sort;
        }

         /**
         * <p>
         * A method to sort Arrays of longs (Wrapper type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of longs with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static Long[] sort(Long[] sort) {

                Arrays.sort(sort);

                return sort;
        }

         /**
         * <p>
         * A method to sort Arrays of longs (Wrapper type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of longs with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static Long[] sort(Long[] sort, boolean descendingOrder) {

                if (descendingOrder) {
                        Arrays.sort(sort, Collections.reverseOrder());
                } else {
                        Arrays.sort(sort);
                }

                return sort;
        }

         /**
         * <p>
         * A method to sort Arrays of characters (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of characters with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static char[] sort(char[] sort) {
                Arrays.sort(sort);

                return sort;
        }

         /**
         * <p>
         * A method to sort Arrays of characters (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of characters with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static char[] sort(char[] sort, boolean descendingOrder) {
                Character[] objSort = ArrayUtils.toObject(sort);

                if (descendingOrder) {
                        Arrays.sort(objSort, Collections.reverseOrder());
                } else {
                        Arrays.sort(objSort);
                }

                sort = ArrayUtils.toPrimitive(objSort);

                return sort;
        }

         /**
         * <p>
         * A method to sort Arrays of characters (Wrapper type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of characters with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static Character[] sort(Character[] sort) {

                Arrays.sort(sort);

                return sort;
        }

         /**
         * <p>
         * A method to sort Arrays of characters (Wrapper type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of characters with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static Character[] sort(Character[] sort, boolean descendingOrder) {

                if (descendingOrder) {
                        Arrays.sort(sort, Collections.reverseOrder());
                } else {
                        Arrays.sort(sort);
                }

                return sort;
        }

         /**
         * <p>
         * A method to sort Arrays of bytes (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of bytes with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static byte[] sort(byte[] sort) {
                Arrays.sort(sort);

                return sort;
        }

         /**
         * <p>
         * A method to sort Arrays of bytes (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of bytes with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static byte[] sort(byte[] sort, boolean descendingOrder) {
                Byte[] objSort = ArrayUtils.toObject(sort);

                if (descendingOrder) {
                        Arrays.sort(objSort, Collections.reverseOrder());
                } else {
                        Arrays.sort(objSort);
                }

                sort = ArrayUtils.toPrimitive(objSort);

                return sort;
        }

         /**
         * <p>
         * A method to sort Arrays of bytes (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of bytes with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static Byte[] sort(Byte[] sort) {

                Arrays.sort(sort);

                return sort;
        }

         /**
         * <p>
         * A method to sort Arrays of bytes (Wrapper type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of bytes with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static Byte[] sort(Byte[] sort, boolean descendingOrder) {

                if (descendingOrder) {
                        Arrays.sort(sort, Collections.reverseOrder());
                } else {
                        Arrays.sort(sort);
                }

                return sort;
        }

         /**
         * <p>
         * A method to sort Arrays of shorts (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of shorts with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static short[] sort(short[] sort) {
                Arrays.sort(sort);

                return sort;
        }

         /**
         * <p>
         * A method to sort Arrays of shorts (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of shorts with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static short[] sort(short[] sort, boolean descendingOrder) {
                Short[] objSort = ArrayUtils.toObject(sort);

                if (descendingOrder) {
                        Arrays.sort(objSort, Collections.reverseOrder());
                } else {
                        Arrays.sort(objSort);
                }

                sort = ArrayUtils.toPrimitive(objSort);

                return sort;
        }

         /**
         * <p>
         * A method to sort Arrays of shorts (Wrapper type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of shorts with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static Short[] sort(Short[] sort) {

                Arrays.sort(sort);

                return sort;
        }

         /**
         * <p>
         * A method to sort Arrays of shorts (Wrapper type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of shorts with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static Short[] sort(Short[] sort, boolean descendingOrder) {

                if (descendingOrder) {
                        Arrays.sort(sort, Collections.reverseOrder());
                } else {
                        Arrays.sort(sort);
                }

                return sort;
        }


         /**
         * <p>
         * A method to sort Arrays of floats (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of floats with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static float[] sort(float[] sort) {
                Arrays.sort(sort);

                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of floats (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of floats with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static float[] sort(float[] sort, boolean descendingOrder) {
                Float[] objSort = ArrayUtils.toObject(sort);

                if (descendingOrder) {
                        Arrays.sort(objSort, Collections.reverseOrder());
                } else {
                        Arrays.sort(objSort);
                }

                sort = ArrayUtils.toPrimitive(objSort);

                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of floats (Wrapper type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of floats with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static Float[] sort(Float[] sort) {

                Arrays.sort(sort);

                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of floats (Wrapper type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of floats with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static Float[] sort(Float[] sort, boolean descendingOrder) {

                if (descendingOrder) {
                        Arrays.sort(sort, Collections.reverseOrder());
                } else {
                        Arrays.sort(sort);
                }

                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of doubles (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of doubles with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static double[] sort(double[] sort) {
                Arrays.sort(sort);

                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of doubles (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of doubles with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static double[] sort(double[] sort, boolean descendingOrder) {
                Double[] objSort = ArrayUtils.toObject(sort);

                if (descendingOrder) {
                        Arrays.sort(objSort, Collections.reverseOrder());
                } else {
                        Arrays.sort(objSort);
                }

                sort = ArrayUtils.toPrimitive(objSort);

                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of doubles (Wrapper type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of doubles with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static Double[] sort(Double[] sort) {

                Arrays.sort(sort);

                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of doubles (Wrappers type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of doubles with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static Double[] sort(Double[] sort, boolean descendingOrder) {

                if (descendingOrder) {
                        Arrays.sort(sort, Collections.reverseOrder());
                } else {
                        Arrays.sort(sort);
                }

                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of booleans (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of booleans with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static boolean[] sort(boolean[] sort) {
                Boolean[] objSort = ArrayUtils.toObject(sort);

                Arrays.sort(objSort);

                sort = ArrayUtils.toPrimitive(objSort);

                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of booleans (Primitive type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         *
         * @param sort The array to be sorted
         * @return An Array of booleans with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static boolean[] sort(boolean[] sort, boolean descendingOrder) {
                Boolean[] objSort = ArrayUtils.toObject(sort);

                if (descendingOrder) {
                        Arrays.sort(objSort, Collections.reverseOrder());
                } else {
                        Arrays.sort(objSort);
                }

                sort = ArrayUtils.toPrimitive(objSort);

                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of booleans (Wrapper type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of booleans with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static Boolean[] sort(Boolean[] sort) {

                Arrays.sort(sort);

                return sort;
        }

        /**
         * <p>
         * A method to sort Arrays of booleans (Wrapper type) into a order, either ascending or
         * descending order (ascending if not declared).
         * </p>
         * 
         * @param sort The array to be sorted
         * @return An Array of booleans with the contents it previously had sorted, without
         * adding or removing elements.
         * 
         * @since 1.0.0
         */
        public static Boolean[] sort(Boolean[] sort, boolean descendingOrder) {

                if (descendingOrder) {
                        Arrays.sort(sort, Collections.reverseOrder());
                } else {
                        Arrays.sort(sort);
                }

                return sort;
        }
}