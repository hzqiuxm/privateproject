package fd2.warehouse;

import java.util.Map;

/**
 * Created by hzqiuxm on 2015/12/6 0006.
 */
public abstract class Component {
    private int id;
    private int pId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public void addChild(Component c){
        throw new UnsupportedOperationException("对象不支持该操作");
    }

    public void removeChild(Component c){
        throw new UnsupportedOperationException("对象不支持该操作");
    }

    public Component getChildren(int index){
        throw new UnsupportedOperationException("对象不支持该操作");
    }

    //获取所有使用的堆位
    public Map<Integer,Integer> allUseGrids(Map<Integer,Integer> map){
        throw new UnsupportedOperationException("对象不支持该操作");
    }

    //接收访问者对象
    public abstract Object accept(Visitor v);
}
