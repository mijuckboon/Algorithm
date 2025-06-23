class Solution {
    // up, down, left, right
    private static int[] moveX = {0, 0, -1, 1};
    private static int[] moveY = {1, -1, 0, 0};
    
    public int[] solution(String[] keyinput, int[] board) {
        final int xMax = (board[0] - 1) / 2; // 절댓값의 최대
        final int yMax = (board[1] - 1) / 2;
        
        // int[] coordinate = new int[] {0, 0}; // 참조형
        // int[] newCoordinate = new int[] {0, 0};
        int x = 0;
        int y = 0;
        
        for (String input: keyinput) {
            
            int newX = x + moveX[move(input)];
            int newY = y + moveY[move(input)];
            
            if (isValid(newX, newY, xMax, yMax)) {
                x = newX;
                y = newY;
            }
            
            // move(newCoordinate, input);
            // if (isValid(newCoordinate[0], newCoordinate[1], xMax, yMax)) {
            //     coordinate[0] = newCoordinate[0];
            //     coordinate[1] = newCoordinate[1];
            // }
            // if (!isValid(newCoordinate[0], newCoordinate[1], xMax, yMax)) {
            //     newCoordinate[0] = coordinate[0];
            //     newCoordinate[1] = coordinate[1];
            // }
        }
        
        return new int[] {x, y};
    }
    
    private boolean isValid(int x, int y, int xMax, int yMax) {
        return Math.abs(x) <= xMax && Math.abs(y) <= yMax;
    }
    
    private int move(String input) {
        switch (input) {
            case "up":
                return 0;
            case "down":
                return 1;
            case "left":
                return 2;
            case "right":
                return 3;
        }
        return -1; // 없으면 missing return statement error
    }
    
    // private void move(int[] coordinate, String input) {
    //     switch (input) {
    //         case "up":
    //             coordinate[1] += moveY[0];
    //             break;
    //         case "down":
    //             coordinate[1] += moveY[1];
    //             break;
    //         case "left":
    //             coordinate[0] += moveX[2];
    //             break;
    //         case "right":
    //             coordinate[0] += moveX[3];
    //             break;
    //     }
    // }
    
    /* 아래와 같은 형태도 가능 */
    // private static final Map<String, int[]> direction = Map.of(
    //     "up", new int[]{0, 1},
    //     "down", new int[]{0, -1},
    //     "left", new int[]{-1, 0},
    //     "right", new int[]{1, 0}
    // );
    
    // private static final int[][] directions = {
    //     {0, 0, -1, 1},
    //     {1, -1, 0, 0} 
    // };
    // int dir = move(input);
    // int newX = x + directions[0][dir]; 
    // int newY = y + directions[1][dir];
    
}