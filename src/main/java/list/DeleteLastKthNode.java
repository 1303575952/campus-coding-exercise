package list;

/**
 * 删除链表的倒数第k个结点
 */
public class DeleteLastKthNode {
    private ListNode solution(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;

        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        //倒数第k个是第一个
        if (p == null) {
            head = head.next;
            return head;
        }
        //当p达到尾部
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode node = new DeleteLastKthNode().solution(head, 6);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
