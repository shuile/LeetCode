package cn.shui.codetop.client;

import java.util.regex.Pattern;

/**
 * Created by chenyiting on 2022/4/8
 * 验证IP地址
 */
public class L468 {

    private static final String NEITHER = "Neither";
    private static final String IPV4 = "IPv4";
    private static final String IPV6 = "IPv6";

    public String validIPAddress(String queryIP) {
        if (!isValidIpAddress(queryIP)) {
            return NEITHER;
        }
        boolean hasDot = queryIP.contains(".");
        boolean hasColon = queryIP.contains(":");
        if (hasDot && hasColon) {
            return NEITHER;
        }
        if (hasDot) {
            return isIpv4(queryIP) ? IPV4 : NEITHER;
        }
        return isIpv6(queryIP) ? IPV6 : NEITHER;
    }

    private boolean isIpv4(String ip) {
        if (ip.endsWith(".")) {
            return false;
        }
        String[] splits = ip.split("\\.");
        if (splits.length != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            int len = splits[i].length();
            if (len == 0) {
                return false;
            }
            char ch = splits[i].charAt(0);
            if (len == 1) {
                if (!isDigit(ch)) {
                    return false;
                }
                continue;
            }
            if (ch == '0') {
                return false;
            }
            int x = ch - '0';
            for (int j = 1; j < len; j++) {
                ch = splits[i].charAt(j);
                if (!isDigit(ch)) {
                    return false;
                }
                x = x * 10 + ch - '0';
            }
            if (x > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean isIpv6(String ip) {
        if (ip.endsWith(":")) {
            return false;
        }
        String[] splits = ip.split("\\.");
        if (splits.length != 8) {
            return false;
        }
        for (int i = 0; i < 8; i++) {
            int len = splits[i].length();
            if (len == 0 || len > 4) {
                return false;
            }
            for (int j = 0; j < 4; j++) {
                char ch = splits[i].charAt(j);
                if (!isValidLetter(ch) && !isDigit(ch)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidIpAddress(String ip) {
        if (ip == null || ip.length() == 0) {
            return false;
        }
        for (int i = 0; i < ip.length(); i++) {
            char ch = ip.charAt(i);
            if (ch != '.' && ch != ':' && !isValidLetter(ch) && ! isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidLetter(char ch) {
        return (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F');
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private static final String CHUNK_IPV4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    private static final Pattern PATTERN_IPV4 = Pattern.compile("^(" + CHUNK_IPV4 + "\\.){3}" + CHUNK_IPV4 + "$");
    private static final String CHUNK_IPV6 = "([0-9a-fA-F]{1,4})";
    private static final Pattern PATTERN_IPV6 = Pattern.compile("^(" + CHUNK_IPV6 + "\\:){7}" + CHUNK_IPV6 + "$");

    // 正则表达式
    public String validIPAddress2(String queryIP) {
        if (queryIP.contains(".")) {
            return PATTERN_IPV4.matcher(queryIP).matches() ? IPV4 : NEITHER;
        }
        if (queryIP.contains(":")) {
            return PATTERN_IPV6.matcher(queryIP).matches() ? IPV6 : NEITHER;
        }
        return NEITHER;
    }

    public static void main(String[] args) {
        L468 test = new L468();
        System.out.println(test.validIPAddress2("192.0.0.1"));;
    }
}
