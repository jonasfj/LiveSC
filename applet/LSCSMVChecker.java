import edu.wis.jtlv.env.spec.*;
import java.io.*;

/** Command line version of LSC SMV Model checker. */
public class LSCSMVChecker {

	/** Main method for command line application. Reads an input file and runs an LSCGame. 
	 * @returns 0 if there were no errors.
	 */
	public static void main(String[] args) 
		throws IOException,IllegalArgumentException {
		// Welcome message
		System.out.println("LSC SMV Model Checker initialized.");

		// input filename and available commands
		String file = "";
		boolean check = false;
		boolean synthesize = false;

		// Loop over command line arguments
		for(int i = 0; i < args.length; i++){
			if(args[i].equals("--check")){
				file = args[i+1];
				check=true;
			} else if(args[i].equals("--synthesize")){
				file = args[i+1];
				check = true;
				synthesize = true;
			} else if (args[i].equals("--help")){
				//TODO: Show help and exit
				System.exit(0);
			}
		}

		// If incorrect arguments were given, print usage instructions.
		if(!check && !synthesize || (file.equals(""))) {
			System.out.println("Please provide arguments on the following form:");
			System.out.println("    --check <file>              Check for realizability");
			System.out.println("    --synthesize <file>         Synthesize a controller");
			System.out.println("    --help                      Display help");
			System.exit(4);
		}

		// Read file contents 
		String model = "";
		try {
			BufferedReader input = new BufferedReader(new FileReader(file));
			while(input.ready())
				model += (char)input.read();
			input.close();
		} catch (IllegalArgumentException ex) {
			System.out.println("Error: Please provide a valid input file.");
			System.exit(3);
		} catch (IOException ex) {
			System.out.println("An error occurred reading the input file.");
			System.exit(3);
		}

		// Run the LSC Game
		try {
			LSCGame game = new LSCGame(model);
			// Realizability
			if(check){
				if(game.realizable()) {
					System.out.println("Model is realizable.");
				} else {
					System.out.println("Model is not realizable.");
					System.exit(1);
				}
			}
			// Synthesis
			if(synthesize){
				System.out.println(game.synthesize());
			}
		} catch(SpecException ex){
			System.out.println("Failed to create internal constraints on model (SMV module malformed)!");
			System.exit(2);
		} catch(IOException ex){
			System.out.println("Failed to load SMV model, please ensure that there is at least one message in each chart.");
			System.exit(2);
		}
		
		System.exit(0);
	}
}