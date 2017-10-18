package TD5;

import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;


public class DirMonitor {
	private final Path dir;
	
	public DirMonitor(Path dir) throws IOException {
		if(! Files.isReadable(dir) || !Files.isDirectory(dir) ) {
			throw new IOException();
		}
		this.dir = dir;
	
	}
	
	public void displayFiles(int minSize) throws IOException {
		
		
		
		for(Path path : Files.newDirectoryStream(dir, new Filter<Path>() {
			
			
			@Override
			public boolean accept(Path entry) throws IOException{
				return Files.size(entry) >= minSize;
			}
			
			
		})){
			System.out.println(path);
		};
		/*car iterable sinon :*/
		/*Iterator<Path> = Files.newDirectoryStraeam(dir)
		 * while(it.hasnext()))
		 * 	path p = it.next();
		 *  syso
		 */
		
		
		
	}
		
	public long sizeOfFiles() throws IOException {
		long somme = 0;
		for(Path path : Files.newDirectoryStream(dir)){
			if(!Files.isDirectory(path)) {
				somme += Files.size(path);
			}
			
		};
		return somme;
	}
	
	public Path mostRecent() throws IOException {
		FileTime mostRecent = FileTime.fromMillis(0);
		Path mostRecentPath = null; 
		
		for(Path path : Files.newDirectoryStream(dir)){
			if(Files.getLastModifiedTime(path).compareTo(mostRecent) > 0 ) {
				mostRecent = Files.getLastModifiedTime(path);
				mostRecentPath = path;
			}
			
		};
		
		return mostRecentPath;
	}
	
	public static void main(String[] args) {
		try {
			DirMonitor dm = new DirMonitor(Paths.get("."));
			dm.displayFiles(10);
			System.out.println(dm.sizeOfFiles());
			System.out.println(dm.mostRecent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
