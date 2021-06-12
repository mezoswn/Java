package com.codingdojo.projectone;

public class Samurai extends Human {
	
	public static int samuraiCount;
	
	public Samurai () {
		this.health = 200;
		this.name = "Samurai";
		samuraiCount++;
	}
	
	public void deathBlow (Human human) {
		
		if(this.health >=1) {
			human.health = 0;
			this.health = (this.health/2);
			System.out.println(human.name + "The current Health is " + human.health);
			System.out.println("Samurai's health after this attack is " + this.health);
		} else {
			System.out.println("Samurai must meditate, he doesn'y have the power to continue!");
		}
	}
	
	public void meditate() {
		this.health = 200;
		System.out.println("Samurai charged to: " + this.health + " of health!");
	}

	public static void howMany() {
		System.out.println(samuraiCount + " Samurais");
	}
}
