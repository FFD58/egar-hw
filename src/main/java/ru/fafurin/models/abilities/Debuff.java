package ru.fafurin.models.abilities;

import ru.fafurin.models.Hero;

public interface Debuff {
    void criticalDamage(Hero hero);

    void weakened(Hero hero);

    void dearmored(Hero hero);
}
