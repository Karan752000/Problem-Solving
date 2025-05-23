package com.stack;

import java.util.LinkedList;
import java.util.Queue;

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

class StackImplUsingLL{

    Node head = null;
    int size = 0;

    public StackImplUsingLL(){
    }

    public void push(int n){
        Node nod = new Node(n);
        if(head == null){
            nod.next = head;
            head = nod;
        }else{
            nod.next = head;
            head = nod;
        }
        size++;
    }

    public void pop(){
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

class StackImplUsingQueue{
    Queue<Integer> q = new LinkedList<>();

    public void push(int n){
        q.add(n);
        if(q.size() > 1){
            for(int i=0 ; i<q.size()-1 ; i++){
                q.add(q.poll());
            }
        }
        System.out.println(q);
    }

    public int peek(){
        return q.size() == 0 ? -1 : q.peek();
    }

    public void pop(){
        q.poll();
    }

    public int size(){
        return q.size();
    }

}

public class StackImpl {
    public static void main(String[] args) {
//        StackImplUsingLL st = new StackImplUsingLL();
        StackImplUsingQueue st  = new StackImplUsingQueue();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        System.out.println(st.peek());
        System.out.println("size "+st.size());
        st.pop();
//        st.push(4);
        System.out.println(st.peek());
        System.out.println("size "+st.size());
//        st.pop();
//        st.pop();
//        st.pop();
//        System.out.println(st.peek());
//        st.push(100);
//        System.out.println(st.peek());
    }
}
