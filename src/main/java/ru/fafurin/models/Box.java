package ru.fafurin.models;

import ru.fafurin.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class Box implements Container {
    private Double freeSpace;

    private final List<Shape> shapes = new ArrayList<>();

    public Box(Double freeSpace) {
        System.out.println("Box free space: " + freeSpace);
        this.freeSpace = freeSpace;
    }

    /**
     * Добавление фигуры в коробку.
     * фигура помещается в коробку тольео если объем фигуры
     * меньше или равен свободному объёму коробки.
     *
     * @param shape - фигура
     */
    @Override
    public void add(Shape shape) {
        if (checkSpace(shape)) {
            freeSpace -= shape.getVolume();
            shapes.add(shape);
            printPositiveResult(shape);
        } else {
            printNegativeResult(shape);
        }
    }

    /**
     * Проверка объема помещаемой в коробку фигуры
     *
     * @param shape - фигура
     * @return true, если свободный объем коробки больше или равен объему фигуры,
     * иначе - false
     */
    private boolean checkSpace(Shape shape) {
        System.out.println(Shape.getName(shape) + " volume: " + roundDouble(shape.getVolume()));
        return freeSpace >= shape.getVolume();
    }

    /**
     * Вывод в консоль результата добавления фигуры в коробку,
     * общего числа и объема фигур в коробке
     *
     * @param shape - фигура
     */
    private void printPositiveResult(Shape shape) {
        System.out.print(Color.GREEN);
        System.out.printf("%s fit into a box\n", Shape.getName(shape));
        System.out.print(Color.RESET);
        System.out.printf("Box free space: %s\n", roundDouble(freeSpace));
        System.out.print(Color.YELLOW);
        System.out.printf("Box contains %s shapes\n", shapes.size());
        System.out.printf("All shapes volume in box: %s\n",
                roundDouble(shapes.stream().mapToDouble(Shape::getVolume).sum()));
        System.out.print(Color.RESET);
        System.out.println("-------------------");
    }

    /**
     * Вывод в консоль результата не добавления фигуры в коробку
     *
     * @param shape - фигура
     */
    private void printNegativeResult(Shape shape) {
        System.out.print(Color.RED);
        System.out.println(Shape.getName(shape) + " does not fit in the box");
        System.out.println("Please, try another shape...");
        System.out.print(Color.RESET);
        System.out.println("-------------------");
    }

    private Double roundDouble(Double volume) {
        return Math.round(volume * 100) / 100.0;
    }
}
