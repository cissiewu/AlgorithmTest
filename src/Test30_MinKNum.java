package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: AlgorithmTest2
 * Package: com.company
 *
 * @author : cissie
 * @date : 2018/9/14 15:43
 */
public class Test30_MinKNum {
    /*
    * 输入n个整数，找出其中最小的k个数
    * 解法一：o(n)时间算法，只有可以修改输入数组时可用
    * 基于partition函数来解决。如果基于数组的第k个数字来调整，使得比第k个数字小的所有数字都位于
    * 数组左边，比第k个数字大的所有数字都位于数组的右边，这样调整之后，位于数组中左边的k个数字就是最小的k个数字
    *
    * 解法二：n（nlogk）算法，适合处理海量数据
    * 先创建一个小大为k的数据容器来存储最小的k个数字，然后每次从输入的n个整数中读入一个数。如果容器中
    * 已经有的数字少于k个，则直接把这次读入的整数放入容器中，如果容器中已有k个数字，找出这个已有k数字的最大值，然后将
    * 带插入的和最大值比较，如果待插入的值小于最大值，则替换。
    * 当容器满时，做3件事：一是在k个整数中找打最大数，二十有可能在这个容器中删除最大数；三是有可能要插入
    * 一个新的数字。可以使用一个大顶堆在o（logk）时间内实现这三步操作。
    * */

    private final static class MaxHeap<T extends Comparable<T>>{
        //堆中元素存放的集合
        private List<T> items;
        //用于计数
        private int cursor;
        /*
        * 构造一个堆，初始大小是32
        * */
        public MaxHeap(){
            this(32);
        }
        public MaxHeap(int size){
            items = new ArrayList<>(size);
            cursor=-1;
        }
        //向上调整堆
        //@param index 被上移元素的起始位置
        public void siftUp(int index){
            T intent = items.get(index);//获取开始调整的元素对象

            while(index>0){
                int parentIndex = (index-1)/2 ;//找父元素对象的位置
                T parent =items.get(parentIndex);//获取父元素对象
                if(intent.compareTo(parent)>0){//上移条件，子节点比父节点大
                    items.set(index,parent);//将父节点向下放
                    index=parentIndex;//记录父节点下放的位置
                }else{
                    break;//子节点不比父节点大，说明父子路径已经按从大到小排好顺序了
                }
            }

            // index此时记录是的最后一个被下放的父节点的位置（也可能是自身），所以将最开始的调整的元素值放入index位置即可

            items.set(index,intent);
        }

        /*
        * 向下调整堆
        * @param index 被下移的元素的起始位置
        * */
        public void siftDown(int index){
            T intent = items.get(index);//获取开始调整的元素对象
            int leftIndex=2*index+1;//获取开始调整的元素对象的左子节点的元素

            while(leftIndex<items.size()){//如果有左子节点
                T maxChild=items.get(leftIndex);//取左子节点的元素对象，并假定其为两个子结点中最大的
                int maxIndex=leftIndex;//两个子节点中最大节点元素的位置，假定开始时为左子节点的位置

                int rightIndex=leftIndex+1;//获取右子节点的位置
                if(rightIndex<items.size()){
                    //如果有右子节点，获取右子节点的元素对象，找出两个子节点中的最大子节点
                    T rightChild=items.get(rightIndex);
                    if(rightChild.compareTo(maxChild)>0){
                        maxChild=rightChild;
                        maxIndex=rightIndex;
                    }
                }

                //如果最大子节点比父节点大，则需要向下调整
                if(maxChild.compareTo(intent)>0){
                    items.set(index,maxChild);//将子节点向上移
                    index=maxIndex;//记录上移节点的位置
                    leftIndex=index*2+1;//找到上移节点的左子节点的位置
                }else{
                    break;
                }
                items.set(index,intent);
            }

        }

        /**
         * 向堆中添加一个元素
         *
         * @param item 等待添加的元素
         */
        public void add(T item) {
            items.add(item); // 将元素添加到最后
            siftUp(items.size() - 1); // 循环上移，以完成重构
        }

        /**
         * 删除堆顶元素
         *
         * @return 堆顶部的元素
         */
        public T deleteTop() {
            if (items.isEmpty()) { // 如果堆已经为空，就报出异常
                throw new RuntimeException("The heap is empty.");
            }

            T maxItem = items.get(0); // 获取堆顶元素
            T lastItem = items.remove(items.size() - 1); // 删除最后一个元素
            if (items.isEmpty()) { // 删除元素后，如果堆为空的情况，说明删除的元素也是堆顶元素
                return lastItem;
            }

            items.set(0, lastItem); // 将删除的元素放入堆顶
            siftDown(0); // 自上向下调整堆
            return maxItem; // 返回堆顶元素
        }

        /**
         * 获取下一个元素
         *
         * @return 下一个元素对象
         */
        public T next() {

            if (cursor >= items.size()) {
                throw new RuntimeException("No more element");
            }
            return items.get(cursor);

        }

        /**
         * 判断堆中是否还有下一个元素
         *
         * @return true堆中还有下一个元素，false堆中无下五元素
         */
        public boolean hasNext() {
            cursor++;
            return cursor < items.size();
        }

        /**
         * 获取堆中的第一个元素
         *
         * @return 堆中的第一个元素
         */
        public T first() {
            if (items.size() == 0) {
                throw new RuntimeException("The heap is empty.");
            }
            return items.get(0);
        }

        /**
         * 判断堆是否为空
         *
         * @return true是，false否
         */
        public boolean isEmpty() {
            return items.isEmpty();
        }

        /**
         * 获取堆的大小
         *
         * @return 堆的大小
         */
        public int size() {
            return items.size();
        }

        /**
         * 清空堆
         */
        public void clear() {
            items.clear();
        }

        @Override
        public String toString() {
            return items.toString();
        }
    }
}
