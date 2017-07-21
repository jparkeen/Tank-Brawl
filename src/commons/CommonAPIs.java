package commons;

import java.io.File;
import java.io.FileNotFoundException;

public class CommonAPIs {

	public static void validateFileExists(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		if (!file.exists()) {
			throw new FileNotFoundException("Map file not found!");
		}
	}

}
