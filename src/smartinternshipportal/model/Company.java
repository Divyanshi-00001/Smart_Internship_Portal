package smartinternshipportal.model;

public class Company {

    private int companyId;
    private String companyName;
    private String email;
    private String password;

    // Default Constructor
    public Company() {}

    // Parameterized Constructor
    public Company(int companyId, String companyName, String email, String password) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Company ID: " + companyId + ", Name: " + companyName + ", Email: " + email;
    }
}