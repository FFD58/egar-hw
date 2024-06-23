package ru.fafurin.models;

public class Orc extends Hero {
    public Orc(int health, int damage, int defence) {
        super(health, damage, defence);
    }

    /**
     * Вступить в бой
     * В переопределенном методе орк получает способность уклонения
     *
     * @param enemy - боец, наносящий урон
     * @param hero  - боец, получающий урон
     */
    @Override
    public void fight(Hero enemy, Hero hero) {
        if (!dodge(hero)) {
            getDamage(enemy, hero);
            checkAlive();
        }
    }
}
