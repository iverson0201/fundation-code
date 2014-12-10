package algorithms.ds.fsa;

import static org.junit.Assert.*;

import org.junit.Test;


/*
 * 简单的FSA,实现对
 * ****年**月**日
 * ****-**-**
 * 格式日期的识别
 * */
public class Automata {
	 State initial;
	 State dayTimeState=new State("DayTime");
	 public Automata() {
		    this(new State("Init"));
	 }
	 
	 private Automata(State initial) {
		    this.initial = initial;
	 }
	 
	 //构造一个匹配日期的自动机
	 public void build(){
		 State yearNumState=new State("YearNum");
		 State yearTimeState=new State("YearTime");
		 State monthNumState=new State("MonthNum");
		 State monthTimeState=new State("MonthTime");
		 State dayNumState=new State("DayNum");
		 
		 Transition toYearNum=new Transition(InputEvent.digital4,yearNumState);
		 Transition toYearTime=new Transition(InputEvent.yearUnitEvent,yearTimeState);
		 
		 Transition toMonthNum=new Transition(InputEvent.digital2,monthNumState);
		 Transition toMonthNum2=new Transition(InputEvent.digital1,monthNumState);
		 Transition toMonthTime=new Transition(InputEvent.monthUnitEvent,monthTimeState);
		 
		 Transition toDayNum=new Transition(InputEvent.digital2, dayNumState);
		 Transition toDayNum2=new Transition(InputEvent.digital1, dayNumState);
		 Transition toDayTime=new Transition(InputEvent.dayUnitEvent, dayTimeState);
		 
		 initial.addTransition(toYearNum);
		 
		 yearNumState.addTransition(toYearTime);
		 
		 yearTimeState.addTransition(toMonthNum);
		 yearTimeState.addTransition(toMonthNum2);
		 
		 monthNumState.addTransition(toMonthTime);
		 
		 monthTimeState.addTransition(toDayNum);
		 monthTimeState.addTransition(toDayNum2);
		 dayNumState.addTransition(toDayTime);
		 
	 }
	 
	 private int matchDigital(String word,int start){
		 int pos=start;
		 for(int i=start,len=word.length();i<len;i++){
			 if(word.charAt(i)>='0' && word.charAt(i)<='9'){
				 pos++;continue;
			 }
			break;
		 }
		 return pos-start;
	 }
	 
	 public boolean isDate(String word){
		 int len=word.length();
		 int start=0;
		 State p=initial;
		 while(start<len){
			 int ret=matchDigital(word,start);
			 start+=ret;	
			 switch(ret){
			 	case 4: p=p.step(InputEvent.digital4);break;
			 	case 2: p=p.step(InputEvent.digital2);break;
			 	case 1: p=p.step(InputEvent.digital1);break;
			 	case 0: 
			 		 if(start+1<=len){
			 			 char ch=word.charAt(start++);
				 		 switch(ch){
				 		 case '-':p=p.step(InputEvent.splitEvent);break;
				 		 case '年':p=p.step(InputEvent.yearUnitEvent);break;
				 		 case '月':p=p.step(InputEvent.monthUnitEvent);break;
				 		 case '日':p=p.step(InputEvent.dayUnitEvent);break;
				 		 default:break;
				 		 }
			 		 }
			 		break;
			 	default:break;
			 }
			 if(p==null)return false;
		 }
		 
		 if(p!=null&&p==dayTimeState)return true;
		 return false;
	 }
	 
	 @Test
	 public  void test() {
		Automata a=new Automata();
		a.build();
		assertFalse(a.isDate("1990-12-02"));
		assertTrue(a.isDate("1990年12月2日"));
	}
}
