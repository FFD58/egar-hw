package ru.fafurin.models;

public class Human extends Hero {
    public Human(int health, int damage, int defence) {
        super(health, damage, defence);
    }

    /**
     * Вступить в бой
     *
     * @param enemy - боец, наносящий урон
     * @param hero  - боец, получающий урон
     */
    @Override
    public void fight(Hero enemy, Hero hero) {
        getDamage(enemy, hero);
        checkAlive();
    }
}
