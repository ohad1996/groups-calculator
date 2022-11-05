/**
 * @author (ohad borenstein)
 */
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String []args){
		Scanner scan = new Scanner(System.in);       
        Random integer = new Random();
        int randomNum;
        Integer [] arr1 = new Integer[10];
        Integer [] arr2 = new Integer[10];
        Integer [] arr3 = new Integer[10];
        int i = 0;
        do{
            randomNum = integer.nextInt(100);
            for(int j = 0;j<i;j++){
                if(randomNum == arr1[j]){
                    j=0;
                    randomNum = integer.nextInt(100);
                }
            }
            arr1[i] = randomNum;
            
            randomNum = integer.nextInt(100);
            for(int j = 0;j<i;j++){
                if(randomNum == arr2[j]){
                    j=0;
                    randomNum = integer.nextInt(100);
                }
            }
            arr2[i] = randomNum;
            
            randomNum = integer.nextInt(100);
            for(int j = 0;j<i;j++){
                if(randomNum == arr3[j]){
                    j=0;
                    randomNum = integer.nextInt(100);
                }
            }
            arr3[i] = randomNum;
            i++;
        }while(i<10);
        SetUp<Integer> g1 = new SetUp<Integer>(arr1); 
        SetUp<Integer> g2 = new SetUp<Integer>(arr2); 
        SetUp<Integer> g3 = new SetUp<Integer>(arr3);
        
        System.out.println("before union: \nGroup1:\n"+g1+"\n\nGroup2:\n"+g2+"\n");
        g1.union(g2);
        System.out.println("after union: \nGroup1:\n"+g1+"\n\nGroup2:\n"+g2+"\n");
        System.out.println("before intersect: \nGroup1:\n"+g1+"\n\nGroup3:\n"+g3+"\n");
        g1.intersect(g3);
        System.out.println("after intersect: \nGroup1:\n"+g1+"\n\nGroup3:\n"+g3+"\n");
        System.out.println("Please pick 2 numbers that will represent Group4 and we \n"+
                           "will see if this new group is a part of Group 1,2 or 3:\n");
        System.out.println("first number:");
        Integer num1 = scan.nextInt();
        System.out.println("second number:");
        Integer num2 = scan.nextInt();
        Integer [] arr4 ={num1,num2};
        SetUp<Integer> g4 = new SetUp<Integer>(arr4);
        if(g1.isSubset(g4))
            System.out.println("Group4 is subset of Group1");
        else if(g2.isSubset(g4))
            System.out.println("Group4 is subset of Group2");
        else if(g3.isSubset(g4))
            System.out.println("Group4 is subset of Group3");
        else
            System.out.println("Group4 is not a subset of any Group");
        System.out.println("Please pick a number");
        Integer num = scan.nextInt();
        if(g1.isMember(num))
            System.out.println("This number is belong to Group1\n");
        else
            System.out.println("This number is not belong to Group1\n");
        System.out.println("Adding this number to Group2...\n"+
        "before adding:\n"+g2);
        g2.insert(num);
        System.out.println("After adding:\n"+g2+"\n");
        System.out.println("Deleting this number in Group3 incase its there...\n"+
        "before deleteing:\n"+g3);
        g3.delete(num);
        System.out.println("After deleteing:\n\n"+g3);
        System.out.println("Now we representing the persons and checking who is the youngest one..\n");
        PersonTest.PersonTestUp();
        scan.close();
    }
}