package main;

import geometry.Point;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        Point p = new Point(10.0,10.0);
        System.out.println(p.getX());
    }
}
