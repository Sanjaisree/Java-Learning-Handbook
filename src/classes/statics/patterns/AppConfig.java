package classes.statics.patterns;

public class AppConfig {
    private static AppConfig instance;

    private AppConfig() {
        System.out.println("AppConfig instance created");
    }

    public static AppConfig getInstance() {

        if (instance == null) {
            instance = new AppConfig();
        }

        return instance;
    }

    public void showConfig() {
        System.out.println("App configuration loaded");
    }

    public static void main(String[] args) {

        AppConfig c1 = AppConfig.getInstance();
        AppConfig c2 = AppConfig.getInstance();

        c1.showConfig();
        c2.showConfig();

        System.out.println(c1 == c2);
    }
}
