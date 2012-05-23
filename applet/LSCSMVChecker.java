import edu.wis.jtlv.env.spec.*;
import edu.wis.jtlv.env.*;
import java.io.*;

/** Command line version of LSC SMV Model checker. */
public class LSCSMVChecker {
	/** Console progress reporter */
	private static class ConsoleProgressReporter implements ProgressReporter{		
		/** Handle information */
		public void report(String info){
			System.out.print(info);
		}
	}

	/** Main method for command line application. Reads an input file and runs an LSCGame. 
	 * @returns 0 if there were no errors.
	 */
	public static void main(String[] args) 
		throws IOException,IllegalArgumentException {
		// Welcome message
		System.out.println("LSC SMV Model Checker\n");
		System.out.println("Using: " + Env.getFactoryName() + "\n");
		
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
				System.out.println("");
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

		// Run the LSC Game
		try {
			// Load Transition System
			Env.loadModule(file);

			System.out.println("System: " + Env.getModule("main.env").trans().getFactory().getVersion() );

			LSCGame game = new LSCGame(new ConsoleProgressReporter());
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
			if(synthesize)
				System.out.println(game.synthesize());
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