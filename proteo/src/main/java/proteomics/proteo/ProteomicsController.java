package proteomics.proteo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;


@JsonFormat
@RestController
@RequestMapping(value = "/Proteomics")
public class ProteomicsController {
    @Autowired
    private ProteomicsServices proteomicsServices;

    @PostMapping(value = {"/", ""})
    public ArrayList<Mgf> parseMgf(@RequestBody String file_path) throws IOException {
        ArrayList<String> pepmasses = proteomicsServices.getPepmass(file_path);
        ArrayList<String> rtinseconds = proteomicsServices.getRtinSeconds(file_path);
        ArrayList<Mgf> result = new ArrayList<Mgf>();
        for(int i = 0; i < pepmasses.size(); i++) {
            result.add(new Mgf(pepmasses.get(i), rtinseconds.get(i)));
        }
        return result;
    }
}
