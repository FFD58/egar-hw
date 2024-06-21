package ru.fafurin.models;

public class Cylinder implements Shape {
    private final Double radius;
    private final Double height;

    public Cylinder(Double radius, Double height) {
        this.radius = radius;
        this.height = height;
    }

    /**
     * Переопределение метода для подсчета объема цилиндра
     *
     * @return объем цилиндра
     */
    @Override
    public Double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
