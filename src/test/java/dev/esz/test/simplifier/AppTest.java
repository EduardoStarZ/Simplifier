package dev.esz.test.simplifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import dev.esz.simplifier.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testCollections() {

        Collections iterate = new Collections();

        HashSet<Integer> list = new HashSet<Integer>();

        list.add(1);

        iterate.out(list, "", " pound of cocaine");
    }

    @Test
    public void testFiles() {

        try {
            Files myFile = new Files("myFile.txt");

            myFile.create();
            // boolean[] can = myFile.can();

            // for(int i=0; i<=can.length-1; i++) {
            // System.out.println(can[i]);
            //

            System.out.println(myFile.isHidden());

            System.out.println(myFile.exists());

            myFile.rename("newName.txt");

            myFile.write("hello there");

            myFile = new Files("build/newName.txt");
            myFile.delete();
        } catch (Exception ignored) {

        }
    }

    @Test
    public void testColSet() {
        Collection<Integer> hey = new ArrayList<Integer>();

        hey.add(1);

        hey.add(2);

        Collections startIt = new Collections();

        hey = startIt.set(hey, "I am Number ", ".");

        startIt.out(hey, true);
    }

    @Test
    public void testTimer() {
        Timer timer = new Timer(0, 10);
        try {
            System.out.println("Waiting 10 seconds");

            timer.sleep();

            System.out.println("10 seconds have passed");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void testMathFactorial() {
        System.out.println(Mathematical.Factorial.factore(5));
    }

    @Test
    public void testCopy() {
        Files testFile = new Files("hey");

        testFile.copy();
    }
}