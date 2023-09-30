package dev.esz.simplifier;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author EduardoStarZ
 *
 * @since 1.1.0
 */
class FolderNotFoundException extends RuntimeException {

        /**
         * <p>
         * A java exception to point when a folder can't be found, caused whether by bad
         * input or if a file
         * pathname is provided to a {@link Folder} Object.
         * </p>
         *
         * @param message a String that receives the message to be outputted to the
         *                terminal when it is thrown.
         *
         * @author EduardoStarZ
         *
         * @see java.lang.Exception
         *
         * @since 1.1.0
         */
        public FolderNotFoundException(String message) {
                super(message);
        }

        /**
         * <p>
         * A java exception to point when a folder can't be found, caused whether by bad
         * input or if a file
         * pathname is provided to a {@link Folder} Object.
         * </p>
         *
         * @param message A String that receives the message to be outputted to the
         *                terminal when it is thrown.
         *
         * @param error   A throwable object, generally used to pass the root cause of
         *                an exception.
         *
         * @author EduardoStarZ
         *
         * @see java.lang.Exception
         *
         * @since 1.1.0
         */
        public FolderNotFoundException(String message, Throwable error) {
                super(message, error);
        }
}

class FolderAlreadyExistsException extends RuntimeException {

        /**
         * <p>
         * A java exception to point when a folder already exists while using the
         * {@link Folder} class.
         * </p>
         *
         * @param message A String that receives the message to be outputted to the
         *                terminal when it is thrown.
         *
         * @author EduardoStarZ
         *
         * @see java.lang.Exception
         *
         * @since 1.1.0
         */
        public FolderAlreadyExistsException(String message) {
                super(message);
        }

        /**
         * <p>
         * A java exception to point when a folder already exists while using the
         * {@link Folder} class.
         * </p>
         *
         * @param message A String that receives the message to be outputted to the
         *                terminal when it is thrown.
         *
         * @param error   A throwable object, generally used to pass the root cause of
         *                an exception.
         *
         * @author EduardoStarZ
         *
         * @see java.lang.Exception
         *
         * @since 1.1.0
         */
        public FolderAlreadyExistsException(String message, Throwable error) {
                super(message, error);
        }
}

class FolderIsEmptyException extends RuntimeException {

        /**
         * <p>
         * A java exception to point when a folder is empty while using the
         * {@link Folder} class.
         * </p>
         *
         * @param message A String that receives the message to be outputted to the
         *                terminal when it is thrown.
         *
         * @author EduardoStarZ
         *
         * @see java.lang.Exception
         *
         * @since 1.1.0
         */
        public FolderIsEmptyException(String message) {
                super(message);
        }

        /**
         * <p>
         * A java exception to point when a folder is empty while using the
         * {@link Folder} class.
         * </p>
         *
         * @param message A String that receives the message to be outputted to the
         *                terminal when it is thrown.
         *
         * @param error   A throwable object, generally used to pass the root cause of
         *                an exception.
         *
         * @author EduardoStarZ
         *
         * @see java.lang.Exception
         *
         * @since 1.1.0
         */
        public FolderIsEmptyException(String message, Throwable error) {
                super(message, error);
        }
}

/**
 * <p>
 * A Java class for managing and analysing the contents and properties of
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
                ArrayList<String> file = new ArrayList<>();

                if (fileList == null) {
                        throw new FolderIsEmptyException("The Folder does not contain any files");
                }

                for (int i = 0; i <= fileList.length - 1; i++) {
                        File getFile = fileList[i];

                        if (getFile.isFile()) {
                                file.add(getFile.toString());
                        }
                }

                return file.toArray();
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
                ArrayList<String> folder = new ArrayList<>();

                if (folderList == null) {
                        System.out.println(pathname);
                        throw new FolderIsEmptyException("The Folder does not contain any folders");
                }

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
         * @throws FolderNotFoundException if it tries to rename a file instead of a
         *                                 folder.
         *
         * @throws FolderIsEmptyException  If the new name is already taken by
         *                                 another folder.
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
                                throw new FolderAlreadyExistsException("The folder " + newName + "already exists");
                        } else {
                                isFolderRenamed = name.renameTo(newName);
                        }
                } else {
                        throw new FolderNotFoundException("A file was provided instead of a folder");
                }

                return isFolderRenamed;
        }

        /**
         * <p>
         * A method that checks if a folder is hidden or not
         * and returns a boolean value.
         * </p>
         * 
         * @throws FolderNotFoundException if it tries to check for a file instead of a
         *                                 folder.
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
                        throw new FolderNotFoundException("A file was provided instead of a folder");
                }

                return hidden;
        }

        /**
         * <p>
         * A method that checks if a folder exists,
         * returns a boolean value.
         * 
         * @return A boolean that indicates if the folder in the declared pathname
         *         exists.
         * 
         * @since 1.0.0
         */
        public boolean exists() {
                Folder folder = new Folder(pathname);
                File folderToFile = new File(folder.pathname);

                if (folderToFile.exists() && folder.isFolder()) {
                        return true;
                }

                return false;
        }

        /**
         * <p>
         * A method that points if the specified pathname provided is a folder
         * </p>
         *
         * @return A boolean that indicates if the provided pathname points to a folder.
         *
         * @since 1.1.0
         */
        public boolean isFolder() {
                File folder = new File(pathname);

                return !folder.isFile();
        }

        /**
         * <p>
         * A method that create folders, provided by the pathname set. If the pathname
         * specifies more than one folder to be created, the method will create all
         * folders specified
         * </p>
         *
         * <p>
         * If the method tries to create a folder that already exists, it'll ignore it,
         * and go onto the next
         * </p>
         *
         * @return A boolean that indicates if the folders could be created or not
         *
         * @since 1.1.0
         */
        public boolean create() {
                File folder = new File(pathname);

                if (folder.exists()) {
                        return true;
                }

                return folder.mkdirs();
        }

        /**
         * <p>
         * A method that uses the pathname to find the amount of folders
         * declared in the pathname.
         * </p>
         * 
         * @return An Integer containing the amount of folders in the pathname.
         * 
         * @since 1.1.0
         */
        public int getFolderChainSizeIndex() {
                Folder folder = new Folder(pathname);
                String[] splitter = folder.pathname.split("\\\\");

                if (!folder.isFolder()) {
                        return splitter.length - 1;
                }

                return splitter.length;
        }

        /**
         * <p>
         * A method that searches for the last folder in the pathname provided
         * and retrieves it's pathname
         * </p>
         *
         * @return A string containing the pathname for the last folder in the pathname.
         *
         * @throws FolderNotFoundException if the pathname does not provide any folders.
         *
         * @since 1.1.0
         */
        public String getLastFolderPathname() {
                Folder folder = new Folder(pathname);
                String[] pathname = folder.pathname.split("\\\\");
                StringBuilder newPathname = new StringBuilder();

                if (!folder.isFolder() && pathname.length < 1) {
                        throw new FolderNotFoundException("The provided pathname did not pointed to a folder");
                }

                if (!folder.isFolder()) {
                        for (int i = 0; i <= pathname.length - 2; i++) {
                                newPathname.append(pathname[i]).append("\\\\");
                        }
                        return newPathname.toString();
                }

                return this.pathname;
        }

        /**
         * <p>
         * A method that searches for the first folder in the pathname provided
         * and retrieves it's pathname
         * </p>
         *
         * @return A string containing the pathname for the first folder in the
         *         pathname.
         *
         * @throws FolderNotFoundException if the pathname does not provide any folders.
         *
         * @since 1.1.0
         */
        public String getFirstFolderPathname() {
                Folder folder = new Folder(pathname);
                String[] pathname = folder.pathname.split("\\\\");

                if (!folder.isFolder() && pathname.length < 1) {
                        throw new FolderNotFoundException("The provided pathname did not pointed to a folder");
                }

                return pathname[0];
        }

        /**
         * <p>
         * A method that searches for the defined number of the folder in the pathname
         * provided
         * and retrieves it's pathname
         * </p>
         *
         * <p>
         * The index should be treated as starting on the 0
         * </p>
         *
         * <p>
         * Ex: 0 is the first position, 1 is the second and so forth
         * </p>
         *
         * @return A string containing the pathname for the indicated folder in the
         *         pathname.
         *
         * @throws FolderNotFoundException if the pathname does not provide any folders.
         *
         * @since 1.1.0
         */
        public String getFolderInIndexPathname(int index) {
                Folder folder = new Folder(pathname);
                String[] pathname = folder.pathname.split("\\\\");
                StringBuilder newPathname = new StringBuilder();

                if (!folder.isFolder() && pathname.length < 1) {
                       throw new FolderNotFoundException("The provided pathname did not pointed to a folder");
                }

                for (int i = 0; i <= index; i++) {
                        newPathname.append("\\\\").append(pathname[i]);
                }
                return newPathname.toString();
        }

        /**
         * <p>
         * A method that uses the pathname to generate a roughly equal pathname,
         * only changing the most upper folder name with a discriminator.
         * </p>
         * 
         * @return A string containing the pathname with the most upper folder
         *         discriminated.
         * 
         * @since 1.1.0
         */
        public String getFirstAvailablePathnameDiscriminator() {
                Folder folder = new Folder(pathname);

                for (int i = 1;; i++) {
                        folder = new Folder(pathname + "(" + i + ")");

                        if (!folder.exists()) {
                                return folder.pathname;
                        }
                }
        }

        /**
         * <p>A method responsible for getting all the pathname without
         * the directory specified in the index parameter.</p>
         *
         * @param index An integer that indicates which directory should be skipped.
         *
         * @return A String containing the pathname to the specified folder without the
         * indicated directory.
         *
         * @since 1.1.0
         *
         * @author EduardoStarZ
         *
         * */
        public String getAllPathnameWithException(int index) {
                String[] splitter = pathname.split("\\\\");
                StringBuilder newPathname = new StringBuilder();

                if (splitter.length - 1 < index) {
                        throw new ArrayIndexOutOfBoundsException(index);
                }

                for (int i = 0; i <= splitter.length - 1; i++) {
                        if (i != index) {
                                newPathname.append(splitter[i]).append("\\\\");
                        }
                }

                return newPathname.toString();
        }

        /**
         * <p>
         * A method that copies the folder, and adds a discriminator to it, and copies
         * the other folders in the pathname normally.
         * </p>
         * 
         * @since 1.1.0
         */
        public String copy() {
                Folder folder = new Folder(pathname);

                Folder copyLocation = new Folder(getFirstAvailablePathnameDiscriminator());

                copyLocation.create();

                return copyLocation.pathname;
        }

        /**
         * <p>
         * A method that copies the folder, and adds a discriminator to it, and copies
         * the other folders in the pathname normally.
         * </p>
         * 
         * @since 1.1.0
         */
        public void copy(String location) {
                Folder folder = new Folder(pathname);

                Folder copyLocation = new Folder(location);
                copyLocation = new Folder(copyLocation.pathname + folder.getFirstFolderPathname());

                if (copyLocation.exists()) {

                        copyLocation = new Folder(getFirstAvailablePathnameDiscriminator());

                        copyLocation.create();
                        return;
                }

                copyLocation.create();
        }

        public void copyAll() {
                Folder folder = new Folder(pathname);

                String location = folder.copy();
                replicate(pathname, location + getAllPathnameWithException(0));
        }

        private void replicate(String pathname, String location) {
                Folder folder = new Folder(pathname);
                Object[] Folders = folder.foldersInFolder();

                for (int i = 0; i <= Folders.length - 1; i++) {
                        Folder folderCopy = new Folder(Folders[i].toString());
                        folderCopy.copy(location);

                        replicateFiles(location);

                        replicate(Folders[i].toString(), location);
                }

        }

        private void replicateFiles(String location) {
                Folder folder = new Folder(pathname);
                Object[] files = folder.filesInFolder();

                for (int i = 0; i <= files.length - 1; i++) {
                        Files file = new Files(files[i].toString());

                        file.copy(location);
                }
        }
}