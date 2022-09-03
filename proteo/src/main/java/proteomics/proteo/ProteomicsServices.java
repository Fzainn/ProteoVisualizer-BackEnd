package proteomics.proteo;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


@Service
public class ProteomicsServices {
        public ArrayList<String> getPepmass(String file_path) throws IOException {
            ArrayList<String> pepmasses = new ArrayList<String>();
            File file = new File(file_path);
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\compu\\Desktop\\NASH.mgf"));
            String st;

            while ((st = br.readLine()) != null) {
                String pepmass = "PEPMASS";

                if(st.contains(pepmass)) {
                    String pepmass_value = "";
                    for (int i = 8; i < st.length(); i++) {
                        pepmass_value += st.charAt(i);
                    }
                    System.out.println("PEPMASS-VALUE: " + pepmass_value);
                    pepmasses.add(pepmass_value);
                }
            }
            return pepmasses;
        }

        public ArrayList<String> getRtinSeconds(String file_path) throws IOException {
            ArrayList<String> rtin_seconds = new ArrayList<String>();
            File file = new File(file_path);
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\compu\\Desktop\\NASH.mgf"));
            String st;

            while ((st = br.readLine()) != null) {
                String rtinseconds = "RTINSECONDS";


                if (st.contains(rtinseconds)) {
                    String rtinseconds_value = "";
                    for (int i = 12; i < st.length(); i++) {
                        rtinseconds_value += st.charAt(i);
                    }
                    System.out.println("RTINSECONDS-VALUE: " + rtinseconds_value);
                    rtin_seconds.add(rtinseconds_value);
                }
                ///return rtins_seconds;
            }
            return rtin_seconds;
        }

};
