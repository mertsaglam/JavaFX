public class Manager extends User {
    private String ID;
    public Manager(String gender,String name,String surname,String password,String email,String phone,String rpass,String username,String ID)
    {   
        super( gender, name, surname, password, email, phone, rpass,username);
        this.setID(ID);

    }
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        this.ID = iD;
    }
    
    }