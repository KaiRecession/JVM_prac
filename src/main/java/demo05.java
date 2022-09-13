/**
 * Stringtable的垃圾回收
 *  -Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
 *  从打印出来的信息可以看到Number of entries为串池中的个数
 *  所以说StringTable里面的对象也会被垃圾回收回收
 */
public class demo05 {
        public static void main(String[] args) {
            Object test = new Object();

            int i = 0;
            try {
                for(int j = 0; j < 100000; j++) { // j = 100, j = 10000
                    String.valueOf(j).intern();
                    i++;
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.out.println(i);
            }
        }


}

class a {
    @Override
    protected void finalize() {
        System.out.println("对象即将被销毁");
    }
    }
