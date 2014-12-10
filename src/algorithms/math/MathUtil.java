package algorithms.math;

public class MathUtil {
	/*
	 * 计算二项式因子，也就是组合数
	 * @param upper 总数
	 * @param lower 选择的个数
	 * @return C(upper,lower)
	 * */
	public static long binomial_factorial(long upper,long lower){
		if(upper<lower||lower<0)
			throw new IllegalArgumentException("upper should bigger than lower and lower should be nonnegative number!");
		
		if(lower==0||upper==lower)
			return 1L;
		if(lower==1||upper-lower==1)
			return upper; 
		
		if(upper-lower<lower){
			lower=upper-lower;
		}
		
		long numerator=1,denominator=1;
		
		for(int i=1;i<=lower;i++){
			numerator*=(upper-i+1);denominator*=i;
		}
		return numerator/denominator;
	}
	
}
