package com.library;

import javax.print.attribute.standard.PrinterResolution;

public class Mazesolver {
    private int [][]sudokupuzzle = new int[9][9];
    public static final Integer End = 4;
    public static final Integer Start = 3;

    Mazesolver(int [][]maze)
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                sudokupuzzle[i][j] = maze[i][j];
            }
        }
        Solution soln = new Solution(3,4, 19, 19, 20, 20);

    }

    private class Solution
    {
        Integer startx;
        Integer starty;
        Integer endx;
        Integer endy;
        Integer width;
        Integer len;
        Solution(int xs, int ys, int xd, int yd, int width, int length)
        {
            this.startx=xs;
            this.starty=ys;
            this.endx=xd;

        }
        //bfs
        public void solveMaze(int grid[][])
        {

        }
    }
}
