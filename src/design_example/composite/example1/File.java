package design_example.composite.example1;

import java.util.List;

/**
 * Created by hzqiuxm on 2015/12/4 0004.
 * 叶子节点
 */
public class File implements Root{
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public boolean addFile(Root file) {
        return false;
    }

    @Override
    public boolean removeFile(Root file) {
        return false;
    }

    @Override
    public List<Root> getFile() {
        return null;
    }

    @Override
    public void display() {
        System.out.println("    |   "+name);
    }
}
