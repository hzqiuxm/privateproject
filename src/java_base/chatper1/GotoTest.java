package java_base.chatper1;

/**
 * Created by qiuding on 16/1/18.
 */
public class GotoTest {
    public static void main(String[] args) {
        int[][] array = {
                {1,20,38},
                {28,90},
                {60,46,71,100}
        };
//        int goto  = 0;
        int number = 0;
        outer:
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                System.out.println(array[i][j]);
                number++;
                if(5==number){
                    break outer;
                }
            }
        }
        here:
        System.out.println(number);
    }

}
