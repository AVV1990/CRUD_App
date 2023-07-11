package web.model;

import jakarta.persistence.*;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String firstName;
    private String lastName;
    private int age;

    public User() {
    }

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return  true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        User user = (User) obj;
        return this.age == user.age
                && (this.firstName == user.firstName || (this.firstName != null && this.firstName.equals(user.firstName)))
                && (this.lastName == user.lastName || (this.lastName != null && this.lastName.equals(user.lastName)));
    }


    @Override
    public int hashCode() {
        return 31 + (age == 0 ? 0 : Integer.valueOf(age).hashCode()) + (firstName == null ? 0 : firstName.hashCode()) + (lastName == null ? 0 :lastName.hashCode());
    }

    @Override
    public String toString() {
        return String.format(" User = [firstName = %s, lastName = %s, age = $d]",firstName,lastName,age);
    }
}
