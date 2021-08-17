package emuntest;

public enum Company {
    ENJIE("恩杰股份", "002812"), NINGDE("宁德时代", "300750");

    private String companyName;
    private String code;

    Company(String companyName, String code) {
        this.companyName = companyName;
        this.code = code;
    }

    public String getName() {
        return this.companyName;
    }

    public String getCode() {
        return this.code;
    }
}
