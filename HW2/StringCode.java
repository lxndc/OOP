import java.util.*;

public class StringCode {
    public static String blowup(String str) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int n = c - '0';
                if(i+1 < str.length()) {
                    char ch = str.charAt(i+1);
                    for (int j = 0; j<n; j++) {
                        s.append(ch);
                    }
                }
            }
            else {
                s.append(c);
            }
        }
        return s.toString();
    }

    public static int maxRun(String str) {
        int maxx = Integer.MIN_VALUE;
        for (int i = 0; i<str.length(); i++) {
            char c = str.charAt(i);
            int dem = 1;
            for (int j = i+1; j<str.length(); j++) {
                if(c == str.charAt(j)) {
                    dem++;
                }
                else break;
            }
            if(dem>maxx) {
                maxx = dem;
            }

        }
        return maxx;
    }

    public static boolean stringIntersect(String a, String b, int len) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i<a.length()-len+1; i++) {
            set.add(a.substring(i, i+len));
        }
        for(int i = 0; i<b.length()-len+1; i++) {
            if(set.contains(b.substring(i, i+len))) {
                return true;
            }

        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(blowup("a3j1op"));
        System.out.println(blowup("12x"));
        System.out.println(maxRun("xxxyyz"));
        System.out.println(maxRun("abc"));
        System.out.println(stringIntersect("abcdef", "defghi", 3));
        System.out.println(stringIntersect("abcdef", "efghit", 3));
    }
}
