import java.util.*;
public class GrowList <E>{

    // OVERVIEW: GrowList is a mutable list that only gets longer.
    // AF:  AF(c) = { c.values[i.intValue, E o] | 0 <= i < c.values.size }
    // rep-inv:  c.values != null &&
    // All keys and values of values list != null &&
    // Keys in the values list should be an intValue
    // For all integers i in c.values[i, E o], 0 <= i < c.values.size

    private Map<Integer,E> values;

    public static final boolean REPIVFALSE = false;
    
    public static final boolean CONTRACTFALSE = false;
    
    public GrowList() { values = new HashMap<Integer,E>();}

    // add to the end of the list
    public void add(E o) {
        values.put(size(), o);
    }

    // number of values in list
    public int size() { return values.size(); }

    // get ith value in list
    public E get(int i) {
        if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.get");
        return values.get(i);
    }

    // update ith value in list;  return previous value or null if none
    public E set(int i, E o) {
    	if(CONTRACTFALSE)
    	{
    		return values.put(i, o);
    		//Please change CONTRACTFALSE from false to true in order to test CONTRACT FAIL case. 
    		//SECOND FALSE TASK : delete this line, SDL that breaks the method contract (ex: adding value with a key of -1 which shouldn't exist.
    	}
    	else
    	{
            if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.set"); 
            return values.put(i, o);
    	}

    }

    // private helper method
    private boolean inRange(int i) { 
    	if(REPIVFALSE)
    	{
    		return (i < size());
    		//Please change REPIVFALSE from false to true in order to test REPIV FAIL case.
    		// FIRST FALSE TASK : delete either comparison statement for an SDL that can cause the RI to fail. (ex: remove '(i >= 0) &&' and add a value with a key of -1 will cause the repOK to fail
    	}
    	else
    	{
    		return (i >= 0) && (i < size());
    	}
	 
	} 

    public String toString() {
        if (size() == 0) return "[]";
        String result = "[";
        for (int i = 0; i < size()-1; i++) {
            result += values.get(i) + ",";
        }
        return result + values.get(size() - 1) + "]";
    }

    public boolean repOK() {
        //EFFECTS: Returns true if the rep invariant holds for this
        //otherwise returns false
        if (values == null) return false;

        Iterator it = values.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(!(pair.getKey() instanceof Integer)) return false;
            if(((Integer) pair.getKey()).intValue() < 0 || ((Integer) pair.getKey()).intValue() >= values.size()) return false;
            if(pair.getValue() == null) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        GrowList<String> list = new GrowList<String>();

        list.add("cat");
        list.add("dog");
        list.add("mouse");
        list.add(null);
        //Value for RI failure SDL test
        list.set(-1, "bat");

        System.out.println("list is:" + list);

        System.out.println(list.repOK());
    }

}
