package org.module.client.presentation.managementui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.module.client.presentation.FontFactory;

public class CityAndPrice extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private FontFactory font;
	public CityAndPrice() {
		font = new FontFactory();
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setOpaque(false);
		tabbedPane.setFont(font.getTabbeFont());
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new City();
		panel.setOpaque(false);
		tabbedPane.addTab("所有城市", null, panel, "所有城市");
		
		JPanel panel_1 = new Price();
		panel_1.setOpaque(false);
		tabbedPane.addTab("城际运费", null, panel_1, "城际运费");

	}

}
