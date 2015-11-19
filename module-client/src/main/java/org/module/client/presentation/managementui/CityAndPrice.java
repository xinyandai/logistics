package org.module.client.presentation.managementui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

public class CityAndPrice extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CityAndPrice() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new City();
		tabbedPane.addTab("所有城市", null, panel, null);
		
		JPanel panel_1 = new Price();
		tabbedPane.addTab("城际运费", null, panel_1, null);

	}

}
