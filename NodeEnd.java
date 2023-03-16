/* Remove an Element from nth Node from the end... Only to be done in a Single Iteration...
 * Eg 1: Input = [1, 2, 3, 4]   n = 2       Output = [1, 2, 4]
 * Eg 2: Input = [1, 2]         n = 1       Output = [1]
 * Eg 3: Input = [1]            n = 1       Output = []
 */
import java.util.*;
public class NodeEnd
{
    public class Node
    {
        public int data;
        public Node next;
        public Node(int val)     // Parametrized Constructor...
        {
            this.data = val;
            this.next = null;
        }
        public Node(int val, Node Next)   // Parametrized Constructor...
        {
            this.data = val;
            this.next = Next;
        }
    }
    Node head;
    public void InsertNode(int val)
    {
        Node n = new Node(val);
        if(head == null)
        {
            head = n;
            return;
        }
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = n;
        n.next = null;
        return;
    }
    public void Print()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+", ");
            temp = temp.next;
        }
        System.out.println("null");
        return;
    }
    public void RemoveFromEnd(int k)
    {
        Node temp = head;
        int loop = 0;
        if(temp.next == null)   // If there is only one Node...
        {
            head = null;
            return;
        }
        while(loop < k)   // We move th first pointer forward...
        {
            loop++;
            temp = temp.next;
        }
        temp = temp.next;    // Now we start the second pointer simultaneously from beginning...
        Node temp1 = head;
        while(temp != null)   // When first reaches the end, the second is exactly k nodes away...
        {
            temp = temp.next;
            temp1 = temp1.next;
        }
        temp1.next = temp1.next.next;    // We remove the Node by updation...
        System.out.println("The Node is removed !!");
        return;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x, a;
        System.out.print("Enter the size of the Linked list : ");
        x = sc.nextInt();
        NodeEnd node = new NodeEnd();
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter data : ");
            a = sc.nextInt();
            node.InsertNode(a);
        }
        System.out.println("The linked list formed is : ");
        node.Print();
        System.out.print("Enter the node position from end to be removed : ");
        x = sc.nextInt();
        node.RemoveFromEnd(x);
        System.out.println("The Linked List formed is : ");
        node.Print();
        sc.close();
    }
}

// Optimal Time Complexity  - O(n) time...
// Optimal Space Complexity - O(n) space...