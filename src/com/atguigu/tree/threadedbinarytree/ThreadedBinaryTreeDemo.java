package threadedbinarytree;

import javax.sound.midi.Soundbank;

/**
 * @program: DataStructures
 * @description:
 * @author: zhaifantasy
 * @create: 2020-05-22 11:19
 **/
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        HeroNode left = node5.getLeft();
        System.out.println(left);
        HeroNode right = node5.getRight();
        System.out.println(right);

        System.out.println("线索化方式遍历");
        threadedBinaryTree.threadedList();

    }

}

//创建一个树 ThreadBinaryTree
class ThreadedBinaryTree{
    private HeroNode root;
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes(){
        this.threadedNodes(root);
    }

    public void threadedList(){
        HeroNode node = root;
        while (node != null){
            while (node.getLeftType()==0){
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType()==1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    public void threadedNodes(HeroNode node){
        //如果node==null,不能线索化
        if(node == null){
            return;
        }
        threadedNodes(node.getLeft());
        //处理当前节点
        if(node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if(pre !=null && pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }

        pre = node;

        threadedNodes(node.getRight());
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

    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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
