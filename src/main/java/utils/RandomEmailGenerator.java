package utils;

// TODO: 22.09.2019 Где комментарии? Што делает, как делает, нахуя делает? Тут же слоржная логика, напиши комментарии
public class RandomEmailGenerator {
    private static final String MASK = "wpt@wriketask.qaa";

    public static String getRandomEmail() {
        int n = (int) (Math.random() * 5) + 5;

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString() + MASK;
    }
}
