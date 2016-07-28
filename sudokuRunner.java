/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author daniel
 */
public class sudokuRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException 
    {
        //Reader r = new Reader(new File("index.txt"));
        Reader r = new Reader();
        int[][] puzzle = r.getPuzzle();
        SudokuSolver ss = new SudokuSolver(puzzle);
        ss.isSolvable();
        ss.printPuzzle();
        ss.solve(0, 0);
        ss.printPuzzle();
        
        int [][] puzzle1 = r.getWhiteBelt();
        SudokuSolver s1 = new SudokuSolver(puzzle1);
        s1.isSolvable();
        s1.solve(0, 0);
        s1.printPuzzle();
        
        int[][] puzzle2 = r.getGreenBelt();
        SudokuSolver gb = new SudokuSolver(puzzle2);
        gb.isSolvable();
        gb.solve(0, 0);
        gb.printPuzzle();
    }
    
}
