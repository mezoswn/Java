public class BasicJavaTest{
public static void main(String [] args){
	
	BasicJava number = new BasicJava();
	number.print(255);
	number.printOdd(255);
	number.printSum(255);
	int [] array = {1,3,5,7,9,13};
	number.printIterateArray(array);
	int [] array1 = {-3,-5,-7};
	number.findMax(array1);
	int [] array2 ={2,10,3};
	number.getAverage(array2);
	number.printOddArray(255);
	number.greaterThanY(array, 3);
	number.squareTheValues(array);
	number.elliminateNegativeNumbers(array1);
	number.maxMinAverage(array2);
	number.shiftingTheValues(array2);
}
}