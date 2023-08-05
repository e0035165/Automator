package com.library;
import java.util.ArrayList;
import java.util.List;


public class SudokuSolver{
    private int [][]sudokupuzzle = new int[9][9];
    private Solution soln = new Solution();
    public SudokuSolver(int [][]sudoku)
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                sudokupuzzle[i][j] = sudoku[i][j];
            }
        }
        soln.square_comb(sudokupuzzle);
        soln.secondSoduku(sudokupuzzle, 0);
        soln.printGrid(sudokupuzzle);
    }

    public Integer[][] returnAnswer()
    {
        Integer[][] answer = new Integer[9][9];
        for(int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                answer[i][j] = Integer.valueOf(sudokupuzzle[i][j]);
            }
        }
        return answer;
    }

    private class Solution
    {
        Solution()
        {

        }
        boolean forward = true;
        final int N = 9;
        List<Integer>empty_positions = new ArrayList<>();
        List<List<Integer>>combinatorics = new ArrayList<>();
        public void secondSoduku(int target[][], int pos)
        {
            if(pos >= empty_positions.size())
            {
                System.out.println("Solved!");
                forward = false;
                return;
            }
            for(Integer Y : combinatorics.get(empty_positions.get(pos)))
            {
                if(sq_chk(target, empty_positions.get(pos), Y) && chk_col(target, empty_positions.get(pos), Y) && chk_row(target, empty_positions.get(pos), Y))
                {
                    target[empty_positions.get(pos) / 9][empty_positions.get(pos) % 9] = Y;
                    secondSoduku(target,pos+1);
                }
                if(forward == false)
                {
                    break;
                }
                target[empty_positions.get(pos) / 9][empty_positions.get(pos) % 9] = 0;
            }
            return;
        }
        public void square_comb(int grid[][])
        {
            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    combinatorics.add(new ArrayList<Integer>());
                    if (grid[i][j] == 0) {
                        empty_positions.add(i*9 + j);

                        for (int k = 1; k <= 9; ++k)
                        {
                            if (sq_chk(grid, i * 9 + j, k) && chk_row(grid, i * 9 + j, k) && chk_col(grid, i * 9 + j, k))
                            {
                                combinatorics.get(i*9+j).add(k);

                            }
                        }
                    }
                }
            }

	        /*for (int i = 0; i < 81; i++)
	        {
	            for (int j = 0; j < combinatorics[i].size(); ++j)
	            {
	                cout << combinatorics[i][j] << " ";
	            }
	            cout << endl;
	        }
	        cout << endl;
	        for (auto x = empty_positions.begin(); x != empty_positions.end(); ++x)
	        {
	            cout << *x << " ";
	        }
	        cout << endl;*/
        }

        boolean sq_chk(int [][]grid, int pos, int num) {
            int i = pos/9;
            int j = pos%9;
            int lower_end_i = i - (i%3);
            int upper_end_i = lower_end_i + 2;
            int lower_end_j = j - (j%3);
            int upper_end_j = lower_end_j + 2;

            for(int x=lower_end_i;x<=upper_end_i;x++) {
                for(int y=lower_end_j;y<=upper_end_j;y++) {
                    if(num == grid[x][y]) {
                        return false;
                    }
                }
            }
            return true;
        }
        boolean chk_col(int [][]grid, int pos, int num) {
            int col_no = (pos%9);
            for(int x=0;x<N;x++) {
                if(grid[x][col_no] == num) {
                    return false;
                }
            }
            return true;
        }
        boolean chk_row(int [][]grid, int pos, int num) {
            int row_no = (pos/9);
            for(int x=0;x<N;x++) {
                if(grid[row_no][x] == num) {
                    return false;
                }
            }
            return true;
        }
        //Function to print grids of the Sudoku.
        void printGrid (int newSheet[][])
        {
            for(int i=0;i<9;i++) {
                for(int j=0;j<9;j++) {
                    System.out.print(newSheet[i][j] +" ");
                }
                System.out.println();
            }
            return;
        }

        public int[][] returnAnswer()
        {
            return sudokupuzzle;
        }
    }

}
