package ir.shariaty.financialmanagement;

public class User {
    private String name;
    private String email;
    private String pass;
    private String refer;

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public String getRefer() {
        return refer;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
