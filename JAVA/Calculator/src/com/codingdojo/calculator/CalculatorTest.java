package com.codingdojo.calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator firstcalc = new Calculator();
		firstcalc.setOperandOne(10.5);
		firstcalc.setOperator("+");
		firstcalc.setOperandTwo(5.2);
		firstcalc.performOperation();
		firstcalc.getResults();
	}

}
