package ru.fafurin.models;

import ru.fafurin.enums.Color;
import ru.fafurin.models.abilities.Abilities;
import ru.fafurin.utils.FileUtil;

import java.util.List;
import java.util.Random;

public abstract class Hero extends Abilities {

    private static final int DAMAGE_RATE = 5;

    public int health;
    public int damage;
    public int defence;

    private final Random random = new Random();

    private final List<String> commentPhrases;

    public Hero(int health, int damage, int defence) {
        this.health = health;
        this.damage = damage;
        this.defence = defence;
        commentPhrases = FileUtil.setListFromFile(FileUtil.FILE_COMMENTS);
    }

    /**
     * Вступить в бой.
     * Метод переопределяется в классах-наследниках
     * для добавления бойцам дополнительных способностей
     *
     * @param enemy - боец, наносящий урон
     * @param hero  - боец, получающий урон
     */
    public abstract void fight(Hero enemy, Hero hero);

    /**
     * Получить урон.
     * Основной метод, включающий дополнительные ослабляющие эффекты,
     * а также вывод статистики
     *
     * @param enemy - боец, наносящий урон
     * @param hero  - боец, получающий урон
     */
    public void getDamage(Hero enemy, Hero hero) {
        criticalDamage(hero);
        weakened(hero);
        dearmored(hero);

        int actualDamage = getActualDamageWithRate(enemy, hero);
        getDamageInfo(enemy, actualDamage);
        hero.health -= actualDamage;

        printComment();
        printInfo(hero);
    }

    /**
     * Вывести в консоль урон бойца
     *
     * @param hero   - боец, урон которого выводится в консоль
     * @param damage - урон
     */
    public void getDamageInfo(Hero hero, int damage) {
        System.out.print(Color.RED);
        System.out.println(hero.getClass().getSimpleName() + " нанес " + damage + " единиц повреждений.");
        System.out.print(Color.RESET);
    }

    /**
     * Проверить мертв ли боец
     *
     * @return true - если здоровье меньше или равно 0, иначе - false
     */
    public boolean isDead() {
        return health <= 0;
    }

    /**
     * Вывести сообщение о смерти бойца
     */
    public void checkAlive() {
        if (isDead()) System.out.println(this.getClass().getSimpleName() + " мертв!");
    }

    /**
     * Вывести в консоль характеристики бойца
     *
     * @param hero - боец, характеристики которого выводятся в консоль
     */
    private void printInfo(Hero hero) {
        System.out.println("- - - - - - - - ");
        System.out.print(Color.BLUE);
        System.out.println(hero.getClass().getSimpleName());
        System.out.print(Color.RESET);
        System.out.print(Color.GREEN);
        System.out.println("Здоровье: " + hero.health);
        System.out.print(Color.YELLOW);
        System.out.println("Броня: " + hero.defence);
        System.out.print(Color.RESET);
        System.out.println("- - - - - - - - ");
    }

    /**
     * Подсчитать актуальный урон с учетом брони и случайной погрешности
     *
     * @param enemy - боец, наносящий урон
     * @param hero  - боец, получающий урон
     * @return урон с учетом брони
     */
    private int getActualDamageWithRate(Hero enemy, Hero hero) {
        int actualDamage = enemy.damage + random.nextInt(-DAMAGE_RATE, DAMAGE_RATE) - hero.defence;
        return actualDamage <= 0 ? random.nextInt(1, DAMAGE_RATE) : actualDamage;
    }

    /**
     * Вывести в консоль случайный комментарий орка
     */
    private void printComment() {
        System.out.print(Color.MAGENTA);
        System.out.println(Orc.class.getSimpleName() + ": " + commentPhrases.get(new Random().nextInt(commentPhrases.size())));
        System.out.print(Color.RESET);
    }
}
