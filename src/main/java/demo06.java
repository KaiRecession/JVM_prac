import java.io.IOException;
import java.util.ArrayList;

/**
 * 分析一下可达性分析算法，那些对象可以作为GC Root
 * 第一步：使用名平jps查看当前java进程pid
 * 第二步： jmap -dump:format=b,live,file=1.bin 7145 b代表二进制，live代表当前的存活对象（会进行一次垃圾回收然后在看存活对象），file存储文件名字， 最后跟上pid
 * 第三步：按回车，再次执行，将文件存为2.bin
 * 第四步：打开分析就行
 */
public class demo06 {
    public static void main(String[] args) throws IOException {

        ArrayList<Object> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add(1);
        System.out.println(1);
        // 这个read是暂停操作
        System.in.read();

        list = null;
        System.out.println(2);
        System.in.read();
        System.out.println("end");
    }
}
