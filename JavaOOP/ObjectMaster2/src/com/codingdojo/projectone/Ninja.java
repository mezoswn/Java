package com.codingdojo.projectone;

public class Ninja extends Human {
	
	public Ninja() {
		this.stealth = 10;
		this.name = "Ninja";
	}
	
	public void steal (Human human) {
		human.health -= this.stealth;
		System.out.println("Lost " + human.stealth + " new health for " + human.name + " is " + human.health);
	}
	public void runaway () {
		this.health -= 10;
		System.out.println("Ninja Scared and ran away!!, the new health " + this.health);
	}
}
