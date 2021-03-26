import java.io.File;
import java.io.IOException;
import java.util.*;
/*
    Class for reading txt files
    Method(s){
        FileProcessor() - class Constructor
        getContent(String fileName)
    }
*/
class FileProcessor{
    Scanner scanner;
    List<String> dictionary;
    public FileProcessor(){
        dictionary = new ArrayList<String>();
    }

    /*
     Method - getContent
     Parameter(s){
        String fileName - Name of the file content is to be collected from
     }
     Functionality - Reads the lines of a txt file and returns a List with each element being a line in that file
    */
    public List<String> getContent(String fileName) throws IOException{
        scanner = new Scanner(new File(fileName));
        while(scanner.hasNext()){
            dictionary.add(scanner.next());
        }
        return dictionary;
    }
}