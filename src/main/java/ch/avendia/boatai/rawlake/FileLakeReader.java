package ch.avendia.boatai.rawlake;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileLakeReader {

	public FileLakeReader(String file) {

		try {
			LakeFactory.getInstance().parseJson(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public RawLake getRawLake(String name) {
		return LakeFactory.getInstance().getRawLake(name);
	}

}
