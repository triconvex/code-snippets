package designpattern.factory;

import lombok.Getter;

@Getter
public abstract class Camera {

    private final String name;

    public Camera(String name) {
        this.name = name;
    }

}
