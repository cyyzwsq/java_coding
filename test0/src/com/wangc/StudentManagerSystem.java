package com.wangc;

/*
 * @ClassName StudentManagerSystem
 * @Description 学生管理系统，实现增删改查操作
 * @Author 冲哥
 * @Date 2020/12/12 21:30
 * @Version 1.0
 */
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagerSystem {
    public static void main(String[] args) {
        //创建students集合，用于存放学生信息
        ArrayList<Student> students = new ArrayList<>();
        while (true) {
            menu();
            System.out.println("请输入操作所对应的编号：");
            Scanner scanner = new Scanner(System.in);
            String num = scanner.nextLine();
            switch (num) {
                case "1":
                    addStudent(students);
                    break;
                case "2":
                    delStudent(students);
                    break;
                case "3":
                    editStudent(students);
                    break;
                case "4":
                    showAllStudent(students);
                    break;
                case "0":
                    System.out.println("系统退出，谢谢使用！");
                    System.exit(0);//退出JVM
                default:
                    System.out.println("您的输入有误，请输入操作所对应的编号：");
            }
        }
    }

    /*
     * @Author 冲哥
     * @Description 系统提示菜单
     * @Date 2020/12/12 22:19
     * @Param 
     * @return void
     */
    public static void menu(){
        System.out.println("***********学生管理系统***********");
        System.out.println("请按照系统菜单提示进行操作，菜单如下：");
        System.out.println("1:添加学生信息");
        System.out.println("2:删除学生信息");
        System.out.println("3:修改学生信息");
        System.out.println("4:查看所有学生信息");
        System.out.println("0:退出系统");
    }

    /*
     * @Author 冲哥
     * @Description 添加学生信息
     * @Date 2020/12/12 22:28
     * @Param students
     * @return void
     */
    public static void addStudent(ArrayList<Student> students){
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入学号：");
        String sid = scanner.nextLine();
        //添加学生信息时，学号不能相同
        if (!students.isEmpty()){
            for (Student stu:students) {
                if (stu.getSid().equals(sid)){
                    System.out.println("学号为" + sid + "的学生信息已经存在！");
                    return;
                }
            }
        }

        System.out.println("请输入姓名：");
        String name = scanner.nextLine();

        System.out.println("请输入年龄：");
        String age = scanner.nextLine();

        System.out.println("请输入地址：");
        String addr = scanner.nextLine();

        student.setSid(sid);
        student.setName(name);
        student.setAge(age);
        student.setAddr(addr);

        students.add(student);
        System.out.println("学生信息添加成功！");
    }

    /*
     * @Author 冲哥
     * @Description 删除学生信息
     * @Date 2020/12/12 22:38
     * @Param students
     * @return void
     */
    public static void delStudent(ArrayList<Student> students){
        if (students.isEmpty()){
            System.out.println("对不起，没有学生信息！请先添加学生信息。");
            return;
        }
        System.out.println("请输入要删除的学生的学号：");
        Scanner scanner = new Scanner(System.in);
        String sid = scanner.nextLine();
        Student student = findBySid(students, sid);
        if (null != student){
            students.remove(student);
            System.out.println("学生信息删除成功！");
        } else {
            System.out.println("学号为"+ sid + "的学生信息不存在，请重新输入：");
        }
    }

    /*
     * @Author 冲哥
     * @Description 修改学生信息
     * @Date 2020/12/12 22:38
     * @Param students
     * @return void
     */
    public static void editStudent(ArrayList<Student> students){
        if (students.isEmpty()){
            System.out.println("对不起，没有学生信息！请先添加学生信息。");
            return;
        }
        String name;
        String age;
        String addr;
        System.out.println("请输入要修改的学生的学号：");
        Scanner scanner = new Scanner(System.in);
        String sid = scanner.nextLine();
        Student student = findBySid(students, sid);
        if (null != student){
            System.out.println("请输入姓名：");
            name = scanner.nextLine();

            System.out.println("请输入年龄：");
            age = scanner.nextLine();

            System.out.println("请输入地址：");
            addr = scanner.nextLine();

            student.setName(name);
            student.setAge(age);
            student.setAddr(addr);
            System.out.println("学号为"+ sid + "的学生信息已更改，请查看！");
            showAllStudent(students);
        } else {
            System.out.println("学号为"+ sid +"的学生信息不存在!");
        }
    }

    /*
     * @Author 冲哥
     * @Description 打印所有学生信息
     * @Date 2020/12/12 22:39
     * @Param students
     * @return void
     */
    public static void showAllStudent(ArrayList<Student> students){
        if (students.isEmpty()){
            System.out.println("对不起，没有学生信息！请先添加学生信息。");
            return;
        }
        System.out.println("学号\t\t姓名\t\t年龄\t\t地址");
        for (Student stu:students) {
            System.out.println(stu.getSid()+"\t\t"+stu.getName()+"\t\t"+stu.getAge()+"\t\t"+stu.getAddr());
        }
    }

    /*
     * @Author 冲哥
     * @Description 根据学号查询学生信息
     * @Date 2020/12/12 22:52
     * @Param students
     * @Param sid
     * @return com.wangc.Student
     */
    public static Student findBySid(ArrayList<Student> students, String sid){
        for (Student stu:students) {
            if (stu.getSid().equals(sid)){
                return stu;
            }
        }
        return null;
    }
}
