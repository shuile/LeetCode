package cn.shui.order.add_binary;

public class Solution {

    public static void main(String[] args) {
        String a = "101111";
        String b = "10";
        System.out.println(addBinary(a, b));
    }

    //
    public static String addBinary(String a, String b) {
        String tmp = "";
        String result = "";
        if (a == null || a.equals("")) {
            return b;
        }
        if (b == null || b.equals("a")) {
            return a;
        }
        int diff = Math.abs(a.length() - b.length());
        char ch;
        boolean needPlus = false;
        if (a.length() > b.length()) {
            for (int i = b.length() - 1; i >= 0; i--) {
                if (a.charAt(i + diff) == '1') {
                    if (b.charAt(i) == '1') {
                        if (needPlus) {
                            ch = '1';
                        } else {
                            ch = '0';
                        }
                        needPlus = true;
                    } else {
                        if (needPlus) {
                            ch = '0';
                        } else {
                            ch = '1';
                        }
                    }
                } else {
                    if (b.charAt(i) == '1') {
                        if (needPlus) {
                            ch = '0';
                        } else {
                            ch = '1';
                        }
                    } else {
                        if (needPlus) {
                            ch = '1';
                        } else {
                            ch = '0';
                        }
                        needPlus = false;
                    }
                }
                tmp += ch;
            }
            for (int i = diff - 1; i >= 0; i--) {
                if (a.charAt(i) == '1' && needPlus) {
                    ch = '0';
                } else {
                    if (needPlus) {
                        ch = '1';
                    } else {
                        ch = a.charAt(i);
                    }
                    needPlus = false;
                }
                tmp += ch;
            }
            if (needPlus) {
                tmp += '1';
            }
        } else {
            for (int i = a.length() - 1; i >= 0; i--) {
                if (b.charAt(i + diff) == '1') {
                    if (a.charAt(i) == '1') {
                        if (needPlus) {
                            ch = '1';
                        } else {
                            ch = '0';
                        }
                        needPlus = true;
                    } else {
                        if (needPlus) {
                            ch = '0';
                        } else {
                            ch = '1';
                        }
                    }
                } else {
                    if (a.charAt(i) == '1') {
                        if (needPlus) {
                            ch = '0';
                        } else {
                            ch = '1';
                        }
                    } else {
                        if (needPlus) {
                            ch = '1';
                        } else {
                            ch = '0';
                        }
                        needPlus = false;
                    }
                }
                tmp += ch;
            }
            for (int i = diff - 1; i >= 0; i--) {
                if (b.charAt(i) == '1' && needPlus) {
                    needPlus = true;
                    ch = '0';
                } else {
                    if (needPlus) {
                        ch = '1';
                    } else {
                        ch = b.charAt(i);
                    }
                    needPlus = false;
                }
                tmp += ch;
            }
            if (needPlus) {
                tmp += '1';
            }
        }
        for (int i = 0; i < tmp.length(); i++) {
            result += tmp.charAt(tmp.length() - i -1);
        }
        return result;
    }
}
