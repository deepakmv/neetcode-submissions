class Solution {
    public boolean exist(char[][] board, String word) {

        if(word.isEmpty()) return true;

        char[] wordArray = word.toCharArray();

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == wordArray[0]) {
                    boolean flag = dfs(board,wordArray,i,j,0);
                    if(flag) {
                        return flag;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(k == word.length) {
            return true;
        }
        if(i < 0 || i >= board.length) {
            return false;
        }
        if(j < 0 || j >= board[0].length) {
            return false;
        }

        if(board[i][j] != word[k]) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean res = dfs(board,word,i+1,j,k+1) ||
            dfs(board,word,i,j+1,k+1) ||
            dfs(board,word,i-1,j,k+1) ||
            dfs(board,word,i,j-1,k+1);

        board[i][j] = temp;
        
        return res;
    }
}
