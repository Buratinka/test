package app.model;

public class User extends Model
{
    private String fName;
    private String sName;
    private String password;
    private String mail;
    private String login;
    private String phone;

    private int age;
    private int cash;
    private int accessLevel;

    public User() {
    }

    public User(String mail)
    {
        this.mail = mail;
    }

    public User(String mail, String password)
    {

        this.mail = mail;
        this.password = password;

    }

    public User(String mail, String password, int accessLevel)
    {

        this.mail = mail;
        this.password = password;
        this.accessLevel = accessLevel;

    }

    public User(int id, String name, String password)
    {

    }


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o)
    {
        if(this == o)return true;
        if(o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if(age != user.age)return false;
        if(cash != user.cash) return false;
        if(accessLevel != user.accessLevel)return false;

        if(fName != null ? !fName.equals(user.fName) : user.fName != null)return false;
        if(sName != null ? !sName.equals(user.sName) : user.sName != null)return false;
        if(login != null ? !login.equals(user.login) : user.login != null)return false;
        if(mail != null ? !mail.equals(user.mail) : user.mail != null)return false;
        if(phone != null ? !phone.equals(user.phone) : user.phone != null)return false;

        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode()
    {
        int mult = 31;
        int result = fName!=null ? fName.hashCode() : 0;
        result = mult * result + (sName != null ? sName.hashCode() : 0);
        result = mult * result + (password != null ? password.hashCode() : 0);
        result = mult * result + (mail != null ? mail.hashCode() : 0);
        result = mult * result + (login != null ? login.hashCode() : 0);
        result = mult * result + (phone != null ? phone.hashCode() : 0);

        result = mult * result + age;
        result = mult * result + cash;
        result = mult * result + accessLevel;

        return result;
    }
}
