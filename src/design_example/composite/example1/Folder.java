package design_example.composite.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzqiuxm on 2015/12/4 0004.
 * 目录
 */
public class Folder implements Root {
    private String name;
    private List<Root> folder;

    public Folder(String name) {
        this.name = name;
        this.folder = new ArrayList<Root>();
    }

    @Override
    public boolean addFile(Root file) {
        return folder.add(file);
    }

    @Override
    public boolean removeFile(Root file) {
        return folder.remove(file);
    }

    @Override
    public List<Root> getFile() {
        return folder;
    }

    @Override
    public void display() {
        System.out.println(name);
        for (Root f : folder) {
            if (f instanceof Folder) {
                System.out.println("|   ");
            }
            f.display();
        }
    }
}
