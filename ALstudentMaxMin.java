package filerwintoarraylistmaxmin;

import java.io.*;
import java.util.*;


// Program reads all the lines of blrstudent2.csv
// loads student atrributes to Student object - to be done as assignment

public class ALstudentMaxMin {

    public static void main(String args[]) {

        String filepath = "D:\\JavaProjects\\arrayliststudentmaxmin.csv";
        ArrayList<String> linesRead = new ArrayList<String>();
        ArrayList<Student> records = new ArrayList<Student>();

        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String currentline = br.readLine();

            while (currentline != null) {
                linesRead.add(currentline);// Add line to String Arraylist
                currentline = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayList<Integer> ageList = new ArrayList<Integer>();
        ArrayList<String> nameList=new ArrayList<String>();
        ArrayList<Double> marksList = new ArrayList<Double>();
        //using enhanced loop to store details into objects
        Student sobj;
        for (String s : linesRead) {
            String[] tokens = s.split(","); //this splits the line based on "," as delimiter
            sobj = new Student(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]),
                    Double.parseDouble(tokens[3]));
            records.add(sobj);
            /*ageList.add(sobj.getAge());
            marksList.add(sobj.getMarks());
            nameList.add(sobj.getName());
*/
        }

        System.out.println("\nThe size of List is  " + records.size() + "\n");

        System.out.println("Now printing Object Values");
        for (Student st : records) {
            System.out.println(st.getRollno() + " " + st.getName() + " " + st.getAge()+" "+st.getMarks());
        }

        /*int maxage = Collections.max(ageList);
        System.out.println("Max age is : " + maxage);
        int minage=Collections.min(ageList);
        System.out.println("Min Age is :"+minage );
        double minmarks = Collections.max(marksList);
        System.out.println("Min marks is : " + minmarks);
        String meanname=Collections.max(nameList);
        System.out.println("First name is :"+meanname);
        String lastname=Collections.min(nameList);
        System.out.println("Last name is :"+lastname);*/

        //@Otherway of finiding max and min marks with details
        //to find max marks
        Student Details;
        Details=Collections.max(records,Comparator.comparingDouble(Student::getMarks));
        System.out.println("Max marks is :"+Details.getMarks());
        System.out.println("Student Details with Max maxrks is:"+" "+Details.getRollno()+" "+Details.getAge()+" "+
                Details.getName()+" "+Details.getMarks());

        //@to find min marks of student
        Details=Collections.min(records,Comparator.comparingDouble(Student::getMarks));
        System.out.println("Min marks is :"+Details.getMarks());
        System.out.println("Student Details with Min maxrks is:"+" "+Details.getRollno()+" "+Details.getAge()+" "+
                Details.getName()+" "+Details.getMarks());

        // to find First and last Alphabet
        Details=Collections.max(records,Comparator.comparing(Student::getName));
        System.out.println("Alphabetically last name is :"+Details.getMarks());
        System.out.println("Student Details :"+" "+Details.getRollno()+" "+Details.getAge()+" "+
                Details.getName()+" "+Details.getMarks());
        System.out.println();

        Details=Collections.min(records,Comparator.comparing(Student::getName));
        System.out.println("Alphabetically First name is :"+Details.getMarks());
        System.out.println("Student Details :"+" "+Details.getAge()+" "+
                Details.getName()+" "+Details.getMarks());
            System.out.println();
        //min age
        Details=Collections.min(records,Comparator.comparingInt(Student::getAge));
        System.out.println("Min age is: "+ Details.getAge());
        System.out.println("Student Min age :"+ Details.getAge()+" "+Details.getName());
    //max age
        Details=Collections.max(records,Comparator.comparingInt(Student::getAge));
        System.out.println("Min age is: "+ Details.getAge());
        System.out.println("Student Min age :"+ Details.getAge()+" "+Details.getName());
    }
}

// Student class and constructor
class Student {
    private int rollno;
    private String name;
    private int age;
    private double marks;

    Student(int rollno, String name, int age, double marks) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }


    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}

