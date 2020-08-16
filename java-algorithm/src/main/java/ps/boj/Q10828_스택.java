//package ps.boj;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Q10828_스택 {
//
//    public static void main(String[] args) throws IOException {
//        MyArrayStack<Integer> stack = new MyArrayStack<>();
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int numberOfLines = Integer.parseInt(br.readLine());
//        for(int i = 0; i < numberOfLines; i++) {
//            String command = br.readLine();
//            if(command.startsWith("push")) {
//                stack.push(Integer.parseInt(commnd.split(" ")[1]));
//            }
//
//            if(command.equals("top")) {
//                stack.peek();
//            }
//
//            if(command.equals("size")) {
//                stack.size();
//            }
//
//            if(command.equals("empty")) {
//                stack.empty();
//            }
//
//            if(command.equals("pop")) {
//                stack.pop();
//            }
//        }
//    }
//
//}
//
//class MyArrayStack<E> {
//    private Object[] elementData;
//    private int elementCount;
//
//    public MyArrayStack() {
//        elementData = new Object[10];
//    }
//
//    public E pop() {
//        if(isEmpty()) {
//            System.out.println(-1);
//            return null;
//        } else {
//            E element = peek();
//            elementData[elementCount] = null;
//            return element;
//        }
//    }
//
//    public E peek() {
//        if(isEmpty()) {
//            System.out.println(-1);
//            return null;
//        }
//
//        System.out.println(elementData(elementCount - 1));
//        return elementData(elementCount - 1);
//    }
//
//    public boolean isEmpty() {
//        return elementCount <= 0;
//    }
//
//    public void empty() {
//        if(elementCount == 0) {
//            System.out.println(1);
//        } else {
//            System.out.println(0);
//        }
//    }
//
//    public void push(E element) {
//        elementData[elementCount++] = element;
//    }
//
//    public void size() {
//        System.out.println(elementCount);
//    }
//
//    @SuppressWarnings("unchecked")
//    E elementData(int index) {
//        return (E) elementData[index];
//    }
//}