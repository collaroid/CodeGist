package com.collaroid.test;


public class KMPFind {
    
    public static void main(String[] args) {
        System.out.println(indexOf("aaaaaaaabbbbccccc", "ab"));
    }
    
    private static int indexOf(String s, String t){
        if(s == null || t == null || "".equals(s) || "".equals(t)) {
            return -1;
        }
        if(t.length() > s.length()){
            return -1;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if(sc.length - i < tc.length){
                // left char length less than tc
                return -1;
            }
            int index = i;
            for (int j = 0; j < tc.length; j++) {
                if (sc[i] == tc[j]) {
                    if (j == tc.length - 1) {
                        //get the right index
                        return index;
                    }
                    i++;
                } else {
                    break;
                }
            }
            i = index;
        }
        return -1;
    }

}
