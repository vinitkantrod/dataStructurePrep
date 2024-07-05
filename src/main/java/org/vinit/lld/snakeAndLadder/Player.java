package org.vinit.lld.snakeAndLadder;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Player {
    String name;
    Integer id;
    private static AtomicInteger nextId = new AtomicInteger(0);

    public Player(Integer id, String s) {
        this.name = s;
        this.id = id;
    }

    public static Integer generateId() {
        return nextId.incrementAndGet();
    }
}
