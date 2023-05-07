package pandemic;

import java.io.*;
import java.util.*;

//import org.json.*;

/**
 * entry point of the executable, runs the whole game by calling a Game object.
 */
public class pandemicMain {
	
	/** maximum number of args the user can input, if they input more they will not be taken into account*/
	static int maxNumberOfArguments = 3; /* to be updated if we implement more arguments in the future*/
	
	/** default values that will be used if arguments are omitted*/
	static String[] defaultValuesForArgs = {"villes.json", "3", "2"};
			

	/** Arguments are all optionnal. See the defaultValuesForArgs array for the values if arguments are omitted. 
	 *  @param args[0] The name of the file that contains city data
	 *  @param args[1] The numbers of players for this game, should be between 2 and 4 included.
	 *  @param args[2] Global infection rate, should be 2 for the classic version of the game.
	 * @throws FileNotFoundException if the file that contains city data is not found 
	 */
	public static void main(String args[]) throws FileNotFoundException {
		
		
		//args handling
		String[] argsAfterProcessing = pandemicMain.defaultValuesForArgs; /* initialized with default values*/
		if (args.length > pandemicMain.maxNumberOfArguments) {
			System.out.println("Too many arguments, the last ones will be ignored.");
		}
		for (int i=0; i< pandemicMain.maxNumberOfArguments; i++){
			if (args.length > i) {// if the argument has been input by the user
				argsAfterProcessing[i] = args[i]; //update argsAfterProcessing
			} else {
				System.out.println("Using default value for argument at position" + (i) +  ".");
			}
		}
		
		/*initialize game*/
		Game currentGame = new Game(
				argsAfterProcessing[0],
				Integer.parseInt(argsAfterProcessing[1]),
				Integer.parseInt(argsAfterProcessing[2])
				);
		currentGame.play(); /* launches the game*/
	}
	
}