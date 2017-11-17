package TD9;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public enum BagOrder {
	NATURAL {
		@Override
		public <E> Map<E, Integer> createMap() {
			return new HashMap<>();
			
		}
	}, NONE {
		@Override
		public <E> Map<E, Integer> createMap() {
			// TODO Auto-generated method stub
			return null;
		}
	}, INSERTION {
		@Override
		public <E> Map<E, Integer> createMap(){
			return new LinkedHashMap<>();
		}
	};
	public abstract <E> Map <E, Integer> createMap();
}


/*import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Bag<T> implements Iterable{
    private Map<T, Integer> bag;
    
    public Bag() {
        bag = BagOrder.NONE.createBag(); 
    }
    
    public Bag (BagOrder order) {
        bag = order.createBag();
    }
    
    public void add(T cle) {
        if(bag.containsKey(Objects.requireNonNull(cle))) {
            bag.put(cle, bag.get(cle)+1);
        }
        else {
            bag.put(cle, 1);
        }
    }
    
    public void remove(T cle) {
        if(bag.containsKey(Objects.requireNonNull(cle))) {
            bag.put(cle, bag.get(cle)-1);
        }
        else {
            System.out.println("Cle introuvable");
        }
    }
    
    public int count(T cle) {
        if(bag.containsKey(Objects.requireNonNull(cle))) {
            return (int)bag.get(cle);
        }
        else {
            return 0;
        }
    }
    
      
    import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public enum BagOrder {
    
    NATURAL{
        
        public <T> Map<T, Integer> createBag(){
            return new TreeMap<T,Integer>(); 
        }
    }, 
    NONE{
        public <T> Map<T, Integer> createBag(){
            return new HashMap<T,Integer>(); 
        }
    },
    INSERTION{
        public <T> Map<T, Integer> createBag(){
            return new LinkedHashMap<T,Integer>(); 
        }
    }; 
    
    public     abstract <E> Map<E, Integer> createBag();
    
}



*/
