package my.com.yewchinsheng.yewchinsheng;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "user")
public class User {
    @PrimaryKey
    @NonNull
    private String IC;
    private String name;
    private String status;
    private String yearOld;
    private String fee;

    public User() {
    }

    public User(@NonNull String IC, String name, String status, String yearOld,String fee) {
        this.IC = IC;
        this.name = name;
        this.status = status;
        this.yearOld = yearOld;
        this.fee = fee;
    }

    @NonNull
    public String getIC() {
        return IC;
    }

    public void setIC(@NonNull String IC) {
        this.IC = IC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getYearOld() {
        return yearOld;
    }

    public void setYearOld(String yearOld) {
        this.yearOld = yearOld;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
