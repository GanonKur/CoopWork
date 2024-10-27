package Classes;

public class User implements Comparable<User>  {
    private  final String name;
    private final String password;
    private final String email;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
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
    public static class UserBuilder {
        private String name;
        private String password;
        private String email;

        public UserBuilder  setName(String name) {
            this.name = name;
            return this;
        }

        public  UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder  setEmail(String email) {
            this.email = email;
            return this;
        }
        public User build() {
            return new User("Миша", "митьььь", "ироло");
        }

        }
        }




