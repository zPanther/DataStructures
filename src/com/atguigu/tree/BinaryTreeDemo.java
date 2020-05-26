package com.atguigu.tree;


/**
 * @program: DataStructures
 * @description:
 * @author: zhaifantasy
 * @create: 2020-05-15 09:29
 **/
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        System.out.println("前序");
        binaryTree.preOrder();

        System.out.println("中序");
        binaryTree.infixOrder();

        System.out.println("后序");
        binaryTree.postOrder();

        System.out.println("前序遍历方式");
        HeroNode resNode = binaryTree.preOrdersearch(5);
        if(resNode != null){
            System.out.printf("找到了,信息为 no=%d name=%s",resNode.getNo(),resNode.getName());
        }else {
            System.out.printf("没有找到no=%d的英雄",5);
        }
    }

}
//创建一个树
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //删除节点
    public void delNode(int no){
        if(root != null){
            if(root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("空树，不能删除~");
        }
    }

    //前序
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空,无法遍历");
        }
    }
    //中序
    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空,无法遍历");
        }
    }
    //后序
    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    //前序遍历
    public HeroNode preOrdersearch(int no){
        if(root != null){
            return root.preOrdersearch(no);
        }else {
            return null;
        }
    }
    //中序遍历
    public HeroNode infixOrdersearch(int no) {
        if(root != null){
            return root.infixOrdersearch(no);
        }else {
            return null;
        }
    }
        //后序遍历
    public HeroNode postOrdersearch(int no) {
         if(root != null){
             return root.postOrdersearch(no);
         }else {
             return null;
         }
    }
}

//结点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    //递归删除节点
    public void delNode(int no){
        //左边
        if(this.left != null && this.left.no == no){
            this.left=null;
            return;
        }
        //右边
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        //递归
        if(this.left != null){
            this.left.delNode(no);
        }
        if(this.right != null){
            this.right.delNode(no);
        }


    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left !=null){
          this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
    //中序
    public void infixOrder(){
        if(this.left !=null){
            this.left.preOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.preOrder();
        }
    }
    //后序
    public void postOrder(){
        if(this.left !=null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    public HeroNode preOrdersearch(int no){
        if(this.no == no){
            return this;
        }
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.preOrdersearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.right != null){
            resNode = this.right.preOrdersearch(no);
        }
        return resNode;
    }
    //中序遍历查找
    public HeroNode infixOrdersearch(int no){
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.infixOrdersearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.no == no){
            return this;
        }
        if(this.right != null){
            resNode = this.right.infixOrdersearch(no);
        }
        return resNode;
    }
    //后序遍历查找
    public HeroNode postOrdersearch(int no){
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.postOrdersearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.right != null){
            resNode = this.right.postOrdersearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.no == no){
            return this;
        }
        return resNode;
    }
}