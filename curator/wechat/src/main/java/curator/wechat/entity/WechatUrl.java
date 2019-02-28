package curator.wechat.entity;

public final class WechatUrl {

//    private static final String appid = "wx7bc337ff8231f2c0";
//    private static final String secret = "d995eef46ccb1f5d691d89104e1132da";

    private static final String appid = "wx6167b98b8b4f1a86";
    private static final String secret = "a053132da34a011f7cc5eefc083d8205";


    private static final String GET_USER_INFO = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";
    private static final String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    public static String getUserInfo(String accessToken, String openid) {
        return String.format(GET_USER_INFO, accessToken, openid);
    }

    public static String getAccessToken() {
        return String.format(GET_ACCESS_TOKEN, appid, secret);
    }
}
