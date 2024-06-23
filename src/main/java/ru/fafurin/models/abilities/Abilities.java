package ru.fafurin.models.abilities;

import ru.fafurin.enums.Color;
import ru.fafurin.models.Hero;
import ru.fafurin.utils.FileUtil;

import java.util.List;
import java.util.Random;

public class Abilities implements Buff, Debuff {

    private static final Double CHANCE = 0.3;
    private static final Integer ARMOR_INCREASE = 30;
    private static final Integer HEALTH_INCREASE = 40;

    private static final Integer DAMAGE_DECREASE = 10;
    private static final Integer DEFENCE_DECREASE = 5;
    private static final Integer HEALTH_DECREASE = 5;
    private static final Double DAMAGE_DECREASE_CHANCE = 0.1;

    private final List<String> attackPhrases;

    public Abilities() {
        attackPhrases = FileUtil.setListFromFile(FileUtil.FILE_ATTACK);
    }

    /**
     * Единовременно увеличивает броню бойца на ARMOR_INCREASE
     *
     * @param hero - бронированный боец
     */
    @Override
    public void armored(Hero hero) {
        System.out.print(Color.YELLOW);
        System.out.println(hero.getClass().getSimpleName() + " произнес заклинание увеличения брони!");
        System.out.print(Color.RESET);
        hero.defence += ARMOR_INCREASE;
    }

    /**
     * Единовременно увеличивает здоровье бойца на HEALTH_INCREASE
     *
     * @param hero - лечащийся боец
     */
    @Override
    public void recovered(Hero hero) {
        hero.health += HEALTH_INCREASE;
    }

    /**
     * Позволяет с вероятностью DODGE_CHANCE избежать атаки
     *
     * @param hero - ловкий боец
     * @return true - если удалось увернуться, иначе - false
     */
    @Override
    public boolean dodge(Hero hero) {
        if (Math.random() < CHANCE) {
            System.out.print(Color.MAGENTA);
            System.out.println(hero.getClass().getSimpleName() + " увернулся");
            System.out.println(Color.RESET);
            return true;
        } else return false;
    }

    /**
     * Уменьшает здоровье бойца на HEALTH_DECREASE c вероятностью CHANCE
     *
     * @param hero - боец, получивший дополнительных люлей
     */
    @Override
    public void criticalDamage(Hero hero) {
        if (Math.random() < CHANCE) {
            System.out.print(Color.RED);
            System.out.println("УПС!!!");
            System.out.printf("%s получил %d дополнительных повреждений от критического удара\n",
                    hero.getClass().getSimpleName(),
                    HEALTH_DECREASE);
            System.out.print(Color.RESET);
            hero.health -= HEALTH_DECREASE;
        }
    }

    /**
     * Уменьшает урон бойца на DAMAGE_DECREASE
     *
     * @param hero - ослабленный боец
     */
    @Override
    public void weakened(Hero hero) {
        if (Math.random() < DAMAGE_DECREASE_CHANCE) {
            System.out.print(Color.RED);
            System.out.println("УПС!!!");
            System.out.printf("%s получил %s, урон снижен на %d единиц\n",
                    hero.getClass().getSimpleName(),
                    generateRandomPhrase(),
                    DAMAGE_DECREASE);
            System.out.print(Color.RESET);
            if (hero.damage > DAMAGE_DECREASE) {
                hero.damage -= DAMAGE_DECREASE;
            } else hero.damage = 1;
        }
    }

    /**
     * Уменьшить броню бойца на DEFENCE_DECREASE с вероятностью CHANCE
     *
     * @param hero - боец, потерявший очки брони
     */
    @Override
    public void dearmored(Hero hero) {
        if (Math.random() < CHANCE) {
            System.out.print(Color.RED);
            System.out.println("УПС!!!");
            System.out.printf("%s получил %s. Броня теряет %d единиц\n",
                    hero.getClass().getSimpleName(),
                    generateRandomPhrase(),
                    DEFENCE_DECREASE);
            System.out.print(Color.RESET);
            if (hero.defence > DEFENCE_DECREASE) {
                hero.defence -= DEFENCE_DECREASE;
            } else hero.defence = 0;
        }
    }

    /**
     * Вернуть случайную фразу для удара из списка
     *
     * @return случайная фраза для удара
     */
    private String generateRandomPhrase() {
        return attackPhrases.get(new Random().nextInt(attackPhrases.size()));
    }
}
