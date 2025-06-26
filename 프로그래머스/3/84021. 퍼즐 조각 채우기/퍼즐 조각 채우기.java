import java.util.*;

class Solution {
    
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    private void dfs(int[][] board, int x, int y, int target, List<int[]> puzzle){
        board[x][y] = 1 - target;
        puzzle.add(new int[]{x, y});
        for(int i = 0; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(0<= nx && nx < board.length && 0<= ny&& ny < board[0].length){
                if(board[nx][ny] == target){
                    dfs(board, nx, ny, target, puzzle);
                }
            }
        } 
    }
    
    private List<List<int[]>> getPuzzle(int[][] board, int target){
        List<List<int[]>> puzzleList = new ArrayList<>();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == target){
                    List<int[]> puzzle = new ArrayList<>();
                    dfs(board, i, j, target, puzzle);
                    puzzleList.add(puzzle);
                }    
            }
        }
        
        
        return puzzleList;   
    }
    
    private void printPuzzle(List<List<int[]>> puzzleList){
        for(int i = 0; i < puzzleList.size(); i++){
            System.out.println("Puzzle "+i+" :");
            List<int[]> piece = puzzleList.get(i);
            for(int[] coord: piece){
                System.out.println(Arrays.toString(coord));
            }
            System.out.println();
        }
    }
    public int solution(int[][] game_board, int[][] table) {
        // 퍼즐 추출하기
        // 1. game_board에서 0 추출 List<List<int[]>> => gamePuzzle
        List<List<int[]>> gamePuzzle = getPuzzle(game_board, 0);
        // 2. table에서 추출 1 => tablePuzzle
        List<List<int[]>> tablePuzzle = getPuzzle(table, 1);
        //printPuzzle(gamePuzzle);
        //printPuzzle(tablePuzzle);
        
        // 3. gamePuzzle 순회하면서 
        int count = 0;
        for(List<int[]> gameOnePuzzle : gamePuzzle){
            // 1개의 퍼즐에 대해서 맞는 조각 있는지 보기
            int collectIndex = checkPuzzle(gameOnePuzzle, tablePuzzle);
            if(collectIndex != -1){
                count+= tablePuzzle.get(collectIndex).size();
                tablePuzzle.remove(collectIndex);
            }
        }
        
        return count;
    }
    
    private List<int[]> normalized(List<int[]> onePuzzle){
        List<int[]> list = new ArrayList<>();
        
        onePuzzle.sort(Comparator.comparingInt((int[] a)-> a[0])
                      .thenComparingInt((int[] a)-> a[1]));
        int[] start = onePuzzle.get(0);
        int sx = start[0];
        int sy = start[1];
        
        for(int[] point : onePuzzle){
            list.add(new int[]{point[0] - sx, point[1] - sy});
        }
        
        return list;
    }
    
    private List<int[]> rotate(List<int[]> onePuzzle){
        List<int[]> list = new ArrayList<>();
        onePuzzle.sort((a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        }); // 정렬 후 
        // 오른쪽 90도 회전 x, y = y, -x
        for(int[] point : onePuzzle){
            list.add(new int[]{point[1], -point[0]});
        }
        
        return list;
    }
    private int checkPuzzle(List<int[]> gameOnePuzzle, List<List<int[]>> tablePuzzle){
        // gameOnePuzzle 정규화 필요
        List<int[]> normalizedGameOne = normalized(gameOnePuzzle);
        
        for(int i = 0; i < tablePuzzle.size(); i++){
            List<int[]> current = tablePuzzle.get(i);
            for(int j = 0; j < 4; j++){
                // 4회전해서 확인하기
                current = rotate(current);
                current = normalized(current);
                if (isSame(normalizedGameOne, current)) {
                    return i;
                }
            }
        }
        
        return -1;
    }
    
    private boolean isSame(List<int[]> a, List<int[]> b){
        if(a.size()!=b.size())return false;
        for(int i = 0; i < a.size(); i++){
            if(a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]){
                return false;
            }
        }
        return true;
    }
}