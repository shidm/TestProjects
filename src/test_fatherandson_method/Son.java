package test_fatherandson_method;

public class Son extends Father {
    @Override
    protected void printData() {
        System.out.println("Son" + getId() + getName());
    }
}
