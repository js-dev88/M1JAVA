package TD9;

import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Swag {
	/*public static final int CROSS = 1;
	public static final int KIKOU = 2;*/
	
	
	
	/*public static String swag( String txt, int style) {
		String rez ="";
		switch(style) {
		case CROSS : 
		for(int i=0; i<txt.length();i++){
			rez += txt.substring(i, i+1) + '+';
		}
			rez = rez.substring(0, rez.length()-1);
			break;
		case KIKOU :
			for(int i=0; i<txt.length();i++){
				if(i % 2 == 0) {
					rez += txt.substring(i, i+1).toUpperCase();
				}else{
					rez += txt.substring(i, i+1);
				}
			}
			break;
		case KIKOU | CROSS :
			
			for(int i=0; i<txt.length();i++){
				if(i % 2 == 0) {
					rez += txt.substring(i, i+1).toUpperCase()+"+";
				}else{
					rez += txt.substring(i, i+1)+"+";
				}
			}
			rez = rez.substring(0, rez.length()-1);
				
			break;
		}
		
		return rez;
	}*/
	
	/*public static String swag( String txt, Set<Style> styles) {
		for(Style s : styles) {
			txt = s.applyStyle(txt);
		}
		return txt;
	}*/
	
	
	
	public static String swag( String txt, LinkedHashSet<Style> styles) {
		for(Style s : styles) {
			txt = s.applyStyle(txt);
		}
	return txt;
	}
	
	public static void main(String[] args) {
		
		LinkedHashSet<Style> hs = new LinkedHashSet<>();
		hs.add(Style.KIKOU);
		hs.add(Style.CROSS);
		System.out.println(swag("miage", hs));
		
		/*System.out.println(swag("miage", EnumSet.of(Style.CROSS,Style.KIKOU, Style.ABDEL)));
		System.out.println(swag("miage", EnumSet.of(Style.CROSS)));
		System.out.println(swag("miage", EnumSet.of(Style.CROSS,Style.KIKOU)));
		System.out.println(swag("miage", EnumSet.of(Style.KIKOU,Style.CROSS)));*/
		/*System.out.println(Swag.swag("Abdel", Swag.CROSS));
		System.out.println(Swag.swag("Abdel", Swag.KIKOU));
		System.out.println(Swag.swag("miage", Swag.KIKOU|Swag.CROSS));*/
		
		
	}}
	

