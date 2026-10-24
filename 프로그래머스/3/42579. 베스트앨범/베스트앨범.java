import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalPlays = new HashMap<>();
        Map<String, List<int[]>> songs = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i],0) + plays[i]);
            
            songs.putIfAbsent(genres[i], new ArrayList<>());
            songs.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        List<String> genreList = new ArrayList<>(totalPlays.keySet());
        genreList.sort((a,b) -> Integer.compare(totalPlays.get(b), totalPlays.get(a)));
        
        List<Integer> answer = new ArrayList<>();
        
        for (String genre : genreList) {
            List<int[]> songList = songs.get(genre);
            songList.sort((a,b) -> {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(b[1], a[1]);
            });
            
            for (int i = 0; i < Math.min(2, songList.size()); i++) {
                answer.add(songList.get(i)[0]);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}