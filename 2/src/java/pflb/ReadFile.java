package pflb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	BufferedReader reader;
	String str;

	public ReadFile() {
		this.str = null;
		this.reader = null;
	}

	public void addFile(String argv, ArrayList<String> arrayList) throws IOException {
		reader = new BufferedReader(new FileReader(argv));
		while ((str = reader.readLine()) != null) {
			arrayList.add(str);
		}
		reader.close();
	}
}
