package kraken.basic.jpa.orm;

import kraken.basic.jpa.KRAKEN_BASIC_TABLE;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = KRAKEN_BASIC_TABLE.SYS_VERSION_TABLE)
public class SystemVersion {

    public enum TERMINAL {
        WEB, ANDROID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private TERMINAL terminal;

    private String version;

    private String info;

    private String remark;

    @Column(name = "create_time")
    private Timestamp createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TERMINAL getTerminal() {
        return terminal;
    }

    public void setTerminal(TERMINAL terminal) {
        this.terminal = terminal;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
