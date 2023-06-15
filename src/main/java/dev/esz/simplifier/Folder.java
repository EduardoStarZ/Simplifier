package dev.esz.simplifier;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * <p>
 * A Java class for managing and analising the contents and properties of
 * a {@link Folder} and the {@link Folder} itself.
 * 
 * </p>
 * 
 * <p>
 * The {@link Folder} class can:
 * <ul>
 * <li>Search for all the files it contains</li>
 * <li>Search for all the folders it contains</li>
 * <li>Rename the selected folder</li>
 * <li>Decide if a {@link Folder} is hidden or not</li>
 * </ul>
 * 
 * </p>
 * 
 * <p>
 * To use the class, create a {@link Folder} object as the following:
 * 
 * <blockquote>
 * 
 * <pre>
 * 
 * Folder myFolder = new Folder(pathname:"my/folders/selectedFolder")
 * 
 * </pre>
 * 
 * </blockquote>
 * 
 * </p>
 * 
 * <p>
 * A pathname for the {@link Folder} class should be defined by using single "/"
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
 *  String pathname = "myFolder/mySelectedFolder"
 * 
 * //or
 * 
 * String pathname = "myFolder\\mySelectedFolder"
 * 
 * </pre>
 * 
 * </blockquote>
 * 
 * </p>
 * 
 * @see dev.esz.simplifier.Folder
 * @see dev.esz.simplifier.Files
 * @see java.io.File
 * 
 * @author EduardoStarZ
 * @since 1.0.0
 * 
 */

public class Folder {
        private String pathname;

        /**
         * <p>
         * A constructor to the {@link Folder} class that
         * defines a String pathname globally.
         * <p>
         * 
         * @param pathname A String that acts as a pathname for the folder location
         * 
         * @since 1.0.0
         * 
         */
        public Folder(String pathname) {
                this.pathname = setPathname(pathname);
        }

        /**
         * <p>
         * A private class that used along, but not exclusively, by the
         * constructor in order to replace any found "/" characters by a
         * quadruple "\" characters, in order to define a pathname to the
         * {@link Folder}.
         * </p>
         * 
         * @param pathname A String that acts as a pathname for the folder location
         * @return A String containing the pathname with the slash (/) and space ( )
         *         characters
         *         remapped to a quadruple backslash (\) to set the pathname of the
         *         folder.
         * 
         * @since 1.0.0
         * 
         */
        private String setPathname(String pathname) {
                pathname = pathname.replace(" ", "");
                this.pathname = pathname.replace("/", "\\\\");

                return pathname;
        }

        /**
         * <p>
         * A method that searches for all files in a folder, stores and
         * return them as an Array of Objects.
         * </p>
         * 
         * @return An array of objects containing the names of the files inside the
         *         declared folder.
         * 
         * @since 1.0.0
         * 
         */
        public Object[] filesInFolder() {

                File folder = new File(pathname);

                File[] fileList = folder.listFiles();
                ArrayList<String> file = new ArrayList<String>();

                for (int i = 0; i <= fileList.length - 1; i++) {
                        File getFile = fileList[i];

                        if (getFile.isFile()) {
                                file.add(getFile.toString());
                        }
                }

                Object[] files = file.toArray();

                return files;
        }

        /**
         * <p>
         * A method that searches for all folders in a folder, stores and
         * return them as an Array of Objects.
         * </p>
         * 
         * @return An array of objects containing the names of the folders inside the
         *         declared folder.
         * @since 1.0.0
         * 
         */
        public Object[] foldersInFolder() {

                File Folder = new File(pathname);

                File[] folderList = Folder.listFiles();
                ArrayList<String> folder = new ArrayList<String>();

                for (int i = 0; i <= folderList.length - 1; i++) {
                        File getFolder = folderList[i];

                        if (!getFolder.isFile()) {
                                folder.add(getFolder.toString());
                        }
                }

                return folder.toArray();

        }

        /**
         * <p>
         * A method that receives a new pathname to rename a
         * folder, and sets it as the new pathname for that specified folder
         * as long as the {@link Folder} object does not receive a new value.
         * </p>
         * 
         * @throws InputMismatchException if it tries to rename a file instead of a
         *                                folder, or if the new name is already taken by
         *                                another folder.
         * 
         * @param newPathname A String that acts as the new pathname for the folder
         *                    location
         * 
         * @since 1.0.0
         */
        public boolean rename(String newPathname) {
                newPathname = setPathname(newPathname);

                File name = new File(pathname);
                File newName = new File(newPathname);

                boolean isFolderRenamed;

                if (!name.isFile()) {
                        if (newName.exists()) {
                                throw new InputMismatchException("The folder " + newName + "already exists");
                        } else {
                                isFolderRenamed = name.renameTo(newName);
                                Folder e = new Folder(newPathname);

                        }
                } else {
                        throw new InputMismatchException("Class rename received a file instead of a folder");
                }

                return isFolderRenamed;
        }

        /**
         * <p>
         * A method that checks if a folder is hidden or not
         * and returns a boolean value.
         * </p>
         * 
         * @throws InputMismatchException if it tries to check for a file instead of a
         *                                folder.
         * 
         * @return A boolean that indicates if the folder is or not a hidden one.
         * 
         * @since 1.0.0
         */
        public boolean isHidden() {
                File folder = new File(pathname);
                boolean hidden = false;
                if (!folder.isFile()) {
                        if (folder.isHidden()) {
                                hidden = true;
                        }
                } else {
                        throw new InputMismatchException("Class rename received a file instead of a folder");
                }

                return hidden;
        }

        /**
         * <p>
         * A method that checks if a folder exists,
         * returns a boolean value.
         * 
         * @throws InputMismatchException if the method receives a file pathname instead
         *                                of a folder pathname.
         * 
         * @return A boolean that indicates if the folder in the declared pathname exists.
         * 
         * @since 1.0.0
         */
        public boolean exists() {
                File folder = new File(pathname);
                boolean exists = false;

                if (!folder.isFile()) {
                        if (folder.exists()) {
                                exists = true;
                        }
                } else {
                        throw new InputMismatchException("Method rename received a file instead of a folder");
                }
                return exists;
        }
}