package design_example.composite.example1;

/**
 * Created by hzqiuxm on 2015/12/4 0004.
 */
public class Client1 {

    public static void main(String[] args) {
        //构造一个目录
        Root root1 = new Folder("c://");
        Root root2 = new Folder("d://");

        Root win = new File("windows");
        Root sys = new File("system");
        Root hw = new File("hello world");

        root1.addFile(win);
        root2.addFile(sys);
        win.addFile(hw);

        root1.display();
        root2.display();
    }




}
