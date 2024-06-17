import org.utils.PaintGold;

/**
 * @program: MyGame
 * @ClassName MyTest
 * @description:
 * @author: Alice
 * @create: 2024-06-17 09:50
 * @Version 1.0
 **/
public class MyTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.random());
        }

        PaintGold paintGold = new PaintGold();
        paintGold.setX(1);
        paintGold.setY(1);
        System.out.println(paintGold.toString());
        paintGold.setX(2);
        paintGold.setY(2);
        System.out.println(paintGold.toString());

    }
}
