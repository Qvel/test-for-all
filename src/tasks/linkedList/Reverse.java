package tasks.linkedList;

public class Reverse {

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;      // Зберігаємо наступний елемент
            current.next = prev;      // Змінюємо наступний вказівник поточного елемента
            prev = current;           // Переміщаємо вказівник prev на поточний елемент
            current = next;           // Переходимо до наступного елемента
        }

        head = prev;                  // Оновлюємо голову списку
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = reverse(head);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
