package javaForTesters.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.Properties;
import java.io.File;

@XStreamAlias("AccountCreation")
public class AccountCreation {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  private  String name;
  private  String lastname1;
  private  String nick;
  private  String title;
  private String company;
//  private  String WorkPhone;
  private  String mobilePhone;
  private String ayear =null;
  private String group;
  private  String telephoneHome;
  private  String allPhone;
  private  String address;
  private  String workPhone;
  private  String email;
  private  String email2;
  private  String email3;
  private  String allEmails;
  private String homepage;
  private  String birthday =null;


  public File getPhoto() {
    return photo;
  }

  public AccountCreation  withPhoto(File photo) {
    this.photo = photo; return this;
  }

  private File photo;

 // public AccountCreation(Accounts accountCreations) {
  //}

  public AccountCreation withAyear(String ayear) {
    this.ayear = ayear; return this;
  }

  public AccountCreation withGroup(String group) {

    this.group = group; return this;
  }

  public AccountCreation withBirthday(String birthday) {
    this.birthday = birthday; return this;
  }

  public AccountCreation withHomepage(String homepage) {
    this.homepage = homepage; return this;
  }

  public AccountCreation withEmail(String email) {
    this.email = email; return this;
  }
  public AccountCreation withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone; return this;
  }


  public AccountCreation withTelephoneHome(String telephoneHome) {
    this.telephoneHome = telephoneHome; return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AccountCreation that = (AccountCreation) o;

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lastname1 != null ? lastname1.equals(that.lastname1) : that.lastname1 == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (lastname1 != null ? lastname1.hashCode() : 0);
    return result;
  }

  public AccountCreation withLastname1(String lastname1) {
    this.lastname1 = lastname1; return this;
  }

  public AccountCreation withName(String name) {
    this.name = name; return this;
  }

  public AccountCreation withNick(String nick) {
    this.nick = nick; return this;
  }

  public AccountCreation withCompany(String company) {
    this.company = company; return this;
  }

  public AccountCreation withAddress(String address) {
    this.address = address; return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public AccountCreation withAllEmails(String allEmails) {
    this.allEmails = allEmails; return this;
  }


  public AccountCreation withWorkPhone(String workPhone) {
    this.workPhone = workPhone; return this;
  }

  public AccountCreation withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }


  public AccountCreation withEmail2(String email2) {
    this.email2 = email2;  return this;
  }



  public String getAllPhone() {
    return allPhone;
  }

  public AccountCreation withAllPhone(String allPhone) {
    this.allPhone = allPhone; return this;
  }


  public String getName() {
    return name;
  }

  public String getLastname() {
    return lastname1;
  }

  public String getNick() {
    return nick;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getTelephoneHome() {
    return telephoneHome;
  }

  public String getEmail2() {
    return email2;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getEmail3() {
    return email3;
  }

  public String getWorkPhone() {
    return workPhone;
  }




  public String getAddress() {
    return address;
  }
  public String getEmail() {
    return email;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getBirthday() {
    return birthday;
  }

  public String getAyear() {
    return ayear;
  }
  public String getGroup() {
    return group;
  }
  public int getId() {
    return id;
  }

  public AccountCreation withId(int id) { this.id = id; return this; }

  @Override
  public String toString() {
    return "AccountCreation{" +
            "id=" + id +

            ", name='" + name + '\'' +
            ", lastname1='" + lastname1 + '\'' +
            '}';
  }


}
