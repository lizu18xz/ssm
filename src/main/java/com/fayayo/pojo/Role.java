package com.fayayo.pojo;
import org.apache.ibatis.type.Alias;
import java.io.Serializable;
@Alias("role") // MyBatis别名
public class Role implements Serializable {

    private static final long serialVersionUID = 23219283918391L;
    private Long id;
    private String roleName;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}