import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class LRUCache {

    public static void main(String[] args) {
        try
        {
            SomeStorage s = new SomeStorage();
            s.EnterNewStudentInfo(1,"siva");
            s.EnterNewStudentInfo(2,"krishna");
            s.EnterNewStudentInfo(3,"gudivada");
            s.EnterNewStudentInfo(4,"venkata");
            s.EnterNewStudentInfo(6,"hari");
            s.EnterNewStudentInfo(5,"place holder");

            s.GetStudentName(2);
            Thread.sleep(3000);
            s.GetStudentName(3);
            Thread.sleep(3000);
            System.out.println(s.GetRecentlyAccessedID());
        }
        catch(Exception ex)
        {

        }
    }
}

class SomeStorage
{
    private HashMap<Integer,String> names = new HashMap<>();
    private HashMap<Integer, Date> recentlyUsedNames = new HashMap<>();

    public void EnterNewStudentInfo(int id, String name)
    {
        names.put(id,name);
    }

    public String GetStudentName(int id)
    {
        recentlyUsedNames.put(id,new Date());
        return names.get(id);
    }

    public Integer GetRecentlyAccessedID()
    {
        Date now = new Date();
        Integer recentlyAccessedId = Integer.MAX_VALUE;
        Date minDate = new Date(Long.MAX_VALUE);
        for (Integer currId : recentlyUsedNames.keySet())
        {
            Date lastAccessed = recentlyUsedNames.get(currId);
            Date diff = new Date(now.getTime() - lastAccessed.getTime());
            if(diff.compareTo(minDate)<0)
            {
                minDate = diff;
                recentlyAccessedId = currId;
            }
        }
        return recentlyAccessedId;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */