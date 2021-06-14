package com.phone;

public class PhoneTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Galaxy s9 = new Galaxy("S9", 99, "T-Mobile","RING RING");
		IPhone iPhone10 = new IPhone("x", 100, "ATT", "Zzz zzz zzz");
		s9.displayInfo();
		iPhone10.displayInfo();

	}

}
