package dev.esz.test.simplifier;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import dev.esz.simplifier.*;
import static dev.esz.simplifier.Mathematical.Factorial.factore;


public class AppTest {
    
    @Test
    public void testCollections() {

        Collections<Integer> iterate = new Collections<>();

        HashSet<Integer> list = new HashSet<Integer>();

        list.add(1);

        iterate.out(list, "", " pound of chocolate");
    }

    @Test
    public void testFiles() {

        try {
            /*
             * Files myFile = new Files("myFile.txt");
             * 
             * myFile.create();
             * // boolean[] can = myFile.can();
             * 
             * // for(int i=0; i<=can.length-1; i++) {
             * // System.out.println(can[i]);
             * //
             * 
             * System.out.println(myFile.isHidden());
             * 
             * System.out.println(myFile.exists());
             * 
             * myFile.rename("newName.txt");
             * 
             * myFile.write("hello there");
             * 
             * myFile = new Files("build/newName.txt");
             * myFile.delete();
             */
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
        Timer timer = new Timer();
        try {

            // System.out.println("Waiting 10 seconds");

            // timer.sleep();

            // System.out.println("10 seconds have passed");

        } catch (Exception ignored) {
        }
    }

    @Test
    public void testMathFactorial() {
        System.out.println(factore(5));
    }

    @Test
    public void testCopy() {
        // Files file = new Files("hey");
        // System.out.println(file.can()[0]);

        // file.copy();
    }

    @Test
    public void testEncryption() {
        Cryptography myCrypt = new Cryptography("Hey", "1234567890111213");
        byte[] encryptedMessage = myCrypt.encrypt();
        for (int i = 0; i <= encryptedMessage.length - 1; i++) {
            System.out.println(encryptedMessage[i]);
        }

        System.out.println(myCrypt.decrypt(myCrypt.accessSecretKey(), encryptedMessage));
    }

    @Test
    public void testFolderCopyAll() {
        Folder folder = new Folder("src\\test\\java\\folder");
     //   folder.copyAll();
        for(int i=0; i<=folder.foldersInFolder().length-1; i++) {
            System.out.println(folder.foldersInFolder()[i].toString());
        }
    }
}