package com.test.gson;

public class StringTest {

    public static void main(final String[] args) {
        String str = "Sep 20, 2023, 10:03:41 PM";
        final String[] strAry = str.split(",");
        System.out.println("length : " + strAry[2].trim().length());
        System.out.println("CharAt0 :" + strAry[2].trim().charAt(0));
        final String temp = strAry[2].trim();
        if (strAry.length >= 2 && !"0".equals(String.valueOf(temp.charAt(0))) && temp.length() == 10) {
            strAry[2] = " 0" + strAry[2].trim();
        }
        str = String.join(",", strAry);
        System.out.println(str);
    }

}
