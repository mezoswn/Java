package com.Calculator.Axsos;

public class CalculatorTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cal = new Calculator();
		cal.setOperandOne(10.5);
		cal.setOperation("+");
		cal.setOperandTwo(5.2);
		cal.performOperation();
		cal.getResults();
		cal.setOperandOne(20.7);
		cal.setOperation("-");
		cal.setOperandTwo(4.8);
		cal.performOperation();
		cal.getResults();
	
	}
}