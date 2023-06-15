package dev.esz.simplifier;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.InputMismatchException;

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
         * A method that creates a new file using the pathname
         * provided in the pathname String.
         * </p>
         * 
         * @throws InputMismatchException if the selected pathname already has a file with the same name,
         *               if the program lacks permission to write in the folder
         *               indicated.
         * 
         * @since 1.0.0
         */
        public boolean create() {

                File file = new File(pathname);

                boolean fileCreated;

                String[] name = pathname.split("\\\\");
                int length = name.length - 1;

                if (file.exists()) {
                        throw new InputMismatchException("The file " + name[length] + " already exists");
                } else {
                        try {
                                fileCreated = file.createNewFile();
                        } catch (Exception e) {
                                throw new InputMismatchException("File could not be created, or the program lacks the permission to write to the selected folder");
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
         * @throws FileNotFoundException if the file can't be found, if the pathname is a folder
         *               instead of a file.
         * 
         * @since 1.0.0
         */
        public void delete() throws FileNotFoundException {

                String[] name = pathname.split("\\\\");
                int length = name.length - 1;

                File file = new File(pathname);

                if (file.isFile()) {
                        if (file.delete()) {
                                throw new FileNotFoundException("The file " + name[length] + " couldn't be found");
                        }
                } else {
                        throw new InputMismatchException("Method delete() received a folder instead of a file");
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
         * @since 1.0.0
         */
        public void write(String input) throws FileNotFoundException {

                String[] name = pathname.split("\\\\");
                int length = name.length - 1;

                try {
                        File File = new File(pathname);
                        FileWriter myWriter = new FileWriter(pathname);

                        if (File.exists()) {
                                myWriter.write(input);

                        } else {
                                myWriter.close();
                                throw new FileNotFoundException("The file " + name[length] + " couldn't be found");
                        }
                        myWriter.close();
                } catch (Exception e) {
                        throw new FileNotFoundException("The file " + name[length] + " couldn't be found");
                }

        }

        /**
         * <p>
         * A method that receives an input and appends it
         * to the file defined in the pathname String.
         * </p>
         * 
         * @throws FileNotFoundException if the file can't be found.
         * 
         * @param input A String that acts as the content to be concatenated
         *              to the file, after whatever is in the file
         * 
         * @since 1.0.0
         */
        public void append(String input) throws FileNotFoundException {

                String[] name = pathname.split("\\\\");
                int length = name.length - 1;

                try {
                        File File = new File(pathname);
                        FileWriter myWriter = new FileWriter(pathname);

                        if (File.exists()) {
                                myWriter.append(input);

                        } else {
                                myWriter.close();
                                throw new FileNotFoundException("The file " + name[length] + " couldn't be found");
                        }

                        myWriter.close();
                } catch (Exception e) {
                        throw new FileNotFoundException("The file " + name[length] + " couldn't be found");
                }
        }

        /**
         * <p>
         * A method that determines if the file can be
         * read, wrote to and executed, and returns it in a
         * boolean Array.
         * </p>
         * 
         * @throws FileNotFoundException if the file can't be found.
         * 
         * @return An Array of booleans with the information about what the selected file can do, in order:
         * read, write and execute.
         * 
         * @since 1.0.0
         * 
         */
        public boolean[] can() throws FileNotFoundException {

                String[] name = pathname.split("\\\\");
                int length = name.length - 1;
                boolean[] data = new boolean[3];

                File file = new File(pathname);

                if (file.exists()) {
                        data[0] = file.canRead();
                        data[1] = file.canWrite();
                        data[2] = file.canExecute();
                } else {
                        throw new FileNotFoundException("The file " + name[length] + " couldn't be found");
                }

                return data;
        }

        /**
         * <p>
         * A method that determines if the file
         * defined by the pathname String exists, then it returns
         * a boolean.
         * 
         * @throws InputMismatchException if the method receives a folder instead of a file.
         * 
         * @return A boolean that indicates if the file with the declared pathname exists.
         * 
         * @since 1.0.0
         */
        public boolean exists() {
                File file = new File(pathname);
                boolean exists = false;

                if (file.isFile()) {
                        if (file.exists()) {
                                exists = true;
                        }
                } else {
                        throw new InputMismatchException("Method exists received a folder instead of a file");
                }

                return exists;
        }

        /**
         * <p>
         * A method that receives a new pathname to rename a
         * file, and sets it as the new pathname for that specified file
         * as long as the {@link Files} object does not receive a new value.
         * </p>
         * 
         * @throws InputMismatchException if the file already exists or if the method receives a folder
         *               instead of a file.
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
                                throw new InputMismatchException("The file " + newName + "already exists");
                        } else {
                                isFileRenamed = name.renameTo(newName);
                                Files e = new Files(newPathname);
                        }
                } else {
                        throw new InputMismatchException("Method rename() received a folder instead of a file");
                }

                return isFileRenamed;
        }

        /**
         * <p>
         * A method that checks if the selected file is a 
         * hidden file in the System, then it returns a boolean.
         * </p>
         * 
         * @throws InputMismatchException if the method receives a folder instead of a file.
         * 
         * @return A boolean that indicates if the file with the declared pathname is hidden.
         * 
         * @since 1.0.0
         */
        public boolean isHidden() {
                File file = new File(pathname);
                boolean hidden = false;
                if (file.isFile()) {
                        if (file.isHidden()) {
                                hidden = true;
                        }
                } else {
                        throw new InputMismatchException("Method isHidden() received a folder instead of a file");
                }

                return hidden;
        }
}