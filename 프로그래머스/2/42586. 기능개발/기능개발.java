import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.*;

class Solution {
    private int getDays(int progress, int speed) {
        // (잔여량)/(speed), 나머지가 0이 아니면 + 1
        return (100 - progress + speed - 1)/speed;
    }
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> feats = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            feats.offer(getDays(progresses[i], speeds[i]));
        }
        
        List<Integer> distributes = new ArrayList<>();
        while (!feats.isEmpty()) {
            int maxDay = feats.poll();
            int count = 1;
            while (!feats.isEmpty() && feats.peek() <= maxDay) {
                feats.poll();
                count += 1;
            }
            distributes.add(count);
        }
        return distributes.stream().mapToInt(x->x).toArray();
    }
}