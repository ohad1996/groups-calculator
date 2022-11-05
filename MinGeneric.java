
/**
 * Write a description of class  here.
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Iterator;
public class MinGeneric
{
    public static <E extends Comparable<E>> E minimum(SetUp<E> set){
        Iterator<E> iter = set.iterator();
        E min = set.iterator().next();
        if(iter == null)
            return null;
        while(iter.hasNext()){
            E tmp = iter.next();
            if(min.compareTo(tmp)<0)//in case its true, we update the minimum. 
                min = tmp;
        }
        return min;
    }
}