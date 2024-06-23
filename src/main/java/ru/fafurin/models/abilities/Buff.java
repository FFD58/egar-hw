package ru.fafurin.models.abilities;

import ru.fafurin.models.Hero;

public interface Buff {
    void armored(Hero hero);

    void recovered(Hero hero);

    boolean dodge(Hero hero);
}
