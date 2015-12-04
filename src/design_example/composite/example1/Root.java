package design_example.composite.example1;

import java.util.List;

/**
 * Created by hzqiuxm on 2015/12/4 0004.
 * Root接口
 */
public interface Root {
    public boolean addFile(Root file);
    public boolean removeFile(Root file);
    public List<Root> getFile();
    public void display();

}
