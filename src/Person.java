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

    public String getEmail(){
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
}

