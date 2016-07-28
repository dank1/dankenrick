/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class SudokuSolver 
{
    //private final Reader sample;
    private int[][] puzzle;
    private boolean[][] originalPuzzle;
    private final int PUZZLE_SIZE = 9;
    //private int solveCounter;
    private boolean debug;

    public SudokuSolver(int[][] puzzle) 
    {
        //sample = new Reader();
        boolean[][] op = 
        {
            {false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false}
        };
        originalPuzzle = op;
        
        this.puzzle = puzzle;
        setOP(puzzle);
        //solveCounter = 0;
        debug = false;
    }
    
    /*
    this is the method that solves the puzzle
    */
    public boolean solve(int row, int col)
    {
        /*printPuzzle();
        ++solveCounter;
        System.out.println(solveCounter);*/
        if(row == 1 && col == 0)
        {
            debug = true;
        }
        
        if(row == 9)
        {
            row = 0;
            ++col;
            if(col == 9)
            {
                return true;
            }
        }
        if(originalPuzzle[row][col])
        {
            
            do
            {
                ++row;
                if(row == 9)
                {
                    row = 0;
                    ++col;
                    if(col == 9)
                    {
                        return true;
                    }
                }
            }while(originalPuzzle[row][col]);
        }
        
        if(puzzle[row][col] > 0)
        {
            solve(row + 1, col);
        }
        for(int i = 1; i <= PUZZLE_SIZE; ++i)
        {
            if(isLegal(row, col, i))
            {
                puzzle[row][col] = i;
                if(solve(row + 1, col))
                {
                    return true;
                }
            }
        }
        puzzle[row][col] = 0;
        return false;
    }
    
    /*
    This method checks to see if a puzzle is solvable by checking to see if
    there can possibly be a solution, and that it has 17 or more numbers in it.
    17 is the minimum number of clues needed to solve a sudoku problem which was
    proved by mathmatitions
    @return true if solvable
    */
    public boolean isSolvable()
    {
        int counter = 0;
        for(int[] i : puzzle)
        {
            for(int j : i)
            {
                if (j > 0 && j <= 9)
                {
                    ++counter;
                }
                else if(j != 0)
                {
                    System.out.println("invalid number");
                    return false;
                }
            }
        }
        if (counter < 17)
        {
            System.out.println("puzzle doesn't have a unique solution");
            return false;
        }
        if(checkRow(puzzle) && checkCol(puzzle) && 
                checkBox(puzzle))
        {
            System.out.println("puzzle is solvable");
            return true;
        }
        else
        {
            System.out.println("puzzle is not solvable");
            return false;
        }
    }
    
    /*
    this method checks the row to see if a number is repeated and returns true
    if there are none
    @return true if there are no repeated numbers in the row
    */
    private boolean checkRow(int[][] puzzleToBeSolved)
    {
        boolean[] oneToNine = {false, false, false, false, false, false, false, 
            false, false};
        for(int i = 0; i < 9; ++i)
        {
            for(int j = 0; j < 9; ++j)
            {
                if(puzzleToBeSolved[i][j] == 0)
                {
                    //do nothing
                }
                else if(oneToNine[puzzleToBeSolved[i][j] - 1])
                {
                    return false;
                }
                else
                {
                    oneToNine[puzzleToBeSolved[i][j] - 1] = true;
                }
            }
            //resets oneToNine
            for(int j = 0; j < 9; ++j)
            {
                oneToNine[j] = false;
            }
        }
        return true;
    }
    
    /*
    this method checks the column to see if a number is repeated and returns true
    if there are none
    @return true if there are no repeated numbers in the column
    */
    private boolean checkCol(int[][] puzzleToBeSolved)
    {
        boolean[] oneToNine = {false, false, false, false, false, false, false, 
            false, false};
        for(int j = 0; j < 9; ++j)
        {
            for(int i = 0; i < 9; ++i)
            {
                if(puzzleToBeSolved[i][j] == 0)
                {
                    //do nothing
                }
                else if(oneToNine[puzzleToBeSolved[i][j] - 1])
                {
                    return false;
                }
                else
                {
                    oneToNine[puzzleToBeSolved[i][j] - 1] = true;
                }
            }
            //resets oneToNine
            for(int i = 0; i < 9; ++i)
            {
                oneToNine[i] = false;
            }
        }
        return true;
    }
    
    /*
    this method checks the 3 x 3 box that each number is in to see if a number 
    is repeated and returns true if there are none
    @return true if there are no repeated numbers in the box
    */
    private boolean checkBox(int[][] puzzleToBeSolved)
    {
        boolean[] oneToNine = {false, false, false, false, false, false, false, 
            false, false};
        for(int offsetI = 0; offsetI < 9; offsetI += 3)
        {
            for(int offsetJ = 0; offsetJ < 9; offsetJ += 3)
            {
                for(int i = offsetI; i < offsetI + 3; ++i)
                {
                    for(int j = offsetJ; j < offsetJ + 3; ++j)
                    {
                        if(puzzleToBeSolved[i][j] == 0)
                        {
                            //do nothing
                        }
                        else if(oneToNine[puzzleToBeSolved[i][j] - 1])
                        {
                            return false;
                        }
                        else
                        {
                            oneToNine[puzzleToBeSolved[i][j] - 1] = true;
                        }
                    }
                }
                for(int j = 0; j < 9; ++j)
                {
                    oneToNine[j] = false;
                }
            }
        }
        return true;
    }
    
    /*
    
    */
    public void printPuzzle()
    {
        for(int[] i : puzzle)
        {
            for(int j : i)
            {
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private boolean isSolved(int[][] solvedPuzzle) 
    {
        for(int i = 0; i < 9; ++i)
        {
            for(int j = 0; j < 9; ++i)
            {
                if(solvedPuzzle[i][j] == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isLegal(int row, int col, int value)
    {
        for(int i = 0; i < PUZZLE_SIZE; ++i)
        {
            if(value == puzzle[row][i])
            {
                return false;
            }
        }
        for(int i = 0; i < PUZZLE_SIZE; ++i)
        {
            if(value == puzzle[i][col])
            {
                return false;
            }
        }
        int rowOffset = row - (row % 3);
        int colOffset = col - (col % 3);
        for(int i = 0; i < 3; ++i)
        {
            for(int j = 0; j < 3; ++j)
            {
                if(value == puzzle[rowOffset + i][colOffset + j])
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void setOP(int[][] puzzleToBeSolved)
    {
        for(int row = 0; row < PUZZLE_SIZE; ++row)
        {
            for(int col = 0; col < PUZZLE_SIZE; ++col)
            {
                if(puzzleToBeSolved[row][col] > 0)
                {
                    originalPuzzle[row][col] = true;
                }
            }
        }
    }
}
