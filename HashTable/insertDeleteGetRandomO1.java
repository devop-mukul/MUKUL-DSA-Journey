package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class insertDeleteGetRandomO1 {

    private Map<Integer, Integer> valueToIndexMap;
    private List<Integer> values;
    private Random rand;

    public insertDeleteGetRandomO1() { // --------------------------------/
        valueToIndexMap = new HashMap<>(); //O(1) average time  /
        values = new ArrayList<>(); //O(1) average time         / -- O(1)
        rand = new Random(); //O(1) average time                /
    } //--------------------------------------------------------/
    
    public boolean insert(int val) { //---------------------------/
        if (valueToIndexMap.containsKey(val)) { //O(1) Average    /
            return false;                                        //
        }                                                        // -- O(1) 
        valueToIndexMap.put(val, values.size()); //O(1) Average   /
        values.add(val); //O(1) Average                           /
        return true;                                             // 
    } //----------------------------------------------------------/
    
    public boolean remove(int val) { // ----------------------------/
        if (!valueToIndexMap.containsKey(val)) { //O(1) Average     /
            return false;                                          //
        }                                                          //
        int index = valueToIndexMap.get(val);  //O(1) Average       /                   
        int lastElement = values.get(values.size() - 1);//O(1) Avg  /
                                                                   //
        values.set(index, lastElement);   //O(1) Average            /
        // Move the last element to the 'deleted' position          /  --- O(1) 
        valueToIndexMap.put(lastElement, index); //O(1) Average     /
        // Update the index of the last element in the map          /
                                                                   //             
        values.remove(values.size() - 1); //O(1) Average            / 
        // Remove the last element                                  /
        valueToIndexMap.remove(val);  //O(1) Average                /
        // Remove the deleted element from map                      /   
        return true;                                               //
    } //------------------------------------------------------------/
    
    public int getRandom() { //---------------------------------------/
        int randomIndex = rand.nextInt(values.size()); //O(1) Average /
        return values.get(randomIndex);//O(1) Average                 / -- O(1)
    }   //------------------------------------------------------------/
    public static void main(String[] args) {
        insertDeleteGetRandomO1 ds = new insertDeleteGetRandomO1();

        System.out.println(ds.insert(1));    // true
        System.out.println(ds.insert(2));    // true
        System.out.println(ds.insert(1));    // false (already present)
        System.out.println(ds.remove(1));    // true
        System.out.println(ds.remove(3));    // false (not present)
        System.out.println(ds.insert(3));    // true

        // Get random element a few times
        for (int i = 0; i < 5; i++) {
            System.out.println("Random: " + ds.getRandom());
        }
    }


}
