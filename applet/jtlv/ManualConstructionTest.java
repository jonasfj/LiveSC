
import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDException;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.module.FDSModule;

/**
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class ManualConstructionTest {
	public static void main(String[] args) {
		try {
			FDSModule env = new FDSModule("env", new String[] { "x", "y", "z" });
			FDSModule sys = new FDSModule("sys", new String[] { "x", "y", "z" });

			System.out.print("===========================\n");
			System.out.println(Env.getVar("sys", "x").getDomain().ithVar(1).toStringWithDomains(Env.stringer));
			System.out.println(Env.getVar("sys", "y").getDomain().ithVar(1).toStringWithDomains(Env.stringer));
			BDD b = sys.trans().andWith(
					Env.getVar("sys", "x").prime().getDomain().ithVar(1).imp(
							Env.getVar("sys", "y'").getDomain().ithVar(1)));
			System.out.println(b.toStringWithDomains(Env.stringer));
			System.out.print("===========================\n");
			
			System.out.print("=============================================\n");
			System.out.println(env);
			System.out.print("=============================================\n");
			System.out.println(sys);
			System.out.print("=============================================\n");
			System.out.println("");
			
			
			BDD t = Env.getVar("sys", "x").getDomain().ithVar(1).or(Env.getVar("sys", "y").getDomain().ithVar(1));
			System.out.println(t.toStringWithDomains(Env.stringer));
			BDD i = Env.getVar("sys", "x").getDomain().ithVar(1).imp(Env.getVar("sys", "y").getDomain().ithVar(1));
			System.out.println(i.toStringWithDomains(Env.stringer));
			
		} catch (BDDException e) {
			e.printStackTrace();
		}
	}

}
