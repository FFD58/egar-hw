package ru.fafurin.factories;

import ru.fafurin.models.Shape;

import java.util.List;

public interface Factory {
    Shape create(String shape);

    List<Shape> createRandomShapes(int count);
}
