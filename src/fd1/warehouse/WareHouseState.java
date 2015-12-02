package fd1.warehouse;

/**
 * Created by hzqiuxm on 2015/12/1 0001.
 */
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
