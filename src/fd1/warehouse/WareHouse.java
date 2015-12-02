package fd1.warehouse;

/**
 * Created by hzqiuxm on 2015/12/2 0002.
 */
public class WareHouse {

    private int id;
    private String name;

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

    @Override
    public String toString() {
        return "WareHouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
