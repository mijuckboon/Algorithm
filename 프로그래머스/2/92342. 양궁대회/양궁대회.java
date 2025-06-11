import java.util.*;

class Solution {
    static final int LOWEST_SCORE = 0;
    static final int HIGHEST_SCORE = 10;
    static final int SCORES_COUNT = HIGHEST_SCORE - LOWEST_SCORE + 1;
    
    static class Result {
        int maxScoreDiff;
        int[] bestArrows; // bestShots
        
        Result(int maxScoreDiff, int[] bestArrows) {
            this.maxScoreDiff = maxScoreDiff;
            this.bestArrows = bestArrows;
        }
    }
    
    public int[] solution(int n, int[] info) {
        Result result = backtrack(n, 0, new int[SCORES_COUNT], info);
        if (result.maxScoreDiff <= 0) {
            return new int[] {-1};
        }
        
        return result.bestArrows;
    }
    
    private Result backtrack(int remainingArrows, int currentIndex, int[] shots, int[] info) {
        if (currentIndex == SCORES_COUNT) {
            if (remainingArrows > 0) {
                // 남은 화살은 전부 마지막(0점)에 몰아줌
                shots[SCORES_COUNT - 1] += remainingArrows;
                }
            
        int scoreDiff = computeDiff(shots, info);
        Result result = new Result(scoreDiff, Arrays.copyOf(shots, shots.length));
            
        if (remainingArrows > 0) {
            shots[SCORES_COUNT - 1] -= remainingArrows; // 복원!
        }
        return result;
        }
        
        if (remainingArrows == 0) {
            int scoreDiff = computeDiff(shots, info);
            return new Result(scoreDiff, Arrays.copyOf(shots, shots.length));
        }

        Result bestResult = null;
        
        int arrowsRequired = info[currentIndex] + 1; // 어피치 + 1
        if (arrowsRequired <= remainingArrows) {
            shots[currentIndex] = arrowsRequired;
            Result resultWhenWin = backtrack(remainingArrows - arrowsRequired, currentIndex + 1, shots, info);
            shots[currentIndex] = 0;

            bestResult = compareResults(bestResult, resultWhenWin);
        }

        Result resultWhenSkipped = backtrack(remainingArrows, currentIndex + 1, shots, info);
        bestResult = compareResults(bestResult, resultWhenSkipped); // 더 나은 결과를 반환

        return bestResult;
    }
    
    // 라이언 점수 - 어피치 점수 계산
    private int computeDiff(int[] shots, int[] info) {
        int ryanMinusApeach = 0;
        for (int i = 0; i <= 10; i++) {
            if (shots[i] == 0 && info[i] == 0) continue;
            if (shots[i] > info[i]) { // 라이언이 많이 쐈으면 라이언 점수 추가
                ryanMinusApeach += (10 - i);
            } else { // 어피치가 많거나 같게 쐈으면 어피치 점수 추가
                ryanMinusApeach -= (10 - i);
            }
        }
        return ryanMinusApeach;
    }

    // 방법이 여러 가지일 때
    private Result compareResults(Result r1, Result r2) {
        if (r2 == null) return r1;
        if (r1 == null) return r2;
        
        if (r2.maxScoreDiff > r1.maxScoreDiff) {
            return r2;
        } else if (r2.maxScoreDiff == r1.maxScoreDiff && r2.maxScoreDiff > 0) {
            // 점수가 같다면, 낮은 점수부터 더 많이 맞힌 경우 우선
            for (int i = HIGHEST_SCORE; i >= LOWEST_SCORE; i--) {
                if (r1.bestArrows[i] != r2.bestArrows[i]) {
                    if (r2.bestArrows[i] > r1.bestArrows[i]) return r2;
                    else return r1;
                }
            }
        } // else { -> missing return statement
        return r1; // (r2가 더 낫다면) return r2, 아니면 return r1 구조
        // }
    }
    
}