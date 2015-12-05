package org.module.client.presentation.orderui;

import org.module.client.businesslogic.orderbl.TranCenterLoadingController;
import org.module.client.businesslogicservice.orderBLservice.TranCenterLoadingBLService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class TranCenterLoadListPanel extends OfficeLoadListPanel {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 7656037111486587285L;

	private TranCenterLoadingBLService controller = new TranCenterLoadingController();
	/**
	 * Create the panel.
	 */
	public TranCenterLoadListPanel() {
		super();
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] shippingId = TranCenterLoadListPanel.this.shippingId();
				if(shippingId!=null){
					controller.creat(timerPicker.getDate().getTime()+"", 
						officeID.getText(), 
						TrucksNumber.getText(), 
						city.getSelectedItem().toString(),
						location.getText(), 
						carID.getText(), 
						monitor.getText(),
						escort.getText(), 
						shippingId, 
						price.getText()
						);
				}
			}
		});
		labelOfDepartment.setText("中转中心号");
	}
		
		
}
