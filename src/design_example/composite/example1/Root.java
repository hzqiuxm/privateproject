package design_example.composite.example1;

import java.util.List;

/**
 * Created by hzqiuxm on 2015/12/4 0004.
 * Root接口,构造一个目录/文件关系  采用透明模式（非安全模式）
 */
public interface Root {
    public boolean addFile(Root file);
    public boolean removeFile(Root file);
    public List<Root> getFile();
    public void display();

}
