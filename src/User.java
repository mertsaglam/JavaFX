



public class User {
    private  String gender;
    private  String name;
    private  String surname;
    private  String password;
    private  String email;
    private  String phone;
    private  String rpass;
    private  String username;
    private String ID;
    
    
    
    

    
    
    public User(String gender,String name,String surname,String password,String email,String phone,String rpass,String username)
    {
        this.setGender(gender);   
        this.setName(name);
        this.setSurname(surname);
        this.setPassword(password);
        this.setEmail(email);
        this.setPhone(phone);
        this.setRpass(rpass);
        this.setUsername(username);      
    }
    public User(String gender,String name,String surname,String password,String email,String phone,String rpass,String username,String ID)
    {
        this.setGender(gender);   
        this.setName(name);
        this.setSurname(surname);
        this.setPassword(password);
        this.setEmail(email);
        this.setPhone(phone);
        this.setRpass(rpass);
        this.setUsername(username);  
        this.setID(ID);    
    }

    

  

    public String getUsername() {
        return username;
    }






    public void setUsername(String username) {
        this.username = username;
    }





    public String getRpass() {
        return rpass;
    }




    public void setRpass(String rpass) {
        this.rpass = rpass;
    }






    public String getPhone() {
        return phone;
    }




    public void setPhone(String phone) {
        this.phone = phone;
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





    public String getSurname() {
        return surname;
    }




    public void setSurname(String surname) {
        this.surname = surname;
    }



    public String getName() {
        return name;
    }







    public void setName(String name) {
        this.name = name;
    }






    public String getGender() {
        return gender;
    }





    public void setID(String ID) {
        this.ID = ID;
    }
    public String getID() {
        return ID;
    }





    public void setGender(String gender) {
        this.gender = gender;
    }

    
   

    
}
