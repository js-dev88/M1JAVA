package TD1;

import java.util.ArrayList;
import java.util.Random;

public class PrimeCollection {
	private ArrayList<Integer> tab = new ArrayList<Integer>();

	public void initRandom(int n, int m){
		int nb =0;
		
		
		for(int i = 0; i < n; i++){
			Random r = new Random();
			nb = r.nextInt(m-1);
			tab.add(nb+1);
			
		}
		
	}
	
	private boolean isPrime(int p){
		Boolean bool = false;
		
		for(int k = 2; k <= Math.sqrt(p); k++){
			if(p % k == 0){
				bool = true;
			}
		}
		return bool;
	}
	
	public ArrayList<Integer> sayIsPrime(ArrayList<Integer> tab){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int l = 0; l < tab.size(); l++){
			if(!isPrime(tab.get(l))){
				list.add(tab.get(l));
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		PrimeCollection pc = new PrimeCollection();
		pc.initRandom(100, 100);
		ArrayList<Integer> rez = pc.sayIsPrime(pc.tab);
		for(int j = 0; j< rez.size(); j++ ){
			System.out.println(rez.get(j));
		}
		
	}
	
}