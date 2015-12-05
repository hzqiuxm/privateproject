package design_example.visitor.example1;

/**
 * Created by hzqiuxm on 2015/12/4 0004.
 */
public class Client {

    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.attach(new Man());
        os.attach(new Woman());

        //当成功时，不同元素的不同反映
        Visitor success = new Success();
        os.display(success);

        //当恋爱时不同元素的不同反映
        Visitor love = new Love();
        os.display(love);
    }
}
