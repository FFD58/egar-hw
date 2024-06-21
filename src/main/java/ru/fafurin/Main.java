package ru.fafurin;

import ru.fafurin.factories.Factory;
import ru.fafurin.factories.ShapesFactory;
import ru.fafurin.models.Box;
import ru.fafurin.models.Container;
import ru.fafurin.models.Shape;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Factory shapesFactory = new ShapesFactory();

        List<Shape> shapes = shapesFactory.createRandomShapes(20);

        Container box = new Box(10000.0);

        for (Shape shape : shapes) {
            box.add(shape);
        }
    }
}