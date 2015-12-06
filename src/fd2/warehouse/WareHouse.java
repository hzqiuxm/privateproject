package fd2.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hzqiuxm on 2015/12/5 0005.
 * 仓库和库区可以归为一类，都用该类表示,组合模式中扮演节点类角色
 */
public class WareHouse extends Component{

    List<Component> listChildren = new ArrayList<Component>();
    private String name;
    //1-仓库，2-库区
    private int type;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public List<Component> getListChildren() {
        return listChildren;
    }

    @Override
    public String toString() {
        return "WareHouse [id=" + this.getId() + ", name=" + name + ", type=" + type
                + ", pId=" + this.getpId() + "]";
    }

    public void addChild(Component c){
        listChildren.add(c);
    }

    public void removeChild(Component c){
        listChildren.remove(c);
    }

    public Component getChildren(int index){
        return listChildren.get(index);

    }

    //获取所有使用的堆位
    public Map<Integer,Integer> allUseGrids(Map<Integer,Integer> map){
        //计算某一个库区下的所有使用的grid = 下面一级库区使用的grid数 + 下面一级使用的grid数
        int count = 0;
        for(Component c : this.listChildren){
            Map<Integer,Integer> map2 = new HashMap<Integer, Integer>();
            map2 = c.allUseGrids(map2);

            map.putAll(map2);

            for(int key : map2.keySet()){
                //必须判断是本节点的下一层，不再嵌套计算
                //有两种情况
                if((this.getId()==key) //节点本身就是grid时候
                        || isChild(key)){  //是自己的子节点才加进去
                    count += map2.get(key);
                }
            }
        }
        map.put(this.getId(),count);
        return map;
    }

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }

    private boolean isChild(int id){
        for(Component c : this.listChildren){
            if(c.getId() == id){
                return true;
            }
        }
        return false;
    }


}
