import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String s) {
        String[] sets = s.substring(2, s.length() - 2) // 양 끝 중괄호 제거 (2개씩)
            .split("\\},\\{"); // regex
        
        List<List<String>> setList = Arrays.stream(sets)
            .map(str -> new ArrayList<>(Arrays.asList(str.split(","))))
            .sorted(Comparator.comparingInt(x -> x.size()))
            // .map(str -> new HashSet<>(Arrays.asList(str.split(","))))
            // .sorted(Comparator.comparingInt(Set::size))
            .collect(Collectors.toList());
        
        Set<String> seen = new HashSet<>();
        List<Integer> tuple = new ArrayList<>();
        
        for (List<String> currentSet : setList) {
            currentSet.removeAll(seen); // 이미 본 숫자 제거
            String found = currentSet.get(0);
            // String found = currentSet.stream().findFirst().orElse(null); // List<String> 대신 Set<String>일 때
            seen.add(found);
            tuple.add(Integer.parseInt(found));
        }
        
        return tuple.stream().mapToInt(x -> x).toArray();
    }
    
    public int[] solution2(String s) {
        String[] sets = s.substring(2, s.length() - 2) // 양 끝 중괄호 제거 (2개씩)
            .split("},\\{");
        
        List<String[]> braceRemovedSets = Arrays.stream(sets)
            .map(set -> set.split(","))
            .collect(Collectors.toList());
        
        braceRemovedSets.sort(Comparator.comparingInt(x -> x.length));
        
        Set<String> seen = new HashSet<>();
        List<Integer> tuple = new ArrayList<>();

        for (String[] currentSet : braceRemovedSets) {
            for (String str : currentSet) {
                if (!seen.contains(str)) {
                    seen.add(str);
                    tuple.add(Integer.parseInt(str));
                    break;
                }
            }
        }

        return tuple.stream().mapToInt(i -> i).toArray();
    }
}