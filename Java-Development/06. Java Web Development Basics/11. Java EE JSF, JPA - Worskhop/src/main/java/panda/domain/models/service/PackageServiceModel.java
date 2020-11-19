package panda.domain.models.service;

public class PackageServiceModel {

    private String description;
    private Double weight;
    private String shippingAddress;
    private UserServiceModel recipient;

    public PackageServiceModel() {
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getShippingAddress() {
        return this.shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public UserServiceModel getRecipient() {
        return this.recipient;
    }

    public void setRecipient(UserServiceModel recipient) {
        this.recipient = recipient;
    }
}
