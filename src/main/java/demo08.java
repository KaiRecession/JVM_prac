import java.util.ArrayList;
/**
 *  def new generation   total 9216K 新生代9M的原因，to space认为是空的，用不上
 *   Eden: 1974K(8192K)->0K(8192K) 回收前（总容量）->回收后(总容量)
 *   大对象如果新生代放不下，老年代放得下就直接放到老年代
 *   如果新生代满了就直接放到老年代，这时就不看寿命了
 *   一个线程的OOM不会导致主线程停止
 */
import java.util.List;

public class demo08 {


        private static final int _512KB = 512 * 1024;
        private static final int _1MB = 1024 * 1024;
        private static final int _6MB = 6 * 1024 * 1024;
        private static final int _7MB = 7 * 1024 * 1024;
        private static final int _8MB = 8 * 1024 * 1024;

        // -Xms20m -Xmx20m -Xmn10m -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
        public static void main(String[] args) {
            List<byte[]> list = new ArrayList<>();
            list.add(new byte[_7MB]);
//            list.add(new byte[_1MB]);
//            list.add(new byte[_6MB]);
//            list.add(new byte[_512KB]);
//            list.add(new byte[_6MB]);
//            list.add(new byte[_512KB]);
//            list.add(new byte[_6MB]);
        }




}
