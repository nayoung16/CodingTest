import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String explode = br.readLine();
        int l = explode.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));

            // sb의 끝부분이 폭발 문자열과 같으면 제거
            if (sb.length() >= l) {
                boolean match = true;
                for (int j = 0; j < l; j++) {
                    if (sb.charAt(sb.length() - l + j) != explode.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    sb.setLength(sb.length() - l);
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}