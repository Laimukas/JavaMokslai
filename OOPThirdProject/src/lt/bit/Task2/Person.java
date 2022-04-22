package lt.bit.Task2;

public abstract class Person {

    protected String name, address;

    public Person(){
        name = "";
        address = "";
    }

    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String toString(){
        return String.format("%s->%s", name, address);
    }
}
