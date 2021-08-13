package cn.tedu.entity;

public class Person {
    private String uname;
    private String upwd;
    private String email;
    private String phone;
    private Integer state;
    private Integer role;

    public Person() {
    }

    public Person(String uname, String upwd, String email, String phone, Integer state, Integer role) {
        this.uname = uname;
        this.upwd = upwd;
        this.email = email;
        this.phone = phone;
        this.state = state;
        this.role = role;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", state=" + state +
                ", role=" + role +
                '}';
    }
}
