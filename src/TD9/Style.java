package TD9;

public enum Style {
	CROSS{

		@Override
		public String applyStyle(String txt) {
			String rez = "";
			for(int i=0; i<txt.length();i++){
				rez += txt.substring(i, i+1) + '+';
			}
				rez = rez.substring(0, rez.length()-1);
			return rez;
		}
		
	}, 
	KIKOU{

		@Override
		public String applyStyle(String txt) {
			String rez = "";
			for(int i=0; i<txt.length();i++){
				if(i % 2 == 0) {
					rez += txt.substring(i, i+1).toUpperCase();
				}else{
					rez += txt.substring(i, i+1);
				}
			}
			return rez;
		}
		
	}, 
	ABDEL{

		@Override
		public String applyStyle(String txt) {
			String rez = "";
			for(int i=0; i<txt.length();i++){
				if(i % 2 == 0) {
					rez += txt.substring(i, i+1).toUpperCase()+"+";
				}else{
					rez += txt.substring(i, i+1)+"+";
				}
			}
			rez = rez.substring(0, rez.length()-1);
			
			return rez;
		}
		
	};
	
	public abstract String applyStyle(String txt);
}
