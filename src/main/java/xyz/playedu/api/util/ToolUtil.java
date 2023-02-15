package xyz.playedu.api.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class ToolUtil {

    /**
     * 制作UUID
     *
     * @return String
     * @author fzr
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }

    /**
     * 返回随机字符串
     *
     * @param length 要生成的长度
     * @return String
     * @author fzr
     */
    public static String randomString(int length) {
        Random random = new Random();
        StringBuilder stringBuffer = new StringBuilder();
        String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int strLength = str.length();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(strLength);
            stringBuffer.append(str.charAt(index));
        }
        return stringBuffer.toString();
    }

    /**
     * 返回随机数字字符串
     *
     * @param length 要生成的长度
     * @return String
     * @author fzr
     */
    public static String randomInt(int length) {
        Random random = new Random();
        StringBuilder stringBuffer = new StringBuilder();
        String str = "0123456789";
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(10);
            stringBuffer.append(str.charAt(index));
        }
        return stringBuffer.toString();
    }

    /**
     * 转换存储单位: KB MB GB TB
     *
     * @return String
     * @author fzr
     */
    public static String storageUnit(Long size) {
        if (size == null) {
            return "0B";
        }
        if (size < 1024) {
            return size + "B";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            return size + "KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            size = size * 100;
            return (size / 100) + "." + (size % 100) + "MB";
        } else {
            size = size * 100 / 1024;
            return (size / 100) + "." + (size % 100) + "GB";
        }
    }

    /**
     * 下载文件
     *
     * @param urlString (文件网址)
     * @param savePath  (保存路径,如: /www/uploads)
     * @param filename  (保存名称,如: aa.png)
     * @throws IOException 异常
     * @author fzr
     */
    public static void download(String urlString, String savePath, String filename) throws IOException {
        URL url = new URL(urlString);
        URLConnection con = url.openConnection();
        con.setConnectTimeout(20 * 1000);
        File sf = new File(savePath);
        if (!sf.exists()) {
            if (sf.mkdirs()) {
                throw new IOException("创建目录失败");
            }
        }
        try (InputStream in = con.getInputStream(); OutputStream out = new FileOutputStream(sf.getPath() + "\\" + filename)) {
            byte[] buff = new byte[1024];
            int n;
            while ((n = in.read(buff)) >= 0) {
                out.write(buff, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * JSON转 Map<String, String>
     *
     * @param json 对象
     * @return Map<String, String>
     * @author fzr
     */
    public static Map<String, String> jsonToMap(String json) {
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        return JSON.parseObject(json, type);
    }

    /**
     * JSON转 Map<String, Object>
     *
     * @param json 对象
     * @return Map<String, String>
     * @author fzr
     */
    public static Map<String, Object> jsonToMapAsObj(String json) {
        Type type = new TypeToken<Map<String, Object>>() {
        }.getType();
        return JSON.parseObject(json, type);
    }

    /**
     * JSON转Map<String, String>
     *
     * @param object 对象
     * @return Map<String, String>
     * @author fzr
     */
    public static Map<String, String> objectToMap(Object object) {
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        return JSON.parseObject(JSONObject.toJSONString(object), type);
    }

    /**
     * 对象类型Map合并
     *
     * @param map 对象
     * @return Object
     * @author fzr
     */
    public static Map<String, Object> mergeMapByObj(Map<String, Object> map, Map<String, Object> map1) {
        HashMap<String, Object> map2 = new HashMap<>();
        map2.putAll(map);
        map2.putAll(map1);
        return map2;
    }

    /**
     * 字符串类型Map合并
     *
     * @param map 对象
     * @return Object
     * @author fzr
     */
    public static Map<String, String> mergeMapByStr(Map<String, String> map, Map<String, String> map1) {
        HashMap<String, String> map2 = new HashMap<>();
        map2.putAll(map);
        map2.putAll(map1);
        return map2;
    }

}