package JdbcDemo.utils;

public class JdbcConfig {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/book_store";
    private static final String user = "root";
    private static final String password = "1065508278";

    public JdbcConfig() {
    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}
