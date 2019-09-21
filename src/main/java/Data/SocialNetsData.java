package Data;

public enum SocialNetsData {
    TWITTER("https://twitter.com/wrike", "footer-icons.symbol.svg?v2#twitter"),
    FACEBOOK("https://www.facebook.com/Wrike", "footer-icons.symbol.svg?v2#facebook"),
    LINKEDIN("https://www.linkedin.com/company/wrike", "footer-icons.symbol.svg?v2#linkedin"),
    PINTEREST("https://www.pinterest.com/wriketeam/", "footer-icons.symbol.svg?v2#pinterest"),
    YOUTUBE("https://www.youtube.com/user/WrikeTeam", "footer-icons.symbol.svg?v2#youtube"),
    INSTAGRAM("https://www.instagram.com/wriketeam/", "footer-icons.symbol.svg?v2#instagram");

    public String url;
    public String icon;

    SocialNetsData(String url, String icon){
        this.url = url;
        this.icon = icon;
    }
}
