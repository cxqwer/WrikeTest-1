package Data;

// TODO: 22.09.2019 Я тоже везде пихал енамы, пока надо мной ржать не стали...Глянь на класс Data и на PagesData где код более понятен?
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
