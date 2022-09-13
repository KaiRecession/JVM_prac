/**
 * 堆内存的溢出
 * 默认堆内存的设置能够跑到532254060
 * 使用-Xmx8m后，只能够跑到540217
 */

import java.util.ArrayList;

public class demo02 {
    public static void main(String[] args) {

        int i = 0;
        try {
            ArrayList<String> list = new ArrayList<>();
            String a = "woc";
            while (true) {
                list.add(a);
//                a = a + a;
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
