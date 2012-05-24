import javax.swing.*;
import java.awt.Graphics;
import java.io.*;
import edu.wis.jtlv.env.spec.*;
import edu.wis.jtlv.env.*;
import netscape.javascript.*;
         
/** Java applet for running and accessing the LSCGame class */
public class Applet extends JApplet{

	/** Javascript progress reporter */
	private class JSProgressReporter implements ProgressReporter{
		/** document.window object */
		JSObject window;
		
		/** Initialize progress reporter for given window */
		public JSProgressReporter(JSObject window){
			this.window = window;
		}
		
		/** Handle information */
		public void report(String info){
			this.window.eval("reportProgress(\"" + info + "\");");
		}
	}

	/** Progress reporter for use with this object */
	JSProgressReporter reporter;

	/** Most recently loaded LSCGame */
	private LSCGame _game;
	
	/** Initialize the applet (do nothing) */
	public void init() {
		reporter = this.new JSProgressReporter(JSObject.getWindow(this));
	}
	
	/** Load model from SMV translation
	 * @returns Empty string if successful
	 */
	public boolean loadSMV(String model){
		_game = null;
		try{
			if(reporter != null)
				reporter.report("Resetting BDD environment...\\n");
			
			// Reset the environment, invalidating all the instances of LSCGame
			Env.resetEnv();

			if(reporter != null)
				reporter.report("Loading transition system from SMV model...\\n");
		
			// Load Transition System
			Env.loadSMVModuleFromString(model);

			if(reporter != null)
				reporter.report("Transition sytem loaded!\\n");

			_game = new LSCGame(reporter);
		}
		catch(SpecException ex){
			if(reporter != null)
				reporter.report("Failed to create internal constraints on model (SMV module malformed)!\\n");
			return false;
		}
		catch(IOException ex){
			if(reporter != null)
				reporter.report("Failed to load SMV model, please ensure that there is at least one message in each chart!\\n");
			return false;
		}
		return true;
	}
	
	/** Get game for the module
	 * @remarks null, if nothing loaded
	 */
	public LSCGame game(){
		return _game;
	}
}
