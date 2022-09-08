/**
 * 测试虚拟机栈的溢出问题
 * 使用参数
 * 使用默认设置能够跑到38342
 * 修改-Xss256k能跑到1237
 * vm参数的修改要找一下选项
 */
public class demo01 {
    public static void main(String[] args) throws InterruptedException {
        run(0);
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
