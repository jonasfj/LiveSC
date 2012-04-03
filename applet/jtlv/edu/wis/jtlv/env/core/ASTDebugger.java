/**
 * 
 */
package edu.wis.jtlv.env.core;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import org.antlr.runtime.tree.CommonTree;


/**
 * @author yaniv
 * 
 */
/**
 * @author Jörg Werner
 * 
 */
public class ASTDebugger extends JFrame {

	private static final long serialVersionUID = -92059391014955313L;

	public ASTDebugger(String lab, CommonTree t) {
		super(lab);

		JTree tree = new JTree(new ASTtoTreeModelAdapter(t));

		JScrollPane scrollPane = new JScrollPane(tree);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(scrollPane);

		Container content = getContentPane();
		content.add(panel, BorderLayout.CENTER);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Frame f = (Frame) e.getSource();
				f.setVisible(false);
				f.dispose();
				// System.exit(0);
			}
		});
	}

}