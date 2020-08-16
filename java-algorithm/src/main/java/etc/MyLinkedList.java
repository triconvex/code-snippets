package etc;

public class MyLinkedList {

    Node firstNode;

    public MyLinkedList(Node firstNode) {
        this.firstNode = firstNode;
    }

    Node read(int index) {
        Node currentNode = firstNode;
        int currentIndex = 0;

        while(currentIndex < index) {
            currentNode = currentNode.nextNode;
            currentIndex++;

            if(currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    int indexOf(int value) {
        Node currentNode = firstNode;
        int currentIndex = 0;

        while(true) {
            if(currentNode.data == value) {
                return currentIndex;
            }

            currentNode = currentNode.nextNode;
            currentIndex++;

            if(currentNode == null) {
                return -1;
            }
        }
    }

    void insertAtIndex(int index, int value) {
        Node currentNode = firstNode;
        int currentIndex = 0;

        while(currentIndex < index) {
            currentNode = currentNode.nextNode;
            currentIndex++;
        }

        Node newNode = new Node(value);
        newNode.nextNode = currentNode;
        currentNode.nextNode = newNode;
    }

    void deleteAtIndex(int index) {
        Node currentNode = firstNode;
        int currentIndex = 0;

        while(currentIndex < index - 1) {
            currentNode = currentNode.nextNode;
            currentIndex++;
        }
        // N-1 N(삭제하려는노드) N+1
        // N-1.nextNode = N+1
        // N node는 링크가 해제됨 = 삭제
        currentNode.nextNode = currentNode.nextNode.nextNode;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.nextNode = b;
        b.nextNode = c;
        c.nextNode = d;

        MyLinkedList list = new MyLinkedList(a);


    }

    private static class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
        }
    }

}

