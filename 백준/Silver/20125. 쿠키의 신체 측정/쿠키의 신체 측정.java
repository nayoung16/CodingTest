import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        char[][] g = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                g[i][j] = line.charAt(j);
            }
        }
        int headR = -1, headC = -1;
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == '*') {
                    headR = i;
                    headC = j;
                    found = true;
                    break;
                }
            }
        }
        
        int heartR = headR + 1;
        int heartC = headC;
        
        int leftArm = 0;
        for (int c = heartC - 1; c >= 0; c--) {
            if (g[heartR][c] == '*') leftArm++;
            else break;
        }

        int rightArm = 0;
        for (int c = heartC + 1; c < n; c++) {
            if (g[heartR][c] == '*') rightArm++;
            else break;
        }
        
        int waist = 0;
        int waistEndR = heartR;
        for (int r = heartR + 1; r < n; r++) {
            if (g[r][heartC] == '*') {
                waist++;
                waistEndR = r;
            } else {
                break;
            }
        }
        
        int leftLeg = 0;
        for (int r = waistEndR + 1; r < n; r++) {
            int c = heartC - 1;
            if (c >= 0 && g[r][c] == '*') leftLeg++;
            else break;
        }

        int rightLeg = 0;
        for (int r = waistEndR + 1; r < n; r++) {
            int c = heartC + 1;
            if (c < n && g[r][c] == '*') rightLeg++;
            else break;
        }
        
        System.out.println((heartR + 1) + " " + (heartC + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}