package ru.fafurin.models;

import ru.fafurin.enums.Color;

import java.util.Scanner;

public class Game {

    private final Human human = new Human(70, 25, 40);
    private Orc orc;
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Начать игру
     */
    public void start() {
        System.out.println(Color.GREEN);
        System.out.println("Битва началась!");
        System.out.println(Color.RESET);

        setHardLevel();

        while (!human.isDead() && !orc.isDead()) {
            human.fight(orc, human);
            selectAction();
        }
        System.out.println("Игра окончена!");
    }

    /**
     * Выбрать действие
     */
    private void selectAction() {
        System.out.println("Введите:");
        System.out.print(Color.RED);
        System.out.println("1 - атаковать");
        System.out.print(Color.GREEN);
        System.out.println("2 - выпить лечебное зелье");
        System.out.print(Color.YELLOW);
        System.out.println("3 - применить заклинание увеличения брони");
        System.out.println(Color.RESET);
        switch (scanner.nextInt()) {
            case 1 -> orc.fight(human, orc);
            case 2 -> human.recovered(human);
            case 3 -> human.armored(human);
        }
    }

    /**
     * Выбрать уровень сложности
     */
    private void setHardLevel() {
        System.out.println("Выберите уровень сложности:");
        System.out.print(Color.MAGENTA);
        System.out.println("1 - орк-слабак (очень легко)");
        System.out.println("2 - орк-силач (непросто)");
        System.out.println("3 - орк-чемпион (кошмар)");
        System.out.println(Color.RESET);

        switch (scanner.nextInt()) {
            case 1 -> orc = new Orc(100, 40, 15);
            case 2 -> orc = new Orc(200, 50, 20);
            case 3 -> orc = new Orc(450, 60, 25);
        }
    }
}
