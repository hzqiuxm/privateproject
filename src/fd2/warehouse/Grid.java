package fd2.warehouse;

import java.util.Map;

/**
 * Created by hzqiuxm on 2015/12/5 0005.
 * 堆位类,在组合模式中扮演叶子节点
 */
public class Grid extends Component{

    private String desc;
    //使用状态 0 - 未使用 1- 已使用
    private int usestate = 0;

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getUseState() {
        return usestate;
    }

    public void setUseState(int usestate) {
        this.usestate = usestate;
    }

    @Override
    public String toString() {
        return "Grid [id=" + this.getId() + ", desc=" + desc + ", pId=" + this.getpId() + ", usestate = "+this.usestate+"]";
    }

    public Map<Integer,Integer> allUseGrids(Map<Integer,Integer> map){
        Object obj = map.get(this.getpId());
        int count = 0;
        if(null != obj){
           count = (Integer)obj;
        }

        if(this.getUseState() == 1){
            map.put(this.getpId(),count+1);
        }else{
            map.put(this.getpId(),count);
        }

        return map;
    }

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
