package enumtest;

public enum MyEnum implements EnumInterface {
    RED("0", "红"), GREEN("1", "绿"), BLUE("2", "蓝");

    private String id;
    private String color;

    private MyEnum(String id, String color) {
        this.id = id;
        this.color = color;
    }
}
