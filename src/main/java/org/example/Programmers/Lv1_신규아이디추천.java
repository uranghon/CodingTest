package org.example.Programmers;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lv1_신규아이디추천 {
    static String new_id = "...!@BaT#*..y.abcdefghijklm";

    public static void main(String[] args) {
        Mine mine = new Mine();
        mine.printId();

        Others others = new Others();
        others.printId();
    }
    static class Mine {
        void printId() {
            StringBuilder new_id_sb = new StringBuilder(new_id.toLowerCase(Locale.ROOT));

            Pattern p = Pattern.compile("[\\w-_.]+"); // 속하지 않는거 거름
            Pattern p2 = Pattern.compile("[.]{2,}|(\\w|\\-|\\_|(?<!\\.)\\.(?!\\.))+");
            Pattern p3 = Pattern.compile("\\.\\.+");
            Pattern p4 = Pattern.compile("(\\w|\\_|\\-|(?<!^)\\.(?!$))+");
            Matcher m = p.matcher(new_id_sb.toString());

            new_id_sb.setLength(0);

            while (m.find()) {
                if (m.group().isEmpty()) continue;

                new_id_sb.append(m.group());
            }

            Matcher m2 = p2.matcher(new_id_sb.toString());
            new_id_sb.setLength(0);

            while (m2.find()) {
                if (m2.group().isEmpty()) continue;

                Matcher m3 = p3.matcher(m2.group());

                if (m3.matches()) {
                    new_id_sb.append(".");
                } else {
                    new_id_sb.append(m2.group());
                }
            }

            Matcher m4 = p4.matcher(new_id_sb.toString());
            new_id_sb.setLength(0);

            while (m4.find()) {
                if (m4.group().isEmpty()) continue;

                new_id_sb.append(m4.group());
            }

            if (new_id_sb.length() == 0) {
                new_id_sb.append("a");
            }

            if (new_id_sb.length() >= 16) {
                new_id_sb.delete(15, new_id_sb.length());
                if (new_id_sb.charAt(14) == '.') new_id_sb.delete(14, 15);
            }

            if (new_id_sb.length() <= 2) {
                while (true) {
                    new_id_sb.append(new_id_sb.charAt(new_id_sb.length() - 1));
                    if (new_id_sb.length() == 3) break;
                }
            }

            System.out.println(new_id_sb);
        }
    }

    static class Others {
         void printId() {
            String answer = "";
            String temp = new_id.toLowerCase();

            temp = temp.replaceAll("[^-_.a-z0-9]", "");
//            System.out.println(temp);
            temp = temp.replaceAll("[.]{2,}", "."); // 이야 이게 있었네
            temp = temp.replaceAll("^[.]|[.]$", ""); // 이야 이런 방식이?
//            System.out.println(temp.length());
            if (temp.equals(""))
                temp += "a";
            if (temp.length() >= 16) {
                temp = temp.substring(0, 15);
                temp = temp.replaceAll("^[.]|[.]$", "");
            }
            if (temp.length() <= 2)
                while (temp.length() < 3)
                    temp += temp.charAt(temp.length() - 1);

            answer = temp;

            System.out.println(answer);
        }
    }
}
