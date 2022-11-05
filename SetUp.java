
/**
 * Write a description of class MyClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Iterator;
public class SetUp<E>
{
    public ArrayList<E> _myItem;

    public SetUp (){
        _myItem = new ArrayList<>();
    }

    public SetUp (E[] arr){
        _myItem = new ArrayList<E>();
        for(int i = 0;i<arr.length;i++){
            this.insert(arr[i]);
        }
    }

    public void union(SetUp<E> other){
        for(int i = 0;i<other._myItem.size();i++){
            this.insert(other._myItem.get(i));
        }
    }

    public void intersect(SetUp<E> other){
        SetUp<E> checkOut = new SetUp<E>();
        checkOut.changeItem(this._myItem);
        checkOut.union(other);
        for(int i = 0 ;i < checkOut._myItem.size();i++){
            if(!(other.isMember(checkOut._myItem.get(i))&&
                 this.isMember(checkOut._myItem.get(i)))){
                checkOut.delete(checkOut._myItem.get(i));
                i--;
            }
        }
        this.changeItem(checkOut._myItem);
    }


    public boolean isSubset(SetUp<E> other) {
        for (int i = 0; i < other._myItem.size(); i++) {
            if (!this.isMember(other._myItem.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void changeItem(ArrayList<E> list){
        for(int i = 0 ; i<_myItem.size();i++){
            _myItem.removeAll(_myItem);
        }
        for(int i = 0 ; i<list.size();i++){
           _myItem.add(list.get(i));
        }
    }

    public boolean isMember(E e){
        for(int i = 0 ; i<_myItem.size();i++){
            if(this._myItem.get(i).equals(e))
                return true;
        }
        return false;
    }

    public void insert(E e){
        if(!this.isMember(e))
            _myItem.add(e);
    }

    public void delete(E e){
        if(isMember(e)){
            _myItem.remove(_myItem.indexOf(e));
        }
    }

    public Iterator<E> iterator() {
        return _myItem.iterator();
    }

    public String toString(){
        String str = "";
        int line = 5;
        for(int i = 0 ; i<_myItem.size();i++){
            str += _myItem.get(i) +" ";
            if((i+1)%line == 0)
                str+="\n";
        }
        return str;
    }
}
