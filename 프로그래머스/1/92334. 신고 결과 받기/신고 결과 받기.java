import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static class Report {
        String reporter;
        String reported;
        
        public Report(String reporter, String reported) {
            this.reporter = reporter;
            this.reported = reported;
        }
        
        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Report)) return false;
        Report report = (Report) o;
        return reporter.equals(report.reporter) && reported.equals(report.reported);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reporter, reported);
    }
        
    }
    
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<Report> reports = new HashSet<>();
        for (String rep: report) {
            StringTokenizer st = new StringTokenizer(rep);
            reports.add(new Report(st.nextToken(), st.nextToken()));
        }
        
        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, Set<String>> reportsOfUser = new HashMap<>();
        for (Report rep : reports) {
            String reported = rep.reported;
            String reporter = rep.reporter;
            
            Set<String> reportList = reportsOfUser.getOrDefault(reporter, new HashSet<>());
            reportList.add(reported);
            reportsOfUser.put(reporter, reportList);
            
            reportCount.put(reported, reportCount.getOrDefault(reported, 0) + 1);
        }
        
        Set<String> prohibited = reportCount.entrySet()
            .stream()
            .filter(x -> x.getValue() >= k)
            .map(x -> x.getKey())
            .collect(Collectors.toSet());
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++ ) {
            String reporter = id_list[i];
            answer[i] = (int) reportsOfUser.getOrDefault(reporter, new HashSet<>())
                .stream()
                .filter(x -> prohibited.contains(x))
                .count();
        }
        return answer;
    }
}