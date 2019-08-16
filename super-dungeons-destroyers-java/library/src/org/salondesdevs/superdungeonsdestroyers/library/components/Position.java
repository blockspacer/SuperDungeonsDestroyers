package org.salondesdevs.superdungeonsdestroyers.library.components;

import net.wytrem.ecs.*;

public class Position implements Component {

    public int x, y;

    public Position() {
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void set(int x, int y) {
        setX(x);
        setY(y);
    }

    public void increment(Direction direction) {
        this.x += direction.x;
        this.y += direction.y;
    }
}