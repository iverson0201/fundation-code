package algorithms.ds.fsa;

public class InputEvent {
	
	public static InputEvent digital4=new InputEvent("Y");
	public static InputEvent digital2=new InputEvent("D2");
	public static InputEvent digital1=new InputEvent("D1");
	
	public static InputEvent yearUnitEvent=new InputEvent("年");
	public static InputEvent monthUnitEvent=new InputEvent("月");
	public static InputEvent dayUnitEvent=new InputEvent("日");
	public static InputEvent splitEvent=new InputEvent("-");
	
	
	private String name;
	public InputEvent(String name){
		this.name=name;
	}
	
	@Override
	public boolean equals(Object obj){
		InputEvent other;
		if(obj!=null && obj instanceof InputEvent)
			other=(InputEvent)obj;
		else return false;
		if(this.name.equals(other.name)){
			return true;
		}
		return false;
		
	}
}
