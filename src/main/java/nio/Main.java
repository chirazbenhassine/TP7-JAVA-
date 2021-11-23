package nio;

import java.io.IOException;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String str="C:/Users";
		DirMonitor Path= new DirMonitor(str);
		Path.testDirectoryStream(str);
		Path.sizeOfFiles(str);
		Path.mostRecent(str);
	}

}
