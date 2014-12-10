package algorithms.ds.fsa;

public class State {
	int id;
	String label;
	static int next_id;
	Transition[] transitionsArray;
	int numTransitions;
	
	public State(String label){
		this.label=label;
		id=next_id++;
		resetTransitions();
	}
	
    final void resetTransitions() {
	    transitionsArray = new Transition[0];
	    numTransitions = 0;
    }
    
    public void addTransition(Transition t){
    	if(numTransitions+1>=transitionsArray.length){
    		int newCapacity = (transitionsArray.length * 3)/2 + 1;
      	    if (newCapacity < numTransitions+1)
      	    		newCapacity = numTransitions+1;
    		Transition[] newArray=new Transition[newCapacity];
    		System.arraycopy(transitionsArray, 0, newArray, 0, numTransitions);
    	    transitionsArray = newArray;
    	 }
    	 transitionsArray[numTransitions++] = t;
    }
    
	//跳转到下一个状态
	public State step(InputEvent event){
		for(int i=0;i<numTransitions;i++){
			if(transitionsArray[i].event==event){
				return transitionsArray[i].to;
			}
		}
		return null;
	}
	
}
