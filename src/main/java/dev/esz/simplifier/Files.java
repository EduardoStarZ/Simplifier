package dev.esz.simplifier;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

class FileNotFoundException extends RuntimeException {

        /**
         * <p>
         * A Exception class (that inherits the RuntimeException class) to be used when
         * a file
         * is not found during an operation.
         * </p>
         * 
         * @see java.io.FileNotFoundException
         * 
         * @param message A String containing the message to be shown to the terminal
         * 
         * @since 1.1.0
         * 
         * @author EduardoStarZ
         */
        public FileNotFoundException(String message) {
                super(message);
        }

        /**
         * <p>
         * A Exception class (that inherits the RuntimeException class) to be used when
         * a file
         * is not found during an operation.
         * </p>
         * 
         * @see java.io.FileNotFoundException
         * 
         * @param message A String containing the message to be shown to the terminal
         * 
         * @param error   A throwable object, generally used to pass the root cause of
         *                an exception.
         * 
         * @since 1.1.0
         * 
         * @author EduardoStarZ
         */
        public FileNotFoundException(String message, Throwable error) {
                super(message, error);
        }
}

class FileAlreadyExistsException extends RuntimeException {

        /**
         * <p>
         * A Exception class (that inherits the RuntimeException class) to be used when
         * a file already exists, generally when the runtime tries to create it again.
         * </p>
         * 
         * @param message A String containing the message to be shown to the terminal
         * 
         * @since 1.1.0
         * 
         * @author EduardoStarZ
         */
        public FileAlreadyExistsException(String message) {
                super(message);
        }

        /**
         * <p>
         * A Exception class (that inherits the RuntimeException class) to be used when
         * a file already exists, generally when the runtime tries to create it again.
         * </p>
         * 
         * @param message A String containing the message to be shown to the terminal
         * 
         * @param error   A throwable object, generally used to pass the root cause of
         *                an exception.
         * 
         * @since 1.1.0
         * 
         * @author EduardoStarZ
         */
        public FileAlreadyExistsException(String message, Throwable error) {
                super(message, error);
        }
}

class FileNotReadableException extends RuntimeException {

        /**
         * <p>
         * A Exception class (that inherits the RuntimeException class) to be used when
         * the file defined by the pathname is not readable as an normal text file.
         * </p>
         * 
         * @param message A String containing the message to be shown to the terminal
         * 
         * @since 1.1.0
         * 
         * @author EduardoStarZ
         */
        public FileNotReadableException(String message) {
                super(message);
        }

        /**
         * <p>
         * A Exception class (that inherits the RuntimeException class) to be used when
         * the file defined by the pathname is not readable as an normal text file.
         * </p>
         * 
         * @param message A String containing the message to be shown to the terminal
         * 
         * @param error   A throwable object, generally used to pass the root cause of
         *                an exception.
         * 
         * @since 1.1.0
         * 
         * @author EduardoStarZ
         */
        public FileNotReadableException(String message, Throwable error) {
                super(message, error);
        }
}

/**
 * <p>
 * A Java class for creating, writing and managing {@link Files}
 * 
 * </p>
 * 
 * <p>
 * The {@link Files} class can:
 * <ul>
 * <li>Create a new file</li>
 * <li>Write to a file</li>
 * <li>Rename a file</li>
 * <li>Decide if a file is hidden or not</li>
 * <li>Append to a file</li>
 * <li>Check if a file exists</li>
 * <li>See if a file can be read, wrote to and executed</li>
 * <li>Delete a file</li>
 * </ul>
 * 
 * </p>
 * 
 * <p>
 * To use the class, create a {@link Files} object as the following:
 * 
 * <blockquote>
 * 
 * <pre>
 * 
 * Files myHandler = new Files(pathname:"my/folder/selectedFile.extension")
 * 
 * </pre>
 * 
 * </blockquote>
 * 
 * </p>
 * 
 * <p>
 * A pathname for the {@link Files} class should be defined by using single "/"
 * or double "\"
 * in the directories division.
 * </p>
 * 
 * <p>
 * Example:
 * <blockquote>
 * 
 * <pre>
 * 
 *  String pathname = "myFolder/mySelectedFile.extension"
 * 
 * //or
 * 
 * String pathname = "myFolder\\mySelectedFile.extension"
 * 
 * </pre>
 * 
 * </blockquote>
 * 
 * </p>
 * 
 * @see dev.esz.simplifier.Files
 * @see dev.esz.simplifier.Folder
 * @see java.io.File
 * 
 * @author EduardoStarZ
 * @since 1.0.0
 * 
 */

public class Files {
        private String pathname;

        /**
         * <p>
         * A constructor for setting the pathname
         * String on the {@link Files} object start
         * </p>
         * 
         * @param pathname A String that acts as a pathname for the file location
         * 
         * @since 1.0.0
         */
        public Files(String pathname) {
                this.pathname = setPathname(pathname);
        }

        /**
         * <p>
         * A private method that runs when the constructor is
         * called, setting the pathname String to a valid pathname.
         * </p>
         *
         * @param pathname A String that acts as a pathname for the file location
         * @return The pathname to the constructor
         *
         * @since 1.0.0
         */
        private String setPathname(String pathname) {
                pathname = pathname.replace(" ", "");
                this.pathname = pathname.replace("/", "\\\\");

                return pathname;
        }

        /**
         * <p>
         * A method that receives a new pathname to rename a
         * file, and sets it as the new pathname for that specified file
         * as long as the {@link Files} object does not receive a new value.
         * </p>
         *
         * @throws FileAlreadyExistsException if the file already exists.
         * 
         * @throws FileNotFoundException      if the method receives a folder instead of
         *                                    a file.
         *
         * @param newPathname A String that will provide
         *                    the new pathname for the file location
         *
         * @since 1.0.0
         */
        public boolean rename(String newPathname) {
                File name = new File(pathname);
                boolean isFileRenamed;

                File newName = new File(newPathname);

                if (name.isFile()) {
                        if (newName.exists()) {
                                throw new FileAlreadyExistsException("The file " + newName + "already exists");
                        } else {
                                isFileRenamed = name.renameTo(newName);
                        }
                } else {
                        throw new FileNotFoundException("Method rename() received a folder instead of a file");
                }

                return isFileRenamed;
        }

        /**
         * <p>
         * A method that creates a new file using the pathname
         * provided in the pathname String.
         * </p>
         *
         * @throws FileAlreadyExistsException if the selected pathname already has a
         *                                    file with the same name.
         * 
         * @throws InputMismatchException     if the program lacks permission to write
         *                                    in the folder indicated.
         *
         * @since 1.0.0
         */
        public boolean create() {

                File file = new File(pathname);

                boolean fileCreated = false;

                String[] name = pathname.split("\\\\");
                int length = name.length - 1;

                if (file.exists()) {
                        throw new FileAlreadyExistsException("The file " + name[length] + " already exists");
                } else {
                        try {
                                fileCreated = file.createNewFile();
                        } catch (Exception e) {
                                //throw new InputMismatchException(
//                                                "File could not be created, or the program lacks the permission to write to the selected folder");
                        }
                }

                return fileCreated;
        }

        /**
         * <p>
         * A method that deletes a file using the pathname
         * provided in the pathname String.
         * </p>
         *
         * @throws FileNotFoundException if the file can't be found, if the pathname is
         *                               a folder instead of a file.
         *
         * @since 1.0.0
         */
        public void delete() {

                File file = new File(pathname);

                if (file.isFile()) {
                        if (file.delete()) {
                                throw new FileNotFoundException("The file " + getFileName() + " couldn't be found");
                        }
                } else {
                        throw new InputMismatchException("Received a folder instead of a file");
                }
        }

        /**
         * <p>
         * A method that determines if the file can be
         * read, wrote to and executed, and returns it in a
         * boolean Array.
         * </p>
         *
         * @throws InputMismatchException if the file can't be found.
         *
         * @return An Array of booleans with the information about what the selected
         *         file can do, in order:
         *         read, write and execute.
         *
         * @since 1.0.0
         *
         */
        public boolean[] can() {
                boolean[] data = new boolean[3];

                File file = new File(pathname);

                if (file.exists()) {
                        data[0] = file.canRead();
                        data[1] = file.canWrite();
                        data[2] = file.canExecute();
                } else {
                        throw new FileNotFoundException("The file " + getFileName() + " couldn't be found");
                }

                return data;
        }

        /**
         * <p>
         * A method that determines if the file
         * defined by the pathname String exists, then it returns
         * a boolean.
         *
         * @throws InputMismatchException if the method receives a folder instead of a
         *                                file.
         *
         * @return A boolean that indicates if the file with the declared pathname
         *         exists.
         *
         * @since 1.0.0
         */
        public boolean exists() {
                File file = new File(pathname);

                return file.exists();
        }

        /**
         * <p>
         * A method that checks if the selected file is a
         * hidden file in the System, then it returns a boolean.
         * </p>
         *
         * @throws InputMismatchException if the method receives a folder instead of a
         *                                file.
         *
         * @return A boolean that indicates if the file with the declared pathname is
         *         hidden.
         *
         * @since 1.0.0
         */
        public boolean isHidden() {
                File file = new File(pathname);

                if (file.exists()) {
                        return file.isHidden();
                } else {
                        throw new InputMismatchException("Received a folder instead of a file");
                }
        }

        /**
         * <p>
         * A method that receives a input and writes it
         * to the file defined in the pathname String.
         * </p>
         *
         * @throws FileNotFoundException if the file can't be found.
         *
         * @param input A String that acts as the content to be written into
         *              the file, overriding whatever may be in there
         * 
         * @return A boolean indicating if the write operation was successfully made.
         *
         * @since 1.0.0
         */
        public boolean write(String input) {

                try {
                        File File = new File(pathname);
                        FileWriter myWriter = new FileWriter(pathname);

                        if (File.exists()) {
                                myWriter.write(input);
                                myWriter.close();
                                return true;
                        }
                        myWriter.close();
                        return false;
                } catch (Exception e) {
                        throw new FileNotFoundException("The file " + getFileName() + " couldn't be found");
                }
        }

        /**
         * <p>
         * A method that receives an input and appends it
         * to the file defined in the pathname String.
         * </p>
         *
         * @throws InputMismatchException if the file can't be found.
         *
         * @param input A String that acts as the content to be concatenated
         *              to the file, after whatever is in the file
         * 
         * @return A boolean that indicates if the append operation was successfully made.
         *
         * @since 1.0.0
         */
        public boolean append(String input) {

                try {
                        File File = new File(pathname);
                        FileWriter myWriter = new FileWriter(pathname);

                        if (File.exists()) {
                                myWriter.append(input);
                                myWriter.close();
                                return true;
                        }
                        myWriter.close();
                        return false;
                } catch (Exception e) {
                        throw new FileNotFoundException("The file " + getFileName() + " couldn't be found");
                }
        }

        /**
         * <p>
         * A method that access the contents of a file and copies it into
         * a String, preserving the line breaking with "/n" codes.
         * </p>
         *
         * @throws FileNotFoundException if the file can't be found
         *
         * @return A String containing the entire file content
         *
         * @since 1.0.0
         */
        public String content() {

                File file = new File(pathname);
                Scanner scanner;
                try {
                        scanner = new Scanner(file);
                } catch (IOException e) {
                        throw new FileNotFoundException("The file " + getFileName() + " could not be read");
                }
                StringBuilder content = new StringBuilder();

                while (scanner.hasNextLine()) {
                        content.append(scanner.nextLine());
                        content.append("\n");
                }

                scanner.close();

                return content.toString();
        }

        /**
         * <p>
         * A method that access the contents of a file in a an
         * specified line and copies it into a String
         * </p>
         *
         * @throws FileNotReadableException if the file can't be found
         *
         * @return A String containing the content of the declared line
         *
         * @since 1.0.0
         */
        public String contentAt(int line) {

                File file = new File(pathname);

                Scanner scanner;
                try {
                        scanner = new Scanner(file);
                } catch (Exception e) {
                        throw new FileNotReadableException("The file " + getFileName() + " could not be read");
                }
                String content = null;

                for (int i = 0; i <= line - 1; i++) {
                        content = scanner.nextLine();
                }
                scanner.close();

                return content;
        }

        /**
         * <p>
         * A method that copies the file specified in the pathname class
         * and adds a number indicating that the copied file is a different
         * one from the original (similar to how some OS's do when a file is copied)
         *
         * <pre>
         *     <blockquote>
         *         Files myFile = new File("myFile.txt");
         *
         *         myFile.copy();
         *         //this will generate a new file in the same directory, but with
         *         //name "myFile(1).txt"
         *     </blockquote>
         * </pre>
         *
         * </p>
         * 
         * @throws FileNotFoundException if the file defined in the pathname can't be
         *                               found.
         *
         * @since 1.0.0
         */
        public void copy() {
                Files file = new Files(pathname);

                file.copyFile(getFirstAvailablePathnameDiscriminator());
        }

        public void copy(String copyTo) {
                Files file = new Files(pathname);

                file.copyFile(copyTo);
        }

        /**
         * <p>
         * A method that checks if the provided pathname points to a file and
         * returns a boolean value on it's checking
         * </p>
         *
         * @return A boolean that indicates if the provided pathname points to a File.
         *
         * @since 1.1.0
         */
        public boolean isFile() {
                File file = new File(pathname);

                return file.isFile();
        }

        /**
         * <p>
         * A method that reads the file in the specified pathname, provided that the
         * file can be read,
         * and prints it on the console
         * </p>
         *
         * <pre>
         *     <blockquote>
         *         Files file = new Files(pathname/to/file);
         *
         *         boolean hadAnOutput = file.read();
         *         //this will print the file contents in the console, if the file can be read,
         *         //and return a boolean value according to this result
         *
         *     </blockquote>
         * </pre>
         *
         * @return A boolean that indicates if the file can be read
         *
         * @since 1.1.0
         */
        public boolean read() {
                Scanner reader = new Scanner(pathname);
                Files file = new Files(pathname);

                if (!file.exists()) {
                        reader.close();
                        return false;
                }

                // in this case, the [0] array pos references the readability of the file
                if (file.can()[0]) {
                        while (reader.hasNextLine()) {
                                reader.nextLine();
                        }
                        reader.close();
                        return true;
                }

                reader.close();

                return false;
        }

        /**
         * <p>
         * A method that uses the pathname to find the file name (not containing the
         * extensions)
         * </p>
         * 
         * 
         * @return A String containing the file name.
         * 
         * @since 1.1.0
         */
        public String getFileName() {
                String[] splitter = pathname.split("\\\\");

                splitter = splitter[splitter.length - 1].split("\\.");

                return splitter[0];
        }

        /**
         * <p>
         * A method that uses the pathname to find the file extension
         * </p>
         * 
         * @return A String containing the file extension.
         * 
         * @since 1.1.0
         */
        public String getFileExtension() {
                String[] splitter = pathname.split("\\\\");

                splitter = splitter[splitter.length - 1].split("\\.");

                if (splitter.length <= 1) {
                        return "";
                }

                StringBuilder newPathname = new StringBuilder();

                for (int i = 1; i <= splitter.length - 1; i++) {
                        newPathname.append(".").append(splitter[i]);
                }

                return newPathname.toString();
        }

        /**
         * <p>
         * A method that uses the pathname to search for the last ever directory in the
         * declared pathname.
         * </p>
         * 
         * @return A String containing the pathname of the last ever directory in the
         *         hierarchy.
         * 
         * @since 1.1.0
         */
        public String getFilePathname() {
                String[] splitter = pathname.split("\\\\");

                StringBuilder pathname = new StringBuilder();

                for (int i = 0; i <= splitter.length - 2; i++) {
                        pathname.append(splitter[i]).append("\\\\");
                }

                return pathname.toString();
        }

        /**
         * <p>
         * A method that creates a new pathname to a file with a discriminator (similar
         * to how windows does when copying files/folders), and returns it in a string.
         * </p>
         * 
         * @return A String containing a new pathname to a file with a discriminator.
         * 
         * @since 1.1.0
         */
        private String getFirstAvailablePathnameDiscriminator() {
                Files file = new Files(pathname);

                for (int i = 1; ; i++) {
                        file = new Files(getFilePathname() + getFileName() + "(" + i + ")" + getFileExtension());

                        if (!file.exists()) {
                                return file.pathname;
                        }
                }
        }

        /**
         * <p>
         * A method to copy the contents of a file into a new
         * one that will be created by the method when declaring the
         * pathname to the new file.
         * </p>
         *
         * @param copyTo The pathname that will set the directory to create the
         *                       copied
         *                       file
         * @since 1.1.0
         */
        private void copyFile(String copyTo) {
                File file = new File(pathname);
                Scanner scanner;
                try {
                        scanner = new Scanner(file);
                } catch (IOException e) {
                        throw new FileNotReadableException("The file " + getFileName() + " could not be read");
                }

                StringBuilder content = new StringBuilder();
                int i = 0;

                while (scanner.hasNextLine()) {
                        if (i != 0) {
                                content.append("\n");
                        }
                        content.append(scanner.nextLine());
                        i++;
                }
                Files myFile = new Files(setPathname(copyTo));

                myFile.create();

                myFile.write(content.toString());

                scanner.close();
        }
}