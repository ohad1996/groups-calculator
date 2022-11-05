
public class Person implements Comparable<Person>
{
    private int _bornYear; 
    private String _name,_lastName,_id;
    private final String DEFAULT_ID = "123456789";
    private final String DEFAULT_NAME = "BOB";
    private final String DEFAULT_LAST_NAME = "habanai";
    private final int DEFAULT_YEAR = 1000;
    public Person (String name,String lastName,int bornYear,String id){
        if(bornYear>1000&&bornYear<2022)
            _bornYear =bornYear;
        else
            _bornYear = DEFAULT_YEAR;

        int count = 0;
        if(id.length() == 9){
            for(int i =0; i<id.length() ;i++){
                if(id.charAt(i)<'0' || id.charAt(i)> '9'){
                    _id = DEFAULT_ID;
                    count--;
                }
                count++;
            } 
            if(count == 9)
                _id = id;
        }
        else
            _id = DEFAULT_ID;

        count = 0;
        if(!name.equals("")){//every one has a name...
            for(int i=0;i<name.length();i++) {
                //this if is in case the name isn't valid.
                if(name.charAt(i)>='0' && name.charAt(i)<='9'){
                    _name = DEFAULT_NAME;
                    count--;
                }
                count++;
            }
            //count1 is meant for to do not update the false name.
            if(count == name.length())
                _name = name;  
        }
        else
            _name = DEFAULT_NAME;

        count = 0;
        if(!lastName.equals("")){//every one has a name...
            for(int i=0;i<lastName.length();i++) {
                //this if is in case the name isn't valid.
                if(lastName.charAt(i)>='0' && lastName.charAt(i)<='9'){
                    _lastName = DEFAULT_LAST_NAME;
                    count--;
                }
                count++;
            }
            //count1 is meant for to do not update the false name.
            if(count == lastName.length())
                _lastName = lastName;  
        }
        else
            _lastName = DEFAULT_LAST_NAME;
    }

    public int compareTo(Person p){ 
    	if(this._id == null || p._id == null) {
    		if(this._id == null)
                return 1;
            if(p._id == null)
                return -1; 
        	return 0;
    	}  
        return p._id.compareTo(_id);
    }


    public boolean equals(Person p){
        return _id.equals(p._id);  
    }

    public String toString(){
        return "Name: "+_name+", Last name: "+_lastName+", Year of birth: "+_bornYear+
        " ID number: "+_id+"\n";
    }

}