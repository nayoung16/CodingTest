import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        Set<String> people = new HashSet<>();
        for (int i = 0; i < n; i++) {
            people.add(br.readLine());
        }

        int number;
        if (game.equals("Y")) number = 1;
        else if (game.equals("F")) number = 2;
        else number = 3; // "O"

        System.out.println(people.size() / number);
    }
}