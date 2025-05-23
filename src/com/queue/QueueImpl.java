package com.queue;

import java.util.Stack;

class Node{
    public int data;
    public Node next;

    public Node(){}

    public Node(int n){
        this.data = n;
    }

    public Node(int n, Node next){
        this.data = n;
        this.next = next;
    }

}

class QueueImplUsingLL{

    int size = 0;
    Node head;
    Node mover;

    public void push(int n){
        Node node = new Node(n);
        if(head == null){
            head = node;
            mover = node;
        }else{
            mover.next = node;
            mover = node;
        }
        size++;
    }

    public void pop(){
        if(head == null ) throw new RuntimeException("no ele to remove as q is empty");

        Node temp = head.next;
        head.next = null;
        head = temp;
        size--;
    }

    public int size(){
        return size;
    }

    public int peek(){
        return head != null ? head.data : -1;
    }
}

class QueueImpUsingStack {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    public void push(int x) {

        while(st1.empty() == false){
            st2.push(st1.pop());
        }
        st1.push(x);
        while(st2.empty() == false){
            st1.push(st2.pop());
        }

    }

    public void pop() {
        st1.pop();
    }

    public int peek() {
        return st1.peek();
    }

    public int size() {
        return st1.size();
    }
}

public class QueueImpl {
    public static void main(String[] args) {
//        QueueImplUsingLL q = new QueueImplUsingLL();
        QueueImpUsingStack q = new QueueImpUsingStack();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println("size "+q.size());
        System.out.println("top ele "+q.peek());
        q.pop();
        System.out.println("size "+q.size());
        System.out.println("top ele "+q.peek());
        q.push(5);
        System.out.println("size "+q.size());
        q.pop();
        q.pop();
        q.pop();
//        q.pop();
//        q.pop(); // throws exception
        System.out.println("size "+q.size());
        System.out.println("top ele "+q.peek());

        q.push(2);
        q.push(1);
        System.out.println("size "+q.size());
        System.out.println("top ele "+q.peek());
        q.pop();
        System.out.println("top ele "+q.peek());
    }
}
