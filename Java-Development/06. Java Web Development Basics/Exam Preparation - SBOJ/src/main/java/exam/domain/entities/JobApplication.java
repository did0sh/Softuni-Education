package exam.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity(name = "job_applications")
public class JobApplication extends BaseEntity {

    private String sector;
    private String profession;
    private BigDecimal salary;
    private String description;

    public JobApplication() {
    }

    @Column(name = "sector", nullable = false)
    public String getSector() {
        return this.sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Column(name = "profession", nullable = false)
    public String getProfession() {
        return this.profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Column(name = "salary", nullable = false, columnDefinition = "DECIMAL(10,2)")
    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
