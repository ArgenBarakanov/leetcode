package linkedlist.leetcode_2;

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in
//reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//Example:
//
//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
//        Explanation: 342 + 465 = 807.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); //в нем храним ссылку на ответ
        ListNode p = l1, q = l2, curr = dummyHead; //указатель на новые узлы
        int carry = 0;//переносим в уме
        while (p != null || q != null){//пока оба не станут нулями
            int x = (p != null) ? p.val : 0;//если не равно нул то присваиваем значение в узле если нет то 0
            int y = (q != null) ? q.val : 0;//аналогично
            int sum = carry + x + y; //сумма переноса и двуч значений
            carry = sum / 10; //переписываем в перенос новое значение
            curr.next = new ListNode(sum % 10); //создаем новый узел и пихаем в него остаток по делению на 10
            curr = curr.next;//двигамем указатель
            if (p != null) p = p.next;//эти указатели тоже двигаем если они не null
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);//если перенос не пустой то создаем последний узел
        }
        return dummyHead.next;
    }

    public void showLinkedList(ListNode listNode){
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        Solution solution = new Solution();
        solution.showLinkedList(listNode1);
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode curr = start;
        int carry = 0;
        while (l1!= null || l2!= null || carry > 0){
            int l1N = l1 == null ? 0 : l1.val;
            int l2N = l2 == null ? 0 : l2.val;
            int sum = l1N + l2N + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return start.next;
    }
}
