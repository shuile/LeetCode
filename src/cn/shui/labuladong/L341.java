package cn.shui.labuladong;

import java.util.*;

/**
 * Created by chenyiting on 2022/5/19
 * 扁平化嵌套列表迭代器
 */
public class L341 {

    private static class NestedIterator3 implements Iterator<Integer> {

        private Deque<Iterator<NestedInteger>> stack;

        public NestedIterator3(List<NestedInteger> nestedList) {
            stack = new LinkedList<>();
            stack.push(nestedList.iterator());
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                Iterator<NestedInteger> iterator = stack.peek();
                if (!iterator.hasNext()) {
                    stack.pop();
                    continue;
                }
                NestedInteger next = iterator.next();
                if (next.isInteger()) {
                    List<NestedInteger> list = new ArrayList<>();
                    list.add(next);
                    stack.push(list.iterator());
                    return true;
                }
                stack.push(next.getList().iterator());
            }
            return false;
        }

        @Override
        public Integer next() {
            return stack.peek().next().getInteger();
        }
    }

    // dfs
    public static class NestedIterator2 implements Iterator<Integer> {

        private List<Integer> list;
        private Iterator<Integer> cur;

        public NestedIterator2(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            dfs(nestedList);
            cur = list.iterator();
        }

        @Override
        public boolean hasNext() {
            return cur.hasNext();
        }

        @Override
        public Integer next() {
            return cur.next();
        }

        private void dfs(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    list.add(nestedInteger.getInteger());
                } else {
                    dfs(nestedInteger.getList());
                }
            }
        }
    }

    public static class NestedIterator1 implements Iterator<Integer> {

        private final LinkedList<NestedInteger> linkedList;

        public NestedIterator1(List<NestedInteger> nestedList) {
            linkedList = new LinkedList<>(nestedList);
        }

        @Override
        public boolean hasNext() {
            while (!linkedList.isEmpty() && !linkedList.get(0).isInteger()) {
                List<NestedInteger> integerList = linkedList.get(0).getList();
                for (NestedInteger integer : integerList) {
                    linkedList.addFirst(integer);
                }
            }
            return !linkedList.isEmpty();
        }

        @Override
        public Integer next() {
            return linkedList.remove(0).getInteger();
        }
    }

    private interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }
}
