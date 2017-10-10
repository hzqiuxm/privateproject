package ziniuDesign.fd3_2.cost;

/**
 * Created by hzqiuxm on 2016/1/25 0025.
 */
public class CostFactory {
    private CostFactory(){}

    public static ICost createICost(){
        return new CostService();
    }
}
