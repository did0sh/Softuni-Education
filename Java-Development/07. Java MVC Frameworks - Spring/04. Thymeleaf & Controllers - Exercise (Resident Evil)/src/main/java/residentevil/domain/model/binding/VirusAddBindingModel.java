package residentevil.domain.model.binding;

import org.springframework.format.annotation.DateTimeFormat;
import residentevil.domain.entities.Creator;
import residentevil.domain.entities.Magnitude;
import residentevil.domain.entities.Mutation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class VirusAddBindingModel {

    private static final String CAN_NOT_BE_EMPTY = "Invalid name! Field cannot be empty!";
    private static final String INVALID_NAME = "Invalid name! Symbols must be between 3 and 10!";

    private String name;
    private String description;
    private String sideEffects;
    private Creator creator;
    private Boolean isDeadly;
    private Boolean isCurable;
    private Mutation mutation;
    private Integer turnoverRate;
    private Integer hoursUntilTurn;
    private Magnitude magnitude;
    private LocalDate releasedOn;
    private List<String> capitals;

    public VirusAddBindingModel() {
    }

    @NotNull(message = CAN_NOT_BE_EMPTY)
    @Size(min = 3, max = 10, message = INVALID_NAME)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSideEffects() {
        return this.sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public Creator getCreator() {
        return this.creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public Boolean getDeadly() {
        return this.isDeadly;
    }

    public void setDeadly(Boolean deadly) {
        isDeadly = deadly;
    }

    public Boolean getCurable() {
        return this.isCurable;
    }

    public void setCurable(Boolean curable) {
        isCurable = curable;
    }

    public Mutation getMutation() {
        return this.mutation;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    public Integer getTurnoverRate() {
        return this.turnoverRate;
    }

    public void setTurnoverRate(Integer turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public Integer getHoursUntilTurn() {
        return this.hoursUntilTurn;
    }

    public void setHoursUntilTurn(Integer hoursUntilTurn) {
        this.hoursUntilTurn = hoursUntilTurn;
    }

    public Magnitude getMagnitude() {
        return this.magnitude;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getReleasedOn() {
        return this.releasedOn;
    }

    public void setReleasedOn(LocalDate releasedOn) {
        this.releasedOn = releasedOn;
    }

    public List<String> getCapitals() {
        return this.capitals;
    }

    public void setCapitals(List<String> capitals) {
        this.capitals = capitals;
    }
}
