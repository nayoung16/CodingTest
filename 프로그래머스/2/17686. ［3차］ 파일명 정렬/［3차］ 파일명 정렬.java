import java.util.*;

class Solution {
    static class File {
        String head;
        String number;
        String original;
        
        File(String head, String number, String original) {
            this.head = head;
            this.number = number;
            this.original = original;
        }
    }
    public String[] solution(String[] files) {
        List<File> newFiles = new ArrayList<>();
        for (String file : files) {
            int i = 0;
            while (i < file.length() && !Character.isDigit(file.charAt(i))) {
                i++;
            }
            String head = file.substring(0, i);
            
            int j = i;
            while (j < file.length() && Character.isDigit(file.charAt(j))) {
                j++;
            }
            String number = file.substring(i, j);
            File newFile = new File(head, number, file);
            newFiles.add(newFile);
        }
        
        Collections.sort(newFiles, (f1, f2) -> {
            // head 비교
            int headCompare = f1.head.toLowerCase().compareTo(f2.head.toLowerCase());
            if (headCompare != 0) return headCompare;
        
            // number 비교
            int num1 = Integer.parseInt(f1.number);
            int num2 = Integer.parseInt(f2.number);
            return num1 - num2;
        });
            
        String[] answer = new String[files.length];
        int i = 0;
        for (File file : newFiles) {
            answer[i] = file.original;
            i++;
        }
        
        return answer;
    }
}