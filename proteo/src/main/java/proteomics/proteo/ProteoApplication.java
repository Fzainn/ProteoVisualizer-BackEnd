package proteomics.proteo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;

@Service
@Repository
@SpringBootApplication
public class ProteoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ProteoApplication.class, args);

		// File path is passed as parameter
		File file = new File("C:\\Users\\compu\\Desktop\\NASH.mgf");

		// Creating an object of BufferedReader class
		BufferedReader br = new BufferedReader(new FileReader(file));
		// Declaring a string variable
		String st;
		// Condition holds true till
		// there is character in a string
		// Print the string
		ArrayList<String> pepmasses = new ArrayList<String>();
		ArrayList<String> rtin_seconds = new ArrayList<String>();

		while ((st = br.readLine()) != null) {
			String pepmass = "PEPMASS";
			String rtinseconds = "RTINSECONDS";


			if(st.contains(pepmass)) {
				String pepmass_value = "";
				for (int i = 8; i < st.length(); i++) {
					pepmass_value += st.charAt(i);
				}
				System.out.println("PEPMASS-VALUE: " + pepmass_value);
				pepmasses.add(pepmass_value);
			}

			if (st.contains(rtinseconds)) {
				String rtinseconds_value = "";
				for (int i = 12; i < st.length(); i++) {
					rtinseconds_value += st.charAt(i);
				}
				System.out.println("RTINSECONDS-VALUE: " + rtinseconds_value);
				rtin_seconds.add(rtinseconds_value);
			}

		}

		System.out.println("PEPMASSES-SIZE: " + pepmasses.size());
		System.out.println("RTINSECONDS-SIZE: " + rtin_seconds.size());

		// for (int i = 0; i < pepmasses.size(); i++) {
		// 	System.out.println("PEPMASS: " + pepmasses.get(i) + " - RTINSECONDS: " + retins_seconds.get(i);
		// }
	}

	};
