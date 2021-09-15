package cn.shui.learning_plan.datastruct_basic.twelfth;

/**
 * @author shui.
 * @date 2021/9/13.
 * @time 22:18.
 * 设计链表
 */
public class L707 {

    public static void main(String[] args) {
        String[] methods = {"MyLinkedList", "addAtHead", "addAtTail", "addAtTail", "get", "get", "addAtTail", "addAtIndex", "addAtHead", "addAtHead", "addAtTail", "addAtTail", "addAtTail", "addAtTail", "get", "addAtHead", "addAtHead", "addAtIndex", "addAtIndex", "addAtHead", "addAtTail", "deleteAtIndex", "addAtHead", "addAtHead", "addAtIndex", "addAtTail", "get", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "get", "deleteAtIndex", "addAtTail", "addAtTail", "addAtHead", "addAtTail", "get", "deleteAtIndex", "addAtTail", "addAtHead", "addAtTail", "deleteAtIndex", "addAtTail", "deleteAtIndex", "addAtIndex", "deleteAtIndex", "addAtTail", "addAtHead", "addAtIndex", "addAtHead", "addAtHead", "get", "addAtHead", "get", "addAtHead", "deleteAtIndex", "get", "addAtHead", "addAtTail", "get", "addAtHead", "get", "addAtTail", "get", "addAtTail", "addAtHead", "addAtIndex", "addAtIndex", "addAtHead", "addAtHead", "deleteAtIndex", "get", "addAtHead", "addAtIndex", "addAtTail", "get", "addAtIndex", "get", "addAtIndex", "get", "addAtIndex", "addAtIndex", "addAtHead", "addAtHead", "addAtTail", "addAtIndex", "get", "addAtHead", "addAtTail", "addAtTail", "addAtHead", "get", "addAtTail", "addAtHead", "addAtTail", "get", "addAtIndex"};
        int[][] values = {{}, {84}, {2}, {39}, {3}, {1}, {42}, {1, 80}, {14}, {1}, {53}, {98}, {19}, {12}, {2}, {16}, {33}, {4, 17}, {6, 8}, {37}, {43}, {11}, {80}, {31}, {13, 23}, {17}, {4}, {10, 0}, {21}, {73}, {22}, {24, 37}, {14}, {97}, {8}, {6}, {17}, {50}, {28}, {76}, {79}, {18}, {30}, {5}, {9}, {83}, {3}, {40}, {26}, {20, 90}, {30}, {40}, {56}, {15, 23}, {51}, {21}, {26}, {83}, {30}, {12}, {8}, {4}, {20}, {45}, {10}, {56}, {18}, {33}, {2}, {70}, {57}, {31, 24}, {16, 92}, {40}, {23}, {26}, {1}, {92}, {3, 78}, {42}, {18}, {39, 9}, {13}, {33, 17}, {51}, {18, 95}, {18, 33}, {80}, {21}, {7}, {17, 46}, {33}, {60}, {26}, {4}, {9}, {45}, {38}, {95}, {78}, {54}, {42, 86}};
        MyLinkedList test = null;
        for (int i = 0; i < methods.length; i++) {
            switch (methods[i]) {
                case "MyLinkedList":
                    test = new MyLinkedList();
                    break;
                case "addAtHead":
                    test.addAtHead(values[i][0]);
                break;
                case "addAtIndex":
                    test.addAtIndex(values[i][0], values[i][1]);
                break;
                case "deleteAtIndex":
                    test.deleteAtIndex(values[i][0]);
                break;
                case "get":
                    System.out.println(test.get(values[i][0]));
                break;
                case "addAtTail":
                    test.addAtTail(values[i][0]);
                break;
            }
        }
    }

    private static class MyLinkedList {

        private final ListNode head;
        private int length;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            head = new ListNode();
            length = 0;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index < 0 || index >= length) {
                return -1;
            }
            ListNode p = head;
            for (int i = 0; i <= index; i++) {
                p = p.next;
            }
            return p.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node
         * will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            addAtIndex(length, val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
         * list, the node will be appended to the end of linked list. If the index is greater than the length, the node
         * will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > length) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            length++;
            ListNode p = head;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            ListNode node = new ListNode(val);
            node.next = p.next;
            p.next = node;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= length) {
                return;
            }
            length--;
            ListNode pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
        }

        private static class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }
    }
}
