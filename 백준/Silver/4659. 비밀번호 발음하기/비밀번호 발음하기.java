import java.io.*;

public class Main {

    public static boolean ifVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("end")) break;
            boolean flag1 = false;
            boolean flag2 = true;
            boolean flag3 = true;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                // 조건 1
                boolean isVowel = ifVowel(c);
                if (isVowel) flag1 = true;


                // 조건 2
                if (i < str.length() - 2) {
                    boolean isVowel2 = ifVowel(str.charAt(i + 1));
                    boolean isVowel3 = ifVowel(str.charAt(i + 2));

                    // 모음 3개 연속 또는 자음 3개 연속이면 불가
                    if ((isVowel && isVowel2 && isVowel3) || (!isVowel && !isVowel2 && !isVowel3)) {
                        flag2 = false;
                        break;
                    }
                }

                if (i < str.length() - 1) {
                    char c2 = str.charAt(i+1);
                    if (c == c2) {
                        if (c == 'e' || c == 'o') continue;
                        else {
                            flag3 = false;
                            break;
                        }
                    }
                }

            }

            if (flag1 && flag2 && flag3) {
                sb.append("<").append(str).append("> is acceptable.\n");
            }
            else sb.append("<").append(str).append("> is not acceptable.\n");
        }
        System.out.println(sb);
    }
}