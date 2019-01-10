package top.hellonine.novel.novelapi.util;

import java.io.*;
import java.net.*;
import java.util.Map;

/**
 * User: Nine
 * Date: 2019/1/9
 * Time: 下午3:37
 */


public class CurlUtil {


    public static String get(String url) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) makeConnection(url, "GET");

        return readResponse(connection);

    }

    public static String get(String url, Map<String, Object> paramters) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) makeConnection(url, "GET");

        connection.setDoOutput(true);
        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.writeBytes(paramterStringBuilder(paramters));
        outputStream.flush();
        outputStream.close();

        return readResponse(connection);
    }

    public static String post(String url) {

        return url;
    }

    private static URLConnection makeConnection(String url, String method) throws IOException {
        URL url1 = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
        connection.setRequestMethod(method);
        return connection;
    }

    private static String paramterStringBuilder(Map<String, Object> paramters) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Object> entry : paramters.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0 ? resultString.substring(0, resultString.length() - 1) : resultString;
    }

    private static String readResponse(HttpURLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();
        return content.toString();
    }

}
