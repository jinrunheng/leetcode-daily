package com.github.leetcodedaily.valid_tic_tac_toe_state;

class Solution {

    public boolean validTicTacToe(String[] board) {
        int xCount = count(board, 'X');
        int oCount = count(board, 'O');
        boolean isOWin = isOWin(board);
        boolean isXWin = isXWin(board);

        if (xCount >= oCount) {
            if (xCount == oCount) {
                return (!isXWin && !isOWin) || (isOWin && !isXWin);
            } else {
                if (xCount == oCount + 1
                        && (isXWin && !isOWin || !isXWin && !isOWin)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private int count(String[] board, char c) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == c) res++;
            }
        }
        return res;
    }

    private boolean isXWin(String[] board) {
        return board[0].equals("XXX")
                || board[1].equals("XXX")
                || board[2].equals("XXX")
                || board[0].charAt(0) == 'X' && board[1].charAt(0) == 'X' && board[2].charAt(0) == 'X'
                || board[0].charAt(1) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(1) == 'X'
                || board[0].charAt(2) == 'X' && board[1].charAt(2) == 'X' && board[2].charAt(2) == 'X'
                || board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X'
                || board[2].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[0].charAt(2) == 'X';
    }

    private boolean isOWin(String[] board) {
        return board[0].equals("OOO")
                || board[1].equals("OOO")
                || board[2].equals("OOO")
                || board[0].charAt(1) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(1) == 'O'
                || board[0].charAt(2) == 'O' && board[1].charAt(2) == 'O' && board[2].charAt(2) == 'O'
                || board[0].charAt(0) == 'O' && board[1].charAt(0) == 'O' && board[2].charAt(0) == 'O'
                || board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O'
                || board[2].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[0].charAt(2) == 'O';
    }
}
