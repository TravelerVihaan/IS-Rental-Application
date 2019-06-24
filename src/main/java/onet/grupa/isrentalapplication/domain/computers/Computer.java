package onet.grupa.isrentalapplication.domain.computers;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "computers")
public class Computer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_computer")
    private Long id;

    @NotEmpty
    @Column(name = "OT_number", nullable = false, unique = true)
    private String OTNumber;

    @NotEmpty
    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "os_id")
    @Column(name = "operating_system", nullable = false)
    private OperatingSystem operatingSystem;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "producer_id")
    @Column(name = "operating_system", nullable = false)
    private Producer producer;

    public Computer(){}
    public Computer(@NotEmpty String OTNumber, @NotEmpty String serialNumber, @NotNull OperatingSystem operatingSystem, @NotNull Producer producer) {
        this.OTNumber = OTNumber;
        this.serialNumber = serialNumber;
        this.operatingSystem = operatingSystem;
        this.producer = producer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOTNumber() {
        return OTNumber;
    }

    public void setOTNumber(String OTNumber) {
        this.OTNumber = OTNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", OTNumber='" + OTNumber + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", operatingSystem=" + operatingSystem +
                ", producer=" + producer +
                '}';
    }
}