package com.codingdojo.calculator;

class Calculator implements java.io.Serializable {
	private double operandone;
	private double operandtwo;
	private String operator;
	private double result;

	public void setOperandOne(double operandone) {
		this.operandone = operandone;
	}
	
	public double getOperandOne() {
		System.out.println(operandone);
		return operandone;
	}
	
	public void setOperandTwo(double operandtwo) {
		this.operandtwo = operandtwo;
	}
	
	public double getOperandTwo() {
		System.out.println(operandtwo);
		return operandtwo;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getOperator() {
		System.out.println(operator);
		return operator;
	}

	public double performOperation() {
		operandone = getOperandOne();
		operator = getOperator();
		operandtwo = getOperandTwo();
		
		if (operator == "+") {
			System.out.println("This is an addition operation");
			this.result = operandone + operandtwo;
		} else if(operator == "-") {
			System.out.println("This is a subtraction operation");
			this.result = operandone - operandtwo;
		} else if (operator == "/") {
			System.out.println("This is a division operation");
			this.result = operandone / operandtwo;
		} else if (operator == "*") {
			System.out.println("This is a multiplication operation");
			this.result = operandone * operandtwo;
		}
		System.out.println("The result is:" + this.result);
		return this.result;
	}
	
	public double getResults() {
		System.out.println(result);
		return result;
	}
}
