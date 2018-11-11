package com.omerbguclu.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	File file = new File("Fortunes.txt");
	private String[] fortune = new String[FileLength()];
	private Random random = new Random();

	public FileFortuneService() {
		try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
			int count = 0;
			while ((count < fortune.length) && ((fortune[count] = buffer.readLine()) != null)) {
				count++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getFortune() {
		int luck = random.nextInt(fortune.length);
		return fortune[luck];
	}

	public int FileLength() {
		int length = 0;
		try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
			
			while (buffer.readLine() != null) {
				length++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return length;
	}

}
