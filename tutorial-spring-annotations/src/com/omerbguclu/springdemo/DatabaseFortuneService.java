package com.omerbguclu.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	private String[] fortune = new String[fileLength()];
	private Random random = new Random();

	@Override
	public String getFortune() {
		int luck = random.nextInt(fortune.length);
		fortune = readingFromFile(fortune.length);
		return fortune[luck];
	}

	public String[] readingFromFile(int length) {
		String[] data = new String[length];
		try {
			File file = new File("Fortunes.txt");
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			int count = 0;
			while ((count < length) && ((data[count] = buffer.readLine()) != null)) {
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public int fileLength() {
		int length = 0;
		try {
			File file = new File("Fortunes.txt");
			BufferedReader buffer = new BufferedReader(new FileReader(file));

			while (buffer.readLine() != null) {
				length++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return length;
	}

}
