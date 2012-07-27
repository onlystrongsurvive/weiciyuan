package org.qii.weiciyuan.support.http;


import android.content.Context;
import android.text.TextUtils;
import org.qii.weiciyuan.R;
import org.qii.weiciyuan.support.utils.GlobalContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * get the string meaning of those int value return from server
 */

public final class URLManager {
    private static final String URL_SINA_WEIBO = "https://api.weibo.com";
    private static final String URL_FORMAT = "http://%s%s";
    private static Properties properties = new Properties();

    private final static String getUrl(String name) {
        try {
            if (properties.isEmpty()) {
                Context context = GlobalContext.getInstance();
                InputStream inputStream = context.getResources().openRawResource(R.raw.url);
                properties.load(inputStream);
            }
        } catch (IOException ignored) {

        }

        return properties.get(name).toString();
    }


    public static String getRealUrl(String urlContent) {

        if (TextUtils.isEmpty(urlContent))
            return null;

        if (!urlContent.startsWith("/")) {
            urlContent = "/" + urlContent;
        }

        return String.format(URL_FORMAT, URL_SINA_WEIBO, urlContent);
    }
}
