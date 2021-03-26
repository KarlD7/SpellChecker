Karl Dinang

Problem Description:

	Edit distance is the minimum amount of transformations that can be done to a word to transform it to another. There are three transfromations
that can be done to a word. These transformations are insert, delete, and remove and all have a cost of 1. There are different ways this problem can be
solved, but for this assignment our goal was to solve this problem using dynamic programming. Dynamic programming is breaking a big problem into many
different sub-problems, saving the results of those sub-problems, and then using those to solve our big problem. When we can successfully figure out the
edit distance between words, we will then need to create a spell checker. The spell checker will take some text as input, and will then look at every word
in that piece of text. If any word within the text in not in the english dictionary, then that word will be replaced by another word in the english dictionary
that has the minimum distance compared to that word.


Analysis and Description of the Major Functions/Classes:

EditDistanceCalculator class - This class is used to calculate the edit distaance between two strings and has 1 main function which is 
calculateEditDistance() function. This class doesn't work by itself however, and is called by two other methods within our class. The edit distance is calculated
by repeatdly checking on the minimum edit distance of previous substrings of our two strings, then adds one to that minimum. In the case that both of our substrings
contain an identical character, we just take the value of the minimum edit distance of the previous substrings. Since this is a 2-dimensional array and we have to
fill all the value within our array, this method runs in O(n^2) runtime.

SpellCorrector class - This class is used for spell checking words within a given text, and if that word isn't found in the english language, it will get replace 
with a word in the english language that has the minimum edit distance to it. The spellCheck() function checks if the words within our phrase is found in the 
english dictionary. This searching of each word in the dictionary takes O(n*m) time, with n being how many words we have in our phrase and m being the length of 
the words in the english language. Looking up each word is expensive because I used an Arraylist to store our dictionary inside. If a HashSet was used instead,
searching for words within our dictionary would have only taken O(1) time, meaning this function would run in O(n). Once a word is found that isn't in the english
language, a call is made to the SpellCorrector class's findMinDistance() method. This looks through all the words of the english language, finds the word with the 
smallest edit distance, replacing our old misspelled word. This takes O(m) time as we have to look through all the words in the dictionary. This means that in total,
finding a misspelled word within a phrase and replacing that word takes O(n*m^2).

FileProcessor class - This class is used to load content from .txt file into our program. The main method of this class is the getContent() method. This method reads
from a file, and every line in that file is stored as an element of a List<String> in our program. It would have been better to use a HashSet insead of a List, as
looking words up would have been a lot faster, thus improving other portions of our program. This function runs in O(n) with n being the number of lines within the 
.txt the class is reading from.

LevDistance class - This class is the main class that handles everything. It collects input from the user, and uses that input to then trigger commands.


Instruction to Execute Your Code:

1. Open The LevensteinDistance folder in an IDE(the program was tested in IntelliJ on my machine).
2. Once open, main sure you are in the LevDistance.java file, and run the code.
3. You will the be prompted with the text: "Please Enter A Command".
	There are three different commands that can be made:
	1 - editdistance word1 word2
	2 - spellcheck phrase
	3 - exit
   Command 1 takes the word "editdistance"(no spaces and non case sensitive) followed by a space, followed by you first word, followed by another space, then your second word.
   If you enter less than two words after editdistance you command will be ingored, if you enter more than two words after editdistance only the first two will be taken into
   account.
   Command 2 takes the word "spellcheck"(no spaces and non case sensitive) followed by a space, then followed by a phrase. The phrase can be as lengthy as you wish.
   Command 3 simply takes the word "exit"(no spaces and non case sensitive) and terminates the program.
4. After a valid command has been entered, your ouput will be displayed to you in your terminal.


Sample Input and Corresponding Output

Please Enter A Command: 

editdistance howdy goofy

  e h o w d y  
e 0 1 2 3 4 5  
g 1 1 2 3 4 5  
o 2 2 1 2 3 4  
o 3 3 2 2 3 4  
f 4 4 3 3 3 4  
y 5 5 4 4 4 3  
 
The minimum edit distance between howdy and goofy is 3
 
Please Enter A Command: 

spellcheck this is a yool

New Phrase: this is a bool | Total Edit Distance(s): 1

Please Enter A Command: 

exit

Process finished with exit code 0


Experience on this Assignment:
	
	I personally had a lot of fun doing this assingment. Dynamic programming is a tool that can be used to drastically improve performance for certain problems and this assingment
was a great way of extensively using and experimenting with this tool. Fully understanding how the table worked was a bit tricky at first, but once I got the down the ball started
rolling and it was smooth sailing from there. The coding was the easier portion for this assingment, which made it good so I had time to really focus and understand how the edit
distance calculation works the way it does.
