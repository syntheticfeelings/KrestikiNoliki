package com.company;

import java.io.Serializable;
import java.util.Objects;

public class Player implements Serializable {
    private String name;
    private String element;

    public Player(String name, String element) {
        this.name = name;
        this.element = element;
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(element, player.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, element);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", element='" + element + '\'' +
                '}';
    }
}
