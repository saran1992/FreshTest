package com.hellofresh.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import com.google.common.base.Strings;

public class TestDataUtils {
	
	public static Map<String, String> initData(List<String> fileName){

		Properties prop = new Properties();
		InputStream input = null;
		Map<String, String> dataTable = new HashMap<String, String>();
		String env;
		fileName.add("global");

		if (Strings.isNullOrEmpty(System.getProperty("environment"))) {
			env = "production";
		} else {
			env = System.getProperty("environment");
		}
		for (String fn : fileName) {
			try {
				input = new FileInputStream("TestData/" + env + "/" + fn + ".properties");
				prop.load(input);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
			dataTable.putAll(prop.entrySet().stream()
					.collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString())));
		}

		return dataTable;

	}

}
