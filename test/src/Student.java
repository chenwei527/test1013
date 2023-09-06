public class Student extends Person
{
    private int id;

    public Student(String n, int id)
    {
        super(n);
        this.id = id;
    }

    public String toString()
    {
        return super.toString()+", "+1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
