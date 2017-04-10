package src;

/**
 * Created by touhoudoge on 2017/3/25.
 */



public class Account{
    class Birthday{
        int year;
        int month;
        int day;
    }

    String name;
    String password;
    Birthday birthday;
    String sex;

    public void setName(String name){
        this.name = name;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setBirthday(int year,int month,int day){
        this.birthday.year = year;
        this.birthday.month = month;
        this.birthday.day = day;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public Birthday getBirthday(){
        return birthday;
    }

    public String getSex(){
        return sex;
    }
}
