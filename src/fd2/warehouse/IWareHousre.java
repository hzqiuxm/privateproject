package fd2.warehouse;

import java.util.Map;

/**
 * Created by hzqiuxm on 2015/12/5 0005.
 */
public interface IWareHousre {
    //	public int useGrids(int id);
    //	public int unUseGrids(int id);
    //key-WareHouse的id ， value-该WareHouse下所有已经使用的grid的数量
    public Map<Integer,Integer> allUseGrids(Map<Integer,Integer> map);

    public Map<Integer,Integer> allUnUseGrids(Map<Integer,Integer> map);
}
