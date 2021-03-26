import java.lang.Math;
/*
    Class for calculating the edit distance between two strings
    Method(s){
        calculateEditDistance(String[][] grid, String s1, String s2)
        editDistance(String s1, String s2)
        editDistanceGrid(String s1, String s2)
        fillEdges(String[][] grid, String s1, String s2)
        printGrid(String[][] grid)
    }
*/
public class EditDistanceCalc {
    /*
     Method - calculateEditDistance
     Parameter(s){
        String[][] grid - Grid that will use memoization to solve edit distance
        String s1 - First string to be compared
        String s2 - Second string to be compared
     }
     Functionality - Calculates the edit distance between two strings and fills grid with all sub-problem values
    */
    public void calculateEditDistance(String[][] grid, String s1, String s2){
        fillEdges(grid, s1, s2);
        for(int i = 2; i<s2.length()+2; i++){
            for(int j = 2; j<s1.length()+2; j++){
                if(grid[i][0].equals(grid[0][j])){
                    grid[i][j] = grid[i-1][j-1];
                }
                else{
                    int del = Integer.parseInt(grid[i][j-1]);
                    int replace = Integer.parseInt(grid[i-1][j-1]);
                    int ins = Integer.parseInt(grid[i-1][j]);
                    int min = Math.min(Math.min(del, replace), ins);
                    grid[i][j] = String.valueOf(min+1);
                }
            }
        }
    }

    /*
     Method - editDistance
     Parameter(s){
        String s1 - First string to be compared
        String s2 - Second string to be compared
     }
     Functionality - Finds and returns the edit distance between two strings
    */
    public int editDistance(String s1, String s2){
        String[][] grid = new String[s2.length()+2][s1.length()+2];
        calculateEditDistance(grid, s1, s2);
        return Integer.parseInt(grid[s2.length()+1][s1.length()+1]);
    }

    /*
     Method - editDistanceGrid
     Parameter(s){
        String s1 - First string to be compared
        String s2 - Second string to be compared
     }
     Functionality - Calculates and outputs the edit distance table of s1 and s2
    */
    public void editDistanceGrid(String s1, String s2){
        String[][] grid = new String[s2.length()+2][s1.length()+2];
        calculateEditDistance(grid, s1, s2);
        printGrid(grid);
        System.out.println(" ");
        System.out.println("The minimum edit distance between " + s1 + " and " + s2 + " is " + grid[s2.length()+1][s1.length()+1]);
        System.out.println(" ");
    }

    /*
     Method - fillEdges
     Parameter(s){
        String[][] grid - Edit distance table
        String s1 - First string
        String s2 - Second string
     }
     Functionality - Fills the empty value positions of our edit distance table
    */
    public void fillEdges(String[][] grid, String s1, String s2){
        grid[0][0] = " ";
        grid[0][1] = "e";
        grid[1][0] = "e";
        for(int i = 1; i<grid[0].length; i++){
            grid[1][i] = String.valueOf(i-1);
            if(i>=2){
                grid[0][i] = Character.toString(s1.charAt(i-2));
            }
        }
        for(int i = 1; i<grid.length; i++){
            grid[i][1] = String.valueOf(i-1);
            if(i>=2){
                grid[i][0] = Character.toString(s2.charAt(i-2));
            }
        }
    }

    /*
     Method - printGrid
     Parameter(s){
        String[][] grid - The edit distance table to be printed
     }
     Functionality - Print all value within our edit distance table
    */
    public void printGrid(String[][] grid){
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
