package dev.esz.simplifier;

/**
 * <p> A java class that contains different mathematical operations stored in subclasses
 * </p>
 * 
 * @see dev.esz.simplifier.Mathematical
 * @see java.lang.Math
 * 
 * @since 1.0.0
 * 
 * @author EduardoStarZ
 */
public class Mathematical {

    /**
     * <p>
     * A java subclass to handle with a factorial operation.
     * </p>
     * 
     * <p>
     * A factorial is a number that gets multiplied by all of it's predecessors.
     * </p>
     * 
     * <p>
     * Example:
     * </p>
     * 
     * <pre>
     * <blockquote>
     *  5! = 5 * 4 * 3 * 2 * 1
     *  5! = 120
     * </pre>
     * 
     * </blockquote>
     * 
     * @see dev.esz.simplifier.Mathematical.Factorial
     * @see java.lang.Math
     * 
     * @since 1.0.0
     * 
     * @author EduardoStarZ
     */
    public static class Factorial {

        private static int factorial;
        private static int initial;

        /**
         * <p>
         * A java method that privately calculates the factorial of the provided number.
         * </p>
         * 
         * @since 1.0.0
         */
        private void factorialOperation() {
            initial -= 1;
            factorial *= initial;

            if (initial != 1) {
                factorialOperation();

            }
        }

        /**
         * 
         * <p>A static method that receives a number and calculates it's factorial.
         * </p>
         * 
         * @param number the number to have the factorial calculated.
         * @return an integer containing the factorial of the provided number.
         * 
         * @since 1.0.0
         */
        public static int factore(int number) {
            Factorial start = new Factorial();

            initial = number;
            factorial = number;

            start.factorialOperation();

            return factorial;
        }
    }
}
