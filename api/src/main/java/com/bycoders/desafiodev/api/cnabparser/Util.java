package com.bycoders.desafiodev.api.cnabparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Util {
	
	private Util() {}
	
	public static String fromInputStreamToString(InputStream input) throws IOException {

		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
		}
		return sb.toString();
	}
	
	public static Set<String> fromInputStream(InputStream input) throws IOException {
		Set<String> lines = new HashSet<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		}
		return lines;
	}
	
}
