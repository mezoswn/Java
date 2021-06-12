package com.codingdojo.projectone;

public class Wizard extends Human {
	
	public Wizard() {
		this.health = 50;
		this.intelligence = 8;
		this.name = "Wizard";
	}
	
	public void heal (Human human) {
		human.health += this.intelligence;
		System.out.println(human.name + "healed by Wizard and back to " + human.health);
	}

}
