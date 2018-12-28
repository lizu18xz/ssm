package com.fayayo.pojo;
import org.apache.ibatis.type.Alias;
import java.io.Serializable;
@Alias("user") // MyBatis别名
public class User implements Serializable {

    private static final long serialVersionUID = -2323297841948476564L;
    private Long id;
    private String userName;
    private SexEnum sex; // 枚举，将来需要MyBatis的typeHandler进行转换
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}