/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Reader 
{
    private int[][] puzzle;
    private int[][] whiteBelt;
    private int[][] greenBelt;
    private int[][] brownBelt;
    private int[][] blackBelt;
    
    public Reader(File filename) throws FileNotFoundException
    {
        Scanner sc;
        sc = new Scanner(filename);
        while(sc.hasNext())
        {
            String s = sc.next();
            if(s.trim().isEmpty())
            {
                continue;
            }
            System.out.println(s);
        }
        sc.close();
    }
    
    /*Im using this constructor to create a puzzle for the program to solve until
    i can figure out the file reader*/
    public Reader()
    {
        int[][] sample = 
        {
            {5, 0, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 0}
        };
        
        int[][] whiteBelt =
        {
            {9, 5, 6, 8, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 3, 0, 0, 0, 5},
            {0, 0, 0, 9, 0, 0, 1, 0, 2},
            {4, 0, 9, 0, 0, 0, 0, 6, 0},
            {0, 0, 7, 4, 0, 2, 5, 0, 0},
            {0, 3, 0, 0, 0, 0, 2, 0, 9},
            {6, 0, 2, 0, 0, 3, 0, 0, 0},
            {7, 0, 0, 0, 8, 0, 0, 5, 0},
            {0, 0, 0, 0, 0, 6, 9, 2, 4}
        };
        
        this.whiteBelt = whiteBelt;
        
        int[][] greenBelt =
        {
            {0, 0, 0, 0, 0, 1, 0, 0, 5},
            {0, 5, 0, 0, 2, 8, 0, 0, 0},
            {0, 8, 0, 0, 0, 0, 3, 2, 4},
            {5, 0, 3, 9, 0, 2, 0, 0, 6},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {6, 0, 0, 7, 0, 3, 2, 0, 8},
            {3, 6, 9, 0, 0, 0, 0, 5, 0},
            {0, 0, 0, 6, 9, 0, 0, 8, 0},
            {1, 0, 0, 2, 0, 0, 0, 0, 0}
        };
        this.greenBelt = greenBelt;
        
        int[][] brownBelt = 
        {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        this.brownBelt = brownBelt;
        
        int[][] blackBelt =
        {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        this.blackBelt = blackBelt;
        puzzle = sample;
    }
    
    /*
    this returns the puzzle
    */
    public int[][] getPuzzle() 
    {
        return puzzle;
    }

    public int[][] getWhiteBelt() {
        return whiteBelt;
    }

    public int[][] getGreenBelt() {
        return greenBelt;
    }

    public int[][] getBrownBelt() {
        return brownBelt;
    }

    public int[][] getBlackBelt() {
        return blackBelt;
    }
}
