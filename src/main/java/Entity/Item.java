package Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "item")
public class Item implements Serializable {
    private static final long serialVersionIID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int iid;
    private String iname;

    public Item(){

    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    @Override
    public String toString() {
        return "Item{" +
                "iid=" + iid +
                ", iname='" + iname + '\'' +
                '}';
    }
}
