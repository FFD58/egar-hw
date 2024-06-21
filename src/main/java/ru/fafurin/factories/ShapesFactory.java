package ru.fafurin.factories;

import ru.fafurin.models.Ball;
import ru.fafurin.models.Cylinder;
import ru.fafurin.models.Pyramid;
import ru.fafurin.models.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShapesFactory implements Factory {
    private final Random random = new Random();

    private final static Double LOWER_BOUND = 5.0;
    private final static Double UPPER_BOUND = 50.0;

    /**
     * Создание фигуры со случайными параметрами по названию класса
     *
     * @param shape - название класса фигуры
     * @return фигура
     */
    @Override
    public Shape create(String shape) {
        switch (shape) {
            case "Ball" -> {
                return new Ball(getRandomDouble());
            }
            case "Pyramid" -> {
                return new Pyramid(getRandomDouble(), getRandomDouble());
            }
            case "Cylinder" -> {
                return new Cylinder(getRandomDouble(), getRandomDouble());
            }
        }
        return null;
    }

    /**
     * Создание требуемого количества случайных фигур
     *
     * @param count - требуемое количество фигур
     * @return список случайных фигур
     */
    @Override
    public List<Shape> createRandomShapes(int count) {
        List<Shape> shapes = new ArrayList<>();
        List<String> shapeNames = Shape.getAllImplClassNames();
        for (int i = 0; i < count; i++) {
            String randomShape = shapeNames.get(random.nextInt(0, shapeNames.size()));
            shapes.add(create(randomShape));
        }
        return shapes;
    }

    /**
     * Генерация случайного вещественного числа в диапазоне LOWER_BOUND, UPPER_BOUND
     *
     * @return случайное вещественное число
     */
    private Double getRandomDouble() {
        return random.nextDouble(LOWER_BOUND, UPPER_BOUND);
    }

}
