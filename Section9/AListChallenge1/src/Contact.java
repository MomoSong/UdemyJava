/**
 * Created by johnm on 2017-01-15.
 */
public class Contact {

    private String name;
    private String phoneNum;

    public Contact(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public static Contact getContact(String name, String phoneNum){
        return new Contact(name, phoneNum);
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

}
