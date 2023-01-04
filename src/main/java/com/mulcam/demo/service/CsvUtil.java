package com.mulcam.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {
	
	public List<List<String>> readCsv(String filename) {
		return readCsv(filename, ",", 0);
	}
	
	public List<List<String>> readCsv(String filename, String separator) {
		return readCsv(filename, separator, 0);
	}
	
	public List<List<String>> readCsv(String filename, String separator, int skipLine) {
		List<List<String>> csvList = new ArrayList<>();
		File csv = new File(filename);
		BufferedReader br = null;
		String line = "";
		int lineNo = 0;
		
		try {
			br = new BufferedReader(new FileReader(csv));
			while ((line = br.readLine()) != null) {
				// skipLine 동작이 행해져야 하는 경우에는 continue
				if (skipLine > lineNo++)
					continue;
				List<String> aLine = new ArrayList<>();
				String[] lineArray = line.split(separator);
				for (String s: lineArray)
					aLine.add(s);			// 한 줄의 데이터가 리스트로 만들어 짐
				csvList.add(aLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return csvList;
	}

}
