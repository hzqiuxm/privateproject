package fd1.warehouse;

/**
 * Created by hzqiuxm on 2015/12/1 0001.
 */
public class WHFactory {
    private WHFactory(){

    }

    //创建一个仓库对象实例
    public static IWareHouse createWareHouse(){
        return new WareHouseService();
    }
}
