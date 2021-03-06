package CategoryC;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "SaveOperations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Datalist { // хранение данных
    @XmlElement
    private List<Data> datalist = null;

    public List<Data> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<Data> datalist) {
        this.datalist = datalist;
    }
}
