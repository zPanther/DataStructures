package com.atguigu.linkedlist;

import java.util.Stack;
import java.util.TooManyListenersException;

/**
 * @program: DataStructures
 * @description:
 * @author: zhaifantasy
 * @create: 2020-04-18 11:35
 **/
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();


        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        singleLinkedList.list();

        System.out.println(getLength(singleLinkedList.getHead()));

    }

    //方法：获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
    public static int getLength(HeroNode head) {
        if(head.next ==null){
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量, 这里我们没有统计头节点
        HeroNode temp = head.next;
        while (temp !=null){
            length++;
            temp=temp.next;
        }
        return length;
    }

    //查找单链表中的倒数第k个结点 【新浪面试题】
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if(head.next == null){
            return null;
        }
        int size = getLength(head);
        if(index<0 || index > size){
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size-index ; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //将单链表反转
    public static void reversetList(HeroNode head) {
        if(head.next == null || head.next.next == null) {
            return ;
        }
        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null){
            next=cur.next;
            cur.next=reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next=cur;
            cur=next;
        }
        head.next = reverseHead.next;

    }

    public static void reversePrint(HeroNode head) {
        if(head.next==null){
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}

class SingleLinkedList{

    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode){
        //不考虑编号顺序
        HeroNode temp = head;
        while (true){
            if(temp.next==null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }
    //按顺序添加
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next== null){
                break;
            }
            if(temp.next.no > heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(!flag){
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        }else {
            heroNode.next = temp.next;
            temp.next =  heroNode;
        }
    }
    public void update(HeroNode newHeroNode) {
        if(head.next==null){
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp =head.next;
        boolean flag = false;
        while (true){
            if(temp==null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name =  newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else { //没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no==no){
                flag=true;
                break;
            }
            temp= temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }

    }

        //遍历
    public void list(){
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while(true) {
            //判断是否到链表最后
            if(temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp = temp.next;
        }

    }
}

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int hNo,String hName,String hNickname){
        this.no = hNo;
        this.name=hName;
        this.nickname = hNickname;

    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }


}
