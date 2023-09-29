package tasks.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class PawnReachability {
    private char[][] board;
    public PawnReachability( char[][] board){
        this.board = board;
    }
    public static void main(String[] args) {
        char[][] board = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'B', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', 'B', ' ', ' '},
                {' ', ' ', ' ', 'P', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };

        PawnReachability pr = new PawnReachability(board);
        List<Point> result = pr.pawnReachability(5, 3); // Пішак розташований на позиції (5, 3)

        System.out.println("Досяжні позиції:");
        for (Point p : result) {
            System.out.println(p);
        }
    }

    public List<Point> pawnReachability(int r, int c) {
        List<Point> reachablePositions = new ArrayList<>();
        dfs(r, c, reachablePositions);
        return reachablePositions;
    }

    private void dfs(int r, int c, List<Point> reachablePositions) {
        //Якщо пішак досяг верхнього рядка (рядка з індексом 0), метод додає цю позицію до списку досяжних позицій та завершується.
        if (r == 0) {
            reachablePositions.add(new Point(r, c));
            return;
        }
        //Рух прямо вгору:
        if (board[r-1][c] == ' ') {
            dfs(r-1, c, reachablePositions);
        }
        //Рух вгору і вліво:
        if (c > 0 && board[r-1][c-1] == 'B') {
            dfs(r-1, c-1, reachablePositions);
        }
        //Рух вгору і вправо:
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
