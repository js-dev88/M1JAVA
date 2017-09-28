package TD3;

public class GenericCell<T> {
	
		private Object val;
		private GenericCell<?> ref;
		
		public GenericCell(Object val){
			this.val = val;
			this.ref = null;
		}
		
		public GenericCell(Object val, GenericCell<?> ref) {
			this.val = val;
			this.ref = ref;
			
		}
		
		public GenericCell<?> getRef() {
			return ref;
		}
		
		public void setRef(GenericCell<?> ref) {
			this.ref = ref;
		}
		public Object getVal() {
			return val.toString();
		}
		
}
