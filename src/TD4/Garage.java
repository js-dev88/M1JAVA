package TD4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Garage {
	private List<Car> garage;
	private final int id;
	private static int ID = 1;
	
	public Garage() {
		this.garage = new ArrayList<Car>();
		this.id = ID++;
		
	}
	
	public void add(Car voiture){
		garage.add(Objects.requireNonNull(voiture));
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("------------------\n");
		sb.append("-=GARAGE D'ABDEL=-\n");
		sb.append("------------------\n");
		for(Car c:garage){
			sb.append(c.toString()+"\n");
		}
		// TODO Auto-generated method stub
		return sb.toString();
	}
	
	public long getValue(){
		long sum =0;
		for(Car c: garage){
			sum += c.getValue();
		}
		return sum;
	}
	
	public Car firstCarByBrand(String brand){
		for(Car c: garage){
			if(brand.equals(c.getBrand())){
				return c;
			}
		}
		return null;
	}
	
	public void remove(Car c){
        Iterator<Car> it = garage.iterator();
        while (it.hasNext()){
            Car c2 = it.next();
            if (c2.equals(c)){
                it.remove();
            }
        }
        
    }


	
	
	public static void main(String[] args) {
		Car Abdel = new Car("Porsche", "010102",40444);
		Car Abdel2 = new Car("Voiture2Ouioui", "010102",42456);
		Car Abdel3 = new Car("Twingo", "010102",478987);
		Car Abdel4 = new Car("FiatMoche", "010102",426555);
		Car Abdel5 = new Car("Ferrari", "00147852",40000, 4);
		
		Garage garageAbdel = new Garage();
		garageAbdel.add(Abdel);
		garageAbdel.add(Abdel2);
		garageAbdel.add(Abdel3);
		garageAbdel.add(Abdel4);
		garageAbdel.add(Abdel5);
		
		System.out.println(garageAbdel.toString());
		System.out.println("WHOOOAAAA Abdel dispose d'un garage évalué à : $"+garageAbdel.getValue());
		
		Car a = new Car("Audi", "41abd75", 10000);
		Car b = new Car("BMW","42abc75", 9000);
		Car c = new Car("BMW","42abc75", 9000);
		Car d = a;
		System.out.println(a==b);
		System.out.println(b==c);
		System.out.println(a==d);
		System.out.println(a.equals(b));
		System.out.println(b.equals(c));
		System.out.println(a.equals(d));
		System.out.println("ABDELABDELABDELABDELABDELABDEABDELABDELABDELABDEL");
		HashSet<Car> set = new HashSet<Car>();
		set.add(b);
		System.out.println(set.contains(c));
	}
	
}
