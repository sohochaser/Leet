package com.leet.list.merge;

/**
 * 最小堆
 * 
 * @since jdk1.5及其以上
 * @author 毛正吉
 * @version 1.0
 * @date 2010.05.24
 */
public class MinHeap {
    private Node[] heapArray; // 堆容器

    private int maxSize; // 堆得最大大小

    private int currentSize; // 堆大小

    public MinHeap(int _maxSize) {
        maxSize = _maxSize;
        heapArray = new Node[maxSize];
        currentSize = 0;
    }

    /**
     * 自上而下调整
     * 
     * @param start
     * @param endOfHeap
     */
    public void filterDown(int start, int endOfHeap) {
        int i = start;
        int j = 2 * i + 1; // j是i的左子女位置
        Node temp = heapArray[i];

        while (j <= endOfHeap) { // 检查是否到最后位置
            if (j < endOfHeap // 让j指向两子女中的小者
                && heapArray[j].getKey() > heapArray[j + 1].getKey()) {
                j++;
            }
            if (temp.getKey() <= heapArray[j].getKey()) { // 小则不做调整
                break;
            } else { // 否则小者上移，i，j下降
                heapArray[i] = heapArray[j];
                i = j;
                j = 2 * j + 1;
            }
        }
        heapArray[i] = temp;
    }

    /**
     * 自下而上的调整:从结点start开始到0为止，自下向上比较，如果子女的值小于双亲结点的值则互相交换
     * 
     * @param start
     */
    public void filterUp(int start) {
        int j = start;
        int i = (j - 1) / 2;
        Node temp = heapArray[j];

        while (j > 0) { // 沿双亲结点路径向上直达根节点
            if (heapArray[i].getKey() <= temp.getKey()) {// 双亲结点值小，不调整
                break;
            } else {// 双亲结点值大，调整
                heapArray[j] = heapArray[i];
                j = i;
                i = (i - 1) / 2;
            }
            heapArray[j] = temp; // 回送
        }
    }

    /**
     * 堆中插入结点
     * 
     * @param key
     * @return
     * @throws MinHeapException
     */
    public boolean insert(int key) throws MinHeapException {
        boolean bool = true;
        if (isFull()) {
            bool = false;
            throw new MinHeapException("MinHeap is full!");
        } else {
            Node newNode = new Node(key);
            heapArray[currentSize] = newNode;
            filterUp(currentSize);
            currentSize++;
        }
        return bool;
    }

    /**
     * 删除堆中的最小值
     * 
     * @return
     * @throws MinHeapException
     */
    public Node removeMin() throws MinHeapException {
        if (isEmpty()) {
            throw new MinHeapException("MinHeap is empty!");
        }
        Node root = heapArray[0];
        heapArray[0] = heapArray[currentSize - 1];
        currentSize--;
        filterDown(0, currentSize - 1);
        return root;
    }

    /**
     * 按某种格式输出堆
     */
    public void displayHeap() {
        System.out.print("heapArray: ");
        for (int i = 0; i < currentSize; i++) {
            if (heapArray[i] != null) {
                System.out.print(heapArray[i].getKey() + " ");
            } else {
                System.out.print("-- ");
            }
        }
        System.out.println();

        int nBlanks = 32; // heap format
        int itemsPerRow = 1;
        int column = 0;
        int j = 0; // current item
        String dots = "...............................";
        System.out.println(dots + dots); // dotted top line

        while (currentSize > 0) { // for each heap item
            if (column == 0) { // first item in row
                for (int k = 0; k < nBlanks; k++) { // preceding blanks
                    System.out.print(" ");
                }
            }
            System.out.print(heapArray[j].getKey()); // display item

            if (++j == currentSize) { // done?
                break;
            }

            if (++column == itemsPerRow) { // end of row?
                nBlanks /= 2; // half the blanks
                itemsPerRow *= 2; // twice the items
                column = 0; // start over on
                System.out.println(); // next row
            } else { // next item on row
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(' '); // interim blanks
                }
            }
        }
        System.out.println("\n" + dots + dots);
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public void makeEmpty() {
        currentSize = 0;
    }
}