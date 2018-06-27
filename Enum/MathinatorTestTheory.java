
import static org.junit.Assert.*;
import static org.junit.Assume.*;
import org.junit.runner.RunWith;
import java.util.*;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;

@RunWith(Theories.class)
public class MathinatorTestTheory {

private Mathinator m = new Mathinator();
int count = 0;

@DataPoints
public static Integer[] testNumbers = {3, 4, 104, 43, -23};

@DataPoints
public static List[] dataset={
new ArrayList<Integer>(Arrays.asList(1, 2, null, 400000)),
new ArrayList<Integer>(Arrays.asList(56, 12, 23, 8)),
new ArrayList<Integer>(Arrays.asList(1, 4, 1)),
new ArrayList<Integer>(Arrays.asList(32))
};

@Theory public void MaxNumber(List<Integer> list)
{

assumeTrue(!list.contains(null));
assumeTrue(list.size() != 0);
Iterator<Integer> itr = list.iterator();
Integer result = itr.next();
assumeTrue(result != null);
assertTrue(m.getMax(list) >= result);
System.out.println(m.getMax(list) + ", " + result);

}

@Theory public void addingNumbersEqualsSum(Integer a, Integer b){
assumeTrue(a != null);
assumeTrue(b != null);
assertTrue(m.addInts(a, b) == a + b);
System.out.println(a + ", " + b);
}

@Theory public void subtractingNumbersEqualsDiff(Integer a, Integer b){
assumeTrue(a != null);
assumeTrue(b != null);
assertTrue(m.subInts(a, b) == a - b);
}




}