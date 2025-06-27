import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String s) {
        String[] sets = s.substring(2, s.length() - 2) // 양 끝 중괄호 제거 (2개씩)
            .split("\\},\\{"); // regex
        // System.out.println(Arrays.toString(sets));
        
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
    // 첫 시도
    public int[] firstTrial(String s) {
        String[] sets = s.substring(1, s.length() - 1) // 양 끝 중괄호 제거
            .split(",");
        System.out.println(Arrays.toString(sets));
        // 출력: [{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}]
        // 실제로는 "{2}", "{2", "1}", ... 과 같이 잘못 잘린 형태
        
        List<String> braceRemovedSets = Arrays.stream(sets)
            .map(set -> {
                int len = set.length();
                // if (len >= 2) { <- 이 부분이 없으면 (있으면 empty string이 많은 리스트)
                    return set.substring(1, len - 1); // 여기서 exception 터짐 
                // }
                // return set;
            })
            // .map(set -> set.split(","))
            // .sort(Comparator.comparingInt((String[] x) -> x.length))
            .collect(Collectors.toList());
        System.out.println(braceRemovedSets);
        
        int[] answer = {};
        return answer;
        
    }
}