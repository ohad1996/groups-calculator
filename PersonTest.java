
/**
 * Write a description of class PersonTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PersonTest
{
    public static void PersonTestUp(){
        Person p1 = new Person("David","myaskovsky",1999,"02345678a");
        Person p2 = new Person("Ohad","borenstein",1996,"31609f");
        Person p3 = new Person("Dragon99","Slayer",0,"023475558");
        Person p4 = new Person("Menu","Mas",2000,"987654321");
        Person p5 = new Person("","",1500,"");
        
        SetUp<Person> Group = new SetUp<Person>();
        Group.insert(p1);Group.insert(p2);Group.insert(p3);Group.insert(p4);Group.insert(p5);
        System.out.println(Group);
        System.out.println("the yungest person: "+MinGeneric.minimum(Group));
        
    }
}