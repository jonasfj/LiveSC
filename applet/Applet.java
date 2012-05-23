import javax.swing.*;
import java.awt.Graphics;
import java.io.*;
import edu.wis.jtlv.env.spec.*;

/** Java applet for running and accessing the LSCGame class */
public class Applet extends JApplet{
	/** Most recently loaded LSCGame */
	private LSCGame _game;
	
	/** Initialize the applet (do nothing) */
	public void init() {}
	
	/** Load model from SMV translation
	 * @returns Empty string if successful
	 */
	public String loadSMV(String model){
		_game = null;
		try{
			_game = new LSCGame(model);
		}
		catch(SpecException ex){
			return "Failed to create internal constraints on model (SMV module malformed)!";
		}
		catch(IOException ex){
			return "Failed to load SMV model, please ensure that there is at least one message in each chart.";
		}
		return "";
	}
	
	/** Get game for the module
	 * @remarks null, if nothing loaded
	 */
	public LSCGame game(){
		return _game;
	}
}
