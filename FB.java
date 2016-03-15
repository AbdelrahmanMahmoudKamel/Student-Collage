/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fb;

import javax.print.DocFlavor;

/**
 *
 * @author Abdallah
 */
public class FB {

    static int size = 10000;
    static String StudentName[] = new String[size];
    static String ID[] = new String[size];
    static String Class[] = new String[size];
    static String lastyeargrade[] = new String[size];
    static int NumberOfsubjects[] = new int[size];
    static String Department[] = new String[size];
    static int count = 0;
    static int i;
    static int j;

    /**
     * @param args the command line arguments
     */
    public static void Insertion(String name, String CLass, String Id, String grade, int subjectNo, String depart) {
        if (count < size) {
            StudentName[count] = name;
            ID[count] = Id;
            Class[count] = CLass;
            lastyeargrade[count] = grade;
            NumberOfsubjects[count] = subjectNo;
            Department[count] = depart;
            count++;
        }
    }

    public static void Bubblesort(int a[]) {
        for (i = 0; i < count; i++) {
            for (j = 1; j < count - i; j++) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    swap2(Class, j - 1, j);
                    swap2(ID, j - 1, j);
                    swap2(Department, j - 1, j);
                    swap2(lastyeargrade, j - 1, j);
                    swap2(StudentName, j - 1, j);
                }
            }
        }
    }

    public static void swap2(String a[], int x, int y) {
        String temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void swap(int p[], int x, int y) {
        int temp = p[x];
        p[x] = p[y];
        p[y] = temp;
    }

    public static void displayUser(int index) {
        if (index > -1 && index < count) {
            System.out.println("Name\tClass\tID\tLastyeargrade\tNumberOfModules\t\tDepartment");
            System.out.println(StudentName[index] + "\t" + Class[index] + "\t" + ID[index] + "\t\t"
                    + lastyeargrade[index] + "\t\t" + NumberOfsubjects[index] + "\t\t" + Department[index]);
        } else {
            System.out.println("error");
        }
    }

    public static void display() {
        System.out.println("Name\tClass\tID\tLastyeargrade\tNumberOfModules\t\tDepartment");
        for (int i = 0; i < count; i++) {
            System.out.println(StudentName[i] + "\t" + Class[i] + "\t" + ID[i] + "\t\t"
                    + lastyeargrade[i] + "\t\t" + NumberOfsubjects[i] + "\t\t" + Department[i]);
        }
    }

    public static void LinearSearch(String index) {
        for (i = 0; i < count; i++) {
            if (StudentName[i].equals(index)) {
                break;
            }
        }
        if (i == count) {
            System.out.println("not found");
        } else {
            System.out.println(("founded at" + i));
        }
    }

    public static void DeletStudent(int index) {
        if (index > -1 && index < count) {
            StudentName[index] = StudentName[index + 1];
            Class[index] = Class[index + 1];
            ID[index] = ID[index + 1];
            lastyeargrade[index] = lastyeargrade[index + 1];
            NumberOfsubjects[index] = NumberOfsubjects[index + 1];
            Department[index] = Department[index + 1];
            count--;
        }
    }

    public static int BinarySearchForStudentsName(String Name) {
        int left = 0;
        int right = count - 1;
        int middle;
        while (true) {
            middle = (left + right) / 2;
            int copmarison = Name.compareTo(StudentName[middle]);
            if (Name.equals(StudentName[middle])) {
                return middle;
            } else if (left > right) {
                return count;
            } else {
                if (copmarison > 0) {
                    middle = middle + 1;
                } else {
                    middle = middle - 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Insertion("Mohad", "1st", "012372", "Ex", 14, "Engineering");
        Insertion("sami", "2nd", "1125", "G", 12, "Medcine");
        Insertion("Medo", "2nd", "12467", "ac", 10, "commerce");
        Insertion("popos", "1st", "52485", "V.g", 2, "Pc scince");
        Insertion("ali", "3rd", "45957", "Bass", 4, "Engineering");
        Insertion("ahmed", "4rth", "46574", "Ex", 6, "scince");
        Insertion("Menna", "prep", "4575", "G", 8, "language");
        display();
        System.out.println(" ");
        LinearSearch("Asmaa");
        System.out.println(" ");
        LinearSearch("Menna");
        System.out.println(" ");
        displayUser(6);
        System.out.println(" ");
        DeletStudent(3);
        System.out.println(" ");
        display();
        System.out.println(" ");
        LinearSearch("ali");
        System.out.println(" ");
        LinearSearch("kemo");
        System.out.println(" ");
        Bubblesort(NumberOfsubjects);
        display();
    }
}
