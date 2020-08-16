package lombok;

public class BuilderOnConstructor {

    private String param1;
    private String param2;
    private String param3;

    @Builder
    public BuilderOnConstructor(String param1, String param2, String param3) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }
}
