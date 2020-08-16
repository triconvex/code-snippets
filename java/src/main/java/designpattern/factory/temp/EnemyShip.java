package designpattern.factory.temp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class EnemyShip {

    private String name;
    private Double damage;

    public void followHeroShip() {
        System.out.println(name + "is following hero ship");
    }

}
