package cn.tedu.entity;

import java.util.Date;

public class Resource {
    private Integer id;
    private String rname;
    private String uname;
    private Date date;
    private String des;
    private String address;

    public Resource() {
    }

    public Resource(Integer id, String rname, String uname, Date date, String des, String address) {
        this.id = id;
        this.rname = rname;
        this.uname = uname;
        this.date = date;
        this.des = des;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", rname='" + rname + '\'' +
                ", uname='" + uname + '\'' +
                ", date=" + date +
                ", des='" + des + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
