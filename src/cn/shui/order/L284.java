package cn.shui.order;

import java.util.Iterator;

/**
 * Created by chenyiting on 2022/11/13
 * 顶端迭代器
 */
public class L284 {
    private static class PeekingIterator implements Iterator<Integer> {

        private Iterator<Integer> iterator;
        private Integer nextElement;

        public PeekingIterator(Iterator<Integer> iterator) {
            // Initialize any member here.
            this.iterator = iterator;
            nextElement = iterator.next();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return nextElement;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            int temp = nextElement;
            nextElement = iterator.hasNext() ? iterator.next() : null;
            return temp;
        }

        @Override
        public boolean hasNext() {
            return nextElement != null;
        }
    }
}
