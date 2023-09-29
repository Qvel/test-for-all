package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PawnReachability {
    private char[][] board;

    public PawnReachability(char[][] board) {
        this.board = board;
    }

    public List<Point> pawnReachability(int r, int c) {
        List<Point> reachablePositions = new ArrayList<>();
        dfs(r, c, reachablePositions);
        return reachablePositions;
    }

    private void dfs(int r, int c, List<Point> reachablePositions) {
        if (r == 0) {
            reachablePositions.add(new Point(r, c));
            return;
        }

        if (board[r-1][c] == ' ') {
            dfs(r-1, c, reachablePositions);
        }

        if (c > 0 && board[r-1][c-1] == 'B') {
            dfs(r-1, c-1, reachablePositions);
        }

        if (c < board.length - 1 && board[r-1][c+1] == 'B') {
            dfs(r-1, c+1, reachablePositions);
        }
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
