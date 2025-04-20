import java.util.*;
    
class Solution {
    static class Song {
        int id;
        String genre;
        int play;
        
    public Song(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }
    }
    
    static final int CHOOSE = 2;
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCount = new HashMap<>();
        Map<String, List<Song>> album = new HashMap<>();
        
        int len = genres.length;
        
        for (int i = 0; i < len; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreCount.put(genre, genreCount.getOrDefault(genre, 0) + play);
            if (!album.containsKey(genre)) {
                album.put(genre, new ArrayList<>());
            }
            album.get(genre).add(new Song(i, genre, play));
        }
        
        // List<String> sortedGenres = genreCount.entrySet().stream()
        //     .sorted((x, y) -> y.getValue() - x.getValue())
        //     .map(x -> x.getKey())
        //     .toList(); // 사용 불가: .collect(Collectors.toList())
        
        List<String> sortedGenres = new ArrayList<>();
        
        genreCount.entrySet().stream()
            .sorted((x, y) -> y.getValue() - x.getValue())
            .forEach(x -> sortedGenres.add(x.getKey()));
        
        List<Integer> bestAlbum = new ArrayList<>();
        
        for (String genre : sortedGenres) {
            final List<Integer> sortedSongs = new ArrayList<>();
            
            album.get(genre)
                .stream()
                .sorted((x, y) -> {
                    if (x.play == y.play) return x.id - y.id;
                    return y.play - x.play;
                })
                .forEach(x -> sortedSongs.add(x.id));
                
            List<Integer> topTwoSongs = sortedSongs.subList(0, Math.min(CHOOSE, sortedSongs.size()));
            topTwoSongs.forEach(x -> bestAlbum.add(x));
        }
        
        return bestAlbum.stream()
            .mapToInt(x -> x)
            .toArray();
    }
}