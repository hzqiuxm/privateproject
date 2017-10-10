package ziniuDesign.fd1_2.order;

/**
 * Created by hzqiuxm on 2015/12/1 0001.
 */
public class Order {

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWhid() {
        return whid;
    }

    public void setWhid(int whid) {
        this.whid = whid;
    }

    private int id;
    private int whid;
    private OrderState state;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", whid=" + whid +
                ", state=" + state +
                '}';
    }


}
