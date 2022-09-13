import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 测试虚拟机栈的溢出问题
 * 使用参数
 * 使用默认设置能够跑到38342
 * 修改-Xss256k能跑到1237
 * vm参数的修改要找一下选项
 */
public class demo01 {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        run(0);
        run2();
    }

    public static void run2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (int i = 0; i < 1000; i++) {
            Class<Integer> integerClass = Integer.class;
            Integer e = integerClass.getDeclaredConstructor(int.class).newInstance(1);
            System.out.println(e);
        }
    }
    public static void run(int i) throws InterruptedException {
        try {

        run(++i);

        } catch (Throwable e) {
            System.out.println(i);
//            e.printStackTrace();

        }
    }
}
