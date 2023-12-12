package ita.bilabonemmenteksamenback.dto;

public class CustomerDTO {
    private String name;
    private String email;
    private String contactNumber;
    private String addressStreet;
    private String addressPost; //postcode
    private Boolean creditApproved;

    public CustomerDTO(String name, String email, String contactNumber, String addressStreet, String addressPost, Boolean creditApproved) {
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.addressStreet = addressStreet;
        this.addressPost = addressPost;
        this.creditApproved = creditApproved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressPost() {
        return addressPost;
    }

    public void setAddressPost(String addressPost) {
        this.addressPost = addressPost;
    }

    public Boolean getCreditApproved() {
        return creditApproved;
    }

    public void setCreditApproved(Boolean creditApproved) {
        this.creditApproved = creditApproved;
    }
}
