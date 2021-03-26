import java.io.IOException;
import java.util.*;

public class LevDistance {
    EditDistanceCalc ed;
    SpellCorrector sp;
    FileProcessor fp;

    public LevDistance() throws IOException{
        fp = new FileProcessor();
        ed = new EditDistanceCalc();
        sp = new SpellCorrector(fp.getContent("words.txt"));
    }
    /*
     Method - inputManager
     Functionality - Reads user input and runs commands{
        Three Different Command Types:
        1 - editdistance word1 word2; Prints a grid of the edit distance calculation of word1 and word2
        2 - spellcheck phrase; Checks for misspelled words and replaces with another
        3 - exit; breaks our loop and closes the program
        }
    */
    public void inputManager(){
        System.out.println("Please Enter A Command: ");
        Scanner s = new Scanner(System.in);
        String it = s.nextLine();
        String[] command = it.split(" ");
        String exit = "";
        while(!exit.equalsIgnoreCase("exit")){
            if(command[0].equalsIgnoreCase("editdistance") && command.length>=3){
                ed.editDistanceGrid(command[1], command[2]);
            }
            else if(command[0].equalsIgnoreCase("spellcheck")){
                StringBuilder str = new StringBuilder();
                for(int i = 1; i<command.length; i++){
                    str.append(command[i] + " ");
                }
                sp.spellCheck(str.toString());
            }
            System.out.println("Please Enter A Command: ");
            command = s.nextLine().split(" ");
            exit = command[0];
        }
        s.close();
    }

    //runs our program
    public static void main(String[] args) throws Exception {
        LevDistance l = new LevDistance();
        l.inputManager();
    }
}
