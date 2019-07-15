import java.util.ArrayList;

public class Main {
    /**
     * 数组的最大优点：快速查询
     * 数组最好应用于“索引有语意”的情况
     *
     * 但并非所有有语意的索引都是用于数组
     * 数组也可以处理“索引没有语意”的情况
     * @param args
     */
    public static void main(String[] args) {
        Array arr = new Array(20);
        for (int i = 0; i < 10; i++)
            arr.addLast(i);
        System.out.println(arr);
        arr.add(1, 100);
        System.out.println(arr);
        arr.addFirst(-1);
        System.out.println(arr);
    }
}
