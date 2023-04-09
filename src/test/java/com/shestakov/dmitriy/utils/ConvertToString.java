package com.shestakov.dmitriy.utils;

public class ConvertToString {
    public static String convertIntToString(int price){
        String stringNew = String.valueOf(price);
        char c = ' ';
        StringBuilder sb = new StringBuilder();
        char[] charArrayOfStringNew = stringNew.toCharArray();
        for(int ch = 0 ; ch < charArrayOfStringNew.length; ch++){
            if(ch - (charArrayOfStringNew.length-3) == 0)
                sb.append(c).append(charArrayOfStringNew[ch]);
            else
                sb.append(charArrayOfStringNew[ch]);
        }
        return sb.toString();
    }
}
