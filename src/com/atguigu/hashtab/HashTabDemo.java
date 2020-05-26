package com.atguigu.hashtab;



import java.util.Scanner;

/**
 * @program: DataStructures
 * @description:
 * @author: zhaifantasy
 * @create: 2020-05-14 09:45
 **/
public class HashTabDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("del:删除雇员");
            System.out.println("exit:退出系统");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入name");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                case "del":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.delEmpById(id);
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

//创建HashTab 管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size){
        this.size = size;
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }
    //添加雇员
    public void add(Emp emp){
        int empLinkedListNO = hashFun(emp.id);
        empLinkedListArray[empLinkedListNO].add(emp);
    }
    //遍历所有的链表,遍历hashtab
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    public void findEmpById(int id){
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if(emp != null){
            System.out.printf("在第%d中找到该雇员id= %d\n",empLinkedListNO+1,id);
        }else{
            System.out.println("在哈希表中，没有找到该雇员~");
        }

    }

    public void delEmpById(int id){
        int empLinkedListNO = hashFun(id);
        empLinkedListArray[empLinkedListNO].delEmpById(id);
        list();
    }

    //编写散列函数
    public int hashFun(int id){
        return id % size;
    }
}

//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next; // 默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//创建EmpLinkedList,表示链表
class EmpLinkedList{
    //头指针，执行第一个Emp,
    private Emp head; //默认null

    //添加雇员到链表
    public void add(Emp emp){
        if(head == null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true){
            if(curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;

        }
        curEmp.next = emp;
    }
    //遍历链表的雇员信息
    public void list(int no){
        if(head ==null){
            System.out.println("第"+(no+1)+"链表为空");
            return;
        }
        System.out.print("第"+(no+1)+"前链表信息为：");
        Emp curEmp = head;
        while(true){
            System.out.printf("=>id=%d name=%s\t",curEmp.id,curEmp.name);
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    //查找
    public Emp findEmpById(int id){
        if(head == null){
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true){
            if(curEmp.id == id){
                break;
            }
            if(curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    //删除
    public void delEmpById(int id){
        if(head == null){
            System.out.println("链表为空");
            return;
        }
        if(head.id == id){
            head=head.next;
            return;
        }
        //辅助指针
        Emp curEmp = head;
        while (true){
            if(curEmp.next.id == id){
                break;
            }
            if(curEmp.next == null){
                System.out.println("没有找到节点");
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = curEmp.next.next;
        System.out.println();
    }


}
