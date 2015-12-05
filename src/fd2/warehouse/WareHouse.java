package fd2.warehouse;

/**
 * Created by hzqiuxm on 2015/12/5 0005.
 * 仓库和库区可以归为一类，都用该类表示
 */
public class WareHouse {
    private int id;
    private String name;
    //1-仓库，2-库区
    private int type;
    private int pId;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
    public int getpId() {
        return pId;
    }
    public void setpId(int pId) {
        this.pId = pId;
    }
    @Override
    public String toString() {
        return "WareHouse [id=" + id + ", name=" + name + ", type=" + type
                + ", pId=" + pId + "]";
    }
}