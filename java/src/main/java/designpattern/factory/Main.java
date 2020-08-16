package designpattern.factory;

public class Main {

    public static void main(String[] args) {
        CameraFactory cameraFactory = new NikonFactory();
        Camera nikonCamera = cameraFactory.produce();
        System.out.println(nikonCamera.getName());

        CameraFactory cannonFactory = new CannonFactory();
        Camera cannonCamera = cannonFactory.produce();
        System.out.println(cannonCamera.getName());
    }

}
