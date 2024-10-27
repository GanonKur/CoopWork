package Classes;

public class User implements Comparable<User>{
    private String name;
    private String password;
    private String email;

    public User(String name, String password, String email) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
    public User(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    @Override
    public int compareTo(User other) {
            int numberCompare = this.name.compareTo(other.name);
            if (numberCompare != 0) {
                return numberCompare;
            }

            int mileageCompare = this.password.compareTo(other.password);
            if (mileageCompare != 0) {
                return mileageCompare;
            }

            return this.email.compareTo(other.email);

    }
}