package org.module.client.presentation.managementui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;

public class Line extends JPanel {

	/**
	 * Create the panel.
	 */
	public Line() {
		setLayout(new BorderLayout(0, 0));
		
		JCheckBox checkBox = new JCheckBox("");
		add(checkBox, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);

	}

}
