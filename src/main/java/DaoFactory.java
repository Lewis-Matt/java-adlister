public class DaoFactory {
    private static Ads adsDao;
// When you create an instance of MySQLAdsDao, create an instance of your Config class to pass to the MySQLAdsDao constructor
    static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }
}
