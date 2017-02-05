package com.abe.test;

public class TestDiaoYong {
	
	public void tell() {
		int i=1;
		trans(i);
		System.out.println(i);
	}
	
	private void trans(int j){
		j=2;
	}
	
	public static void main(String[] args) {
		new TestDiaoYong().tell();
	}
}
