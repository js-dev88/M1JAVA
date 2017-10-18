package TD5;

import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.Files;
import java.nio.file.Path;

public class SizeFilter2 implements Filter<Path>{
	private final int minSize;
	
	public SizeFilter2(int minSize) {
		this.minSize = minSize;
	}
	
	@Override
	public boolean accept(Path entry) throws IOException{
		return Files.size(entry) >= minSize;
	}

}
