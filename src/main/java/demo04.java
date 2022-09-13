public class demo04 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
//        String test2 = "woc";
        // 这样子拼接出来的对象不会放入串池
        String test = new String("woc") + new String("c");
        // intern，串池中没有就放入返回，有就不放入。无论放入是否成功，都会返回串池中的字符串对象
        String ss = test.intern();
        System.out.println(test == ss);
//        String test = new String("wo") + new String("c");


        String s3 = "ab";
        // 拼接的时候，从stringtable取出之后，拼接，返回了一个新的对象，所以和stringtable中的ab对象不同
        String s4 = s1 + s2;
//        System.out.println(s1 == s4);
        String s5 = "a" + "b";
        System.out.println(s3 == s5);

    }
}
