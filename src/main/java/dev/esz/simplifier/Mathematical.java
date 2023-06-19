package dev.esz.simplifier;

import java.util.Random;

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
    /**
     * @author EduardoStarZ
     *
     * @since 1.0.0
     * */
    public static class random<T>{
        T obj;

        public random(T obj) {
            this.obj = obj;
        }
        
        public void showType() {
            System.out.println("Type is "+ obj.getClass().getName());
        }

        private String getType() {
            return obj.getClass().getName();
        }

        public void generate() {
            random<T> randomObject = new random<>(obj);

            Random myRandom = new Random();
            String type = randomObject.getType();

            switch (type) {
                case "java.lang.String":
                    ;
                    break;

                case "java.lang.Integer":
                    break;

                case "java.lang.Float":
                    ;
                    break;

                case "java.lang.Double":
                    ;
                    break;

                case "java.lang.Short":
                    ;
                    break;

                case "java.lang.Long":
                    ;
                    break;

                case "java.lang.Byte":
                    ;
                    break;

                case "java.lang.Boolean":
                    ;
                    break;
            }

            //java.lang.String
            //java.lang.Integer
            //java.lang.Character
            //java.lang.Double
            //java.lang.Long
            //java.lang.Short
            //java.lang.Float
            //java.lang.Boolean
            //java.lang.Byte

        }
    }
}