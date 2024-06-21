package ru.fafurin.models;

import org.reflections.Reflections;

import java.util.List;

public interface Shape {
    Double getVolume();

    /**
     * Получить список названий всех классов, расширяющих данный интерфейс
     *
     * @return список названий классов
     */
    static List<String> getAllImplClassNames() {
        Reflections reflections = new Reflections("ru.fafurin");
        return reflections.getSubTypesOf(Shape.class)
                .stream().map(Class::getSimpleName).toList();
    }

    /**
     * Получить названия класса, расширяющего интерфейс
     *
     * @param shape - фигура
     * @return строка с именем класса
     */
    static String getName(Shape shape) {
        return shape.getClass().getSimpleName();
    }
}
