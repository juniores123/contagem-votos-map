package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> urnas = new LinkedHashMap<>();
		
		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
			
			String line = br.readLine();

			while (line != null) {
				
				String[] fields = line.split(",");

				String name = fields[0];

				int count = Integer.parseInt(fields[1]);

				if (urnas.containsKey(name)) {
					int votesSoFar = urnas.get(name);
					urnas.put(name, count + votesSoFar);
				}
				else {
					urnas.put(name, count);
				}
				line = br.readLine();
			}

			for (String key : urnas.keySet()) {
				System.out.println(key + ": " + urnas.get(key));
			}
			
		} catch (Exception  e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}
}
