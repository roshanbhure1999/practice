package org.example;

import java.util.LinkedList;

public class Main {
    private class Node {

        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }

    }



    Node head;

    public void add(int data){
        Node toinsert=new Node(data);
        if(head==null){
            head=toinsert;
        }

        Node temp=head;
        while (temp.next !=null){
            temp=temp.next;
        }

        temp.next=toinsert;
    }

    public void print(){
        Node temp=head;
        while (temp !=null){
            System.out.println(temp.data);
            temp=temp.next;
        }

    }

    public int peek(){
        if (head == null) {

            return 0;
        }
        return head.data;
    }


}