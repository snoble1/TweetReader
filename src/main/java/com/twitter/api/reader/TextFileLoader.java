package com.twitter.api.reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TextFileLoader {
	public static CharSequence read(BufferedReader reader, boolean closeReader)
			throws IOException {
		StringBuffer buffer = new StringBuffer();
		String line = null;
		
		while ((line = reader.readLine()) != null) {
			buffer.append(line).append("\n");
		}
		
		return buffer;
	}

	public static CharSequence read(String filename, boolean isExternal)
			throws IOException {
		return read(load(filename, isExternal), true);
	}

	public static BufferedReader load(String filename, boolean isExternal)
			throws IOException {
		if (isExternal) {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(filename);

			// Always wrap FileReader in BufferedReader.
			return new BufferedReader(fileReader);
		} else {
			ClassLoader loader = TextFileLoader.class.getClassLoader();
			InputStream stream = loader.getResourceAsStream(filename);

			return new BufferedReader(new InputStreamReader(stream));
		}
	}
}