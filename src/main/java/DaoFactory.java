public class DaoFactory {
    private static Ads adsDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
//            switched out ListAdsDao for MySQLAdsDao
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }
}
