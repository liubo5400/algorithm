package cn.lbo.learning.algorithm.practice;

/**
 * @Author bjliubo
 * @Date 2024/1/2 18:07
 * @PackageName:cn.lbo.learning.algorithm.practice
 * @ClassName: AddTwoNumbers
 * @Description: TODO
 * @Version 1.0
 */
public class AddTwoNumbers {

    private static ListNode l1;
    private static ListNode l2;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public void init(){
        l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(5,null))));
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.init();
        addTwoNumbers.addTwoNumbers(l1, l2);
    }

    public class ListNode {
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
