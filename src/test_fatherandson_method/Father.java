package test_fatherandson_method;

public abstract class Father {
    private String name;
    private String id;

    public Father() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    protected void printData(){
        System.out.println("Father: " + id + name);
    }
}
