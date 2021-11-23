
package nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Optional;

public class DirMonitor {
	private String str;
	public DirMonitor(String str) throws IOException {
		Path p = Paths.get(str);
		System.out.println("Directory:"+ Files.isDirectory(p));
		System.out.println("Readable:"+ Files.isReadable(p));
	}
	public static void testDirectoryStream(String str) throws IOException {
		Path Path = Paths.get(str);
		 try (DirectoryStream<Path> stream = Files.newDirectoryStream(Path)) {
	           for (Path entry : stream) {
	               System.out.println(entry);
	           }
	       }
	}
	public void sizeOfFiles(String str) {
		Path Path = Paths.get(str);
		try {
			long size = Files.size(Path);
			System.out.println("La somme des octets dans fichier est:");
			System.out.println(size);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Path mostRecent(String str) throws IOException {
	    Path Path = Paths.get(str);
	    if (Files.isDirectory(Path)) {
	        Optional<Path> opPath = Files.list(Path)
	          .filter(p -> !Files.isDirectory(p))
	          .sorted((p1, p2)-> Long.valueOf(p2.toFile().lastModified())
	            .compareTo(p1.toFile().lastModified()))
	          .findFirst();

	        if (opPath.isPresent()){
	            return opPath.get();
	        }
	    }

	    return null;
	}
	}
					
