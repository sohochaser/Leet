package com.leet.greedy;

/**
 * <ol>
 * <li>Given a 2D board and a word, find if the word exists in the grid.
 * 
 * <li>The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * <li>For example,
 * <li>Given board =
 * <li>[
 * <li>["ABCE"],
 * <li>["SFCS"],
 * <li>["ADEE"]
 * <li>]
 * <li>word = "ABCCED", -> returns true,
 * <li>word = "SEE", -> returns true,
 * <li>word = "ABCB", -> returns false.
 * </ol>
 * 
 * @author Allen
 * 
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0)
			if (word == null || word.length() == 0) {
				return true;
			}

		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					visited[i][j] = true;
					if (word.length() == 1
							|| search(i, j, board, word.substring(1), visited)) {
						return true;
					}
					visited[i][j] = false;
				}
			}
		}

		return search(0, 0, board, word, visited);
	}

	private boolean search(int x, int y, char[][] board, String word,
			boolean[][] visited) {
		int[][] direct = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		for (int i = 0; i < direct.length; i++) {
			int xx = x + direct[i][0];
			int yy = y + direct[i][1];

			if (xx >= 0 && yy >= 0 && xx < board.length && yy < board[0].length
					&& !visited[xx][yy]) {
				if (board[xx][yy] == word.charAt(0)) {
					visited[xx][yy] = true;
					if (word.length() == 1
							|| search(xx, yy, board, word.substring(1), visited)) {
						return true;
					}
					visited[xx][yy] = false;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' },
				{ 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(new WordSearch().exist(board, "ABCCED"));
	}
}
