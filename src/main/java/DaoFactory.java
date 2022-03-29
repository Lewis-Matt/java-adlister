public class DaoFactory {
    private static Ads adsDao;

    // Single method that provides access to ads DAO

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }
}
