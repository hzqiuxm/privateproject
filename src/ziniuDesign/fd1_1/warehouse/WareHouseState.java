package ziniuDesign.fd1_1.warehouse;

public enum WareHouseState {
	waitPrepare("待备货"),waitOut("待出库");

	private String state;
	private WareHouseState(String state){
		this.state = state;
	}
	
	public String getState(){
		return this.state;
	}
}
