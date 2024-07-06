package Model;

import java.util.LinkedList;

public class Records extends Updater{
    
    protected int id = 0;
    protected LinkedList<Record> records = new LinkedList<Record>();
      
    protected Record find(int id)
    {
        for(Record record: records)
        {
            if(record.matches(id))
            {
                return record;
            }
        }
        return null;
    }

    protected void add(Record record)
    {
        records.add(record);
        updateViews();
    }
    
    public int size()
    {
        return records.size();
    }

    @Override
    public String toString()
    {
        String str = "";
        for(Record record : records)
            str += record.toString() + "\n";
        return str;
    }
}
