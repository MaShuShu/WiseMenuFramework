package io.github.gefangshuai.server.core.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by gefangshuai on 2015/11/30.
 */
public class QueryUtils {
    public static String getLike(String key){
        if (StringUtils.isBlank(key))
            key = "";
        return "%" + key + "%";
    }

    public static String getLeftLike(String key) {
        if (StringUtils.isBlank(key))
            key = "";
        return "%" + key;
    }

    public static String getRight(String key){
        if (StringUtils.isBlank(key))
            key = "";
        return key + "%";
    }
}
