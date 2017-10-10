package ziniuDesign.fd1_2.order;

/**
 * Created by hzqiuxm on 2015/12/1 0001.
 */
public enum OrderState {

    waitCheck("待处理"),valid("有效"),waitDispatch("待分单"),invalid("无效"),
    waitPrepare("待备货"),waitOut("待出库"),transport("运输中"),
    waitSend("待送货"),signed("已签收"),waitFinance("待对帐"),over("处理完成");

    private String state;
    private  OrderState(String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }

    public static void main(String[] args) {
        System.out.println(OrderState.waitFinance.getState());
        Order o1 = new Order();
        o1.setState(OrderState.signed);
        System.out.println(o1.getState());
        System.out.println(o1.getState().state);
        System.out.println("已签收".equals(o1.getState().state));
    }
}
