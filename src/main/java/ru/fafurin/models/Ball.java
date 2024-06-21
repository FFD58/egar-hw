package ru.fafurin.models;

public class Ball implements Shape {
    private final Double radius;

    public Ball(Double radius) {
        this.radius = radius;
    }

    /**
     * Переопределение метода для подсчета объема шара
     *
     * @return объем шара
     */
    @Override
    public Double getVolume() {
        return Math.PI * Math.pow(radius, 3) * 4 / 3;
    }
}
