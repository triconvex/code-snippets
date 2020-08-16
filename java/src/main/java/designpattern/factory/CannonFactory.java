package designpattern.factory;

public class CannonFactory extends CameraFactory {

    @Override
    public Camera produce() {
        return new Cannon("캐논 카메라");
    }

}
