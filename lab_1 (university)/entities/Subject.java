package entities;

public class Subject {

    private int id;
    private String name;

    public Subject(int _id, String _name) {
        this.id = _id;
        this.name = _name;
    }

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }
}
