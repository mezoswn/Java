package com.codingdojo.projectone;

public class HumanTest {
    public static void main(String[] args) {

        Ninja ninja = new Ninja();
        Wizard wizard = new Wizard();
        Samurai samurai = new Samurai();
//        Samurai samurai2 = new Samurai();
//        Samurai samurai3 = new Samurai();


        wizard.heal(ninja);

        ninja.steal(wizard);
        ninja.steal(wizard);
        ninja.runaway();

        samurai.deathBlow(ninja);
        samurai.deathBlow(wizard);
        samurai.deathBlow(ninja);
        samurai.deathBlow(wizard);
        samurai.deathBlow(ninja);
        samurai.deathBlow(wizard);
        samurai.deathBlow(ninja);
        samurai.deathBlow(wizard);
        samurai.deathBlow(ninja);
        samurai.meditate();
        samurai.deathBlow(wizard);
        Samurai.howMany();
        ninja.showHealth();


    }
}


