package api.pojo;

public class User
{
    private String firstName;
    private String lastName;
    private int age;

    public User(String f, String l, int a)
    {
        firstName = f;
        lastName = l;
        age = a;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String f)
    {
        firstName = f;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String l)
    {
        lastName = l;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int a)
    {
        age = a;
    }

}
