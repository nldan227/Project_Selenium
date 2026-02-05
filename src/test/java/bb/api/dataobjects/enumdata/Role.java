package bb.api.dataobjects.enumdata;

public enum Role {
    ADMIN ("admin"),
    AGENCY ("agency");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
