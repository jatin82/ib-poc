package com.ib.poc.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ib.poc.model.Message;

public class Utils {

	
	public static List<Message> readFromFile(File file) throws IOException{
		List<Message> messages = new ArrayList<>();
		FileScanner scanner = new FileScanner(file);
		scanner.next();
		String row = scanner.next();
		while(row!="") {
			List<String> token = new ArrayList(Arrays.asList(row.split(Constants.splitByCommaRegex)));
			Message message = new Message();
			message.setId(Long.parseLong(token.get(0).replaceAll("\"", "")));
			message.setMessage(token.get(1).replaceAll("\"", ""));
			message.setTruth(token.get(3).replaceAll("\"", ""));
			message.setCube(token.get(4).replaceAll("\"", ""));
			message.setGoogle(token.get(5).replaceAll("\"", ""));
			message.setGoogleSpam(Double.parseDouble(token.get(6).replaceAll("\"", "")));
			message.setGoogleNotSpam(Double.parseDouble(token.get(7).replaceAll("\"", "")));
			message.setIbm(token.get(8).replaceAll("\"", ""));
			message.setIbmSpam(Double.parseDouble(token.get(9).replaceAll("\"", "")));
			message.setIbmNotSpam(Double.parseDouble(token.get(10).replaceAll("\"", "")));
			messages.add(message);
			row = scanner.next();
		}
		return messages;
	}
}
