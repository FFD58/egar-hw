package ru.fafurin.models;

public class Pyramid implements Shape {
    private final Double baseArea;
    private final Double height;

    public Pyramid(Double baseArea, Double height) {
        this.baseArea = baseArea;
        this.height = height;
    }

    /**
     * Переопределение метода для подсчета объема пирамиды
     *
     * @return объем пирамиды
     */
    @Override
    public Double getVolume() {
        return (baseArea * height) / 3;
    }
}
