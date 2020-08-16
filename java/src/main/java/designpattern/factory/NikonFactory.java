package designpattern.factory;

public class NikonFactory extends CameraFactory {

    @Override
    public Camera produce() {
        return new Nikon("니콘 카메라");
    }

}
