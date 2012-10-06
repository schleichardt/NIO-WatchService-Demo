package info.schleichardt.demo10062012;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

/**
 * Watches a folder in the system specific temp directory. You may have to create the folder.
 *
 * Example console output:
 * <pre>{@code
 *ENTRY_CREATE: /tmp/watchme/xyz.txt
 *ENTRY_MODIFY: /tmp/watchme/xyz.txt
 *ENTRY_DELETE: /tmp/watchme/xyz.txt
 * }</pre>
 *
 * Use "gradle run" in the project root to start the app.
 * Use "gradle javadoc" to create the javadocs.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        final String pathToWatchedFolder = System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "watchme";
        try {
            System.out.println("Watching folder " + pathToWatchedFolder + ".");
            WatchDir.main(new String[]{"-r", pathToWatchedFolder});
        } catch (final NoSuchFileException e) {
            System.err.println(pathToWatchedFolder + " does not exist. Create it before watching.");
        }
    }
}
