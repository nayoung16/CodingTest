import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 사용자별 인덱스 저장
        Map<String, Integer> indexMap = new HashMap<>();

        // 신고당한 사람 -> 신고한 사람 목록
        Map<String, Set<String>> reporterMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            indexMap.put(id_list[i], i);
            reporterMap.put(id_list[i], new HashSet<>());
        }

        for (String reportInfo : report) {
            String[] people = reportInfo.split(" ");
            String reporter = people[0];
            String reported = people[1];
            reporterMap.get(reported).add(reporter);
        }

        // 신고 횟수가 k 이상인 사용자만 정지
        for (String reported : id_list) {
            Set<String> reporters = reporterMap.get(reported);
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    answer[indexMap.get(reporter)]++;
                }
            }
        }

        return answer;
    }
}