package proteomics.proteo;

public class Mgf {
    private String pepmass;
    private String rtinseconds;

    public Mgf (String pepmass, String rtinseconds) {
        this.pepmass = pepmass;
        this.rtinseconds = rtinseconds;
    }

    public String getPepmass() {
        return pepmass;
    }

    public String getRtinSeconds() {
        return rtinseconds;
    }
};
