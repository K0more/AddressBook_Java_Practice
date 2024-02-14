import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Objects;


public class Person {
    private String firstname;
    private String lastname;
    private String city;
    private String state;
    private Integer zip;
    private Integer phoneNo;
    private String email;


    public String getFirstname(){
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    public String getEmail() {
        return email;
    }

    public Integer getZip(){
        return zip;
    }

    public Integer getPhoneNo(){
        return phoneNo;
    }

    public  void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public void setCity(String city){
        this.city = city;
    }

    public  void setState(String state){
        this.state = state;
    }

    public void setZip(Integer zip){
        this.zip = zip;
    }

    public void setPhoneNo(Integer phoneNo){
        this.phoneNo = phoneNo;
    }

    public  void setEmail(String email){
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(firstname, person.firstname) &&
                Objects.equals(lastname, person.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneNo=" + phoneNo +
                ", email='" + email + '\'' +
                '}';
    }
}

