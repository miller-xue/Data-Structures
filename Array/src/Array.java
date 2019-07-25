
// 元素
public class Array<E> {

    private E[] data;

    /**
     * 数组中有多少个有效元素
     */
    private int size;

    /**
     * 数组默认大小10
     */
    private static final int INIT_CAPACITY = 10;

    /**
     * 构造函数，传入数组容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity) {
//        data = new E[capacity]; java不允许直接new 泛型类型数组，历史遗留问题
        data = (E[]) new Object[capacity];
        size = 0;
    }
    /**
     * 构造函数，传入数组容量10
     */
    public Array() {
        this(INIT_CAPACITY);
    }

    public Array(E[] data) {
        this.data = data;
        this.size = data.length;
    }

    /**
     * 获取数组中元素的个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新的元素
     * @param e 新的元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e){
        add(0, e);
    }


    /**
     * 在第index位置插入一个新的元素e
     *
     * @param index 位置
     * @param e     新元素
     */
    public void add(int index, E e) {
        // 判断数组指定位置是否超出
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        // 判断数组容量
        if (size == data.length)
            resize(2 * getCapacity());
//            throw new IllegalArgumentException("Add failed. Array is full.");
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = e;
        size++;
    }

    /**
     *
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) { // TODO 用System.arraycopy
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 获得指定位置新元素
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    /**
     * 修改指定位置的元素
     * @param index 指定位置
     * @param e 新元素
     */
    public void set(int index, E  e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] .equals(e) )
                return i;
        }
        return -1;
    }

    public int[] findAll(int e) {
        // TODO
        return null;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("remove failed. Index is illegal.");
        E ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size --;
        data[size] = null; // TODO 对象的垃圾回收  loitering objects != memory leak
        if(size == data.length /2)
            resize(data.length / 2);
        return ret;
    }

    /**
     * 从数组中删除第一个元素，返回删除的元素
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素，返回删除的元素
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e（存在删除第一个）
    public void removeElement(E e) {
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    public void removeAllElement(int e){
        // TODO
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, getCapacity()));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i < size-1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
