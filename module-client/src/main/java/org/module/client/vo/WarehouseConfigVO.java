package org.module.client.vo;

import org.module.common.po.WarehouseConfigPO;


public class WarehouseConfigVO {

			
			
			private String warehouseOfWhichTranCenter;
		    private String[] qus;
		    private String[] sizeOfQu;
			private String[] borderline;
			
			public WarehouseConfigPO toPO(){
				return new WarehouseConfigPO(this.warehouseOfWhichTranCenter,
						this.qus,this.sizeOfQu,this.borderline);
			}
			
			public WarehouseConfigVO(WarehouseConfigPO po){
				
				this.warehouseOfWhichTranCenter = po.getWarehouseOfWhichTranCenter();
				this.qus = po.getQus();
				this.sizeOfQu = po.getQus();
				this.borderline = po.getBorderline();
			}
			
			public String getWarehouseOfWhichTranCenter() {
				return warehouseOfWhichTranCenter;
			}
			public void setWarehouseOfWhichTranCenter(String warehouseOfWhichTranCenter) {
				this.warehouseOfWhichTranCenter = warehouseOfWhichTranCenter;
			}
			public String[] getQus() {
				return qus;
			}
			public void setQus(String[] qus) {
				this.qus = qus;
			}
			public String[] getSizeOfQu() {
				return sizeOfQu;
			}
			public void setSizeOfQu(String[] sizeOfQu) {
				this.sizeOfQu = sizeOfQu;
			}
			public String[] getBorderline() {
				return borderline;
			}
			public void setBorderline(String[] borderline) {
				this.borderline = borderline;
			}
			public WarehouseConfigVO(String warehouseOfWhichTranCenter,
					String[] qus, String[] sizeOfQu, String[] borderline) {
				super();
				this.warehouseOfWhichTranCenter = warehouseOfWhichTranCenter;
				this.qus = qus;
				this.sizeOfQu = sizeOfQu;
				this.borderline = borderline;
			}
}
