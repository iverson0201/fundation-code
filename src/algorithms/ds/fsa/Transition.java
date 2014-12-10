package algorithms.ds.fsa;

public class Transition {
	State to;
	InputEvent event;
	public Transition(InputEvent event,State to){
		this.event=event;
		this.to=to;
	}
}
