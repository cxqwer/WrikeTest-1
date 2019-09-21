package Data;

public enum PagesData {
    INDEX_HTML_URL("https://www.wrike.com/"),
    RESEND_TITLE("Thank you for choosing Wrike!"),
    TEXT_COMMENT(" Some text");

    private String value;

    PagesData(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
