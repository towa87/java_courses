package javaForTesters.model;

public class AccountCreation {
  private final String name;
  private final String lastname1;
  private final String nick;
  private final String title;
  private final String company;
  private final String telephoneHome;
  private final String telephoneHome2;
  private final String mobilePhone;
  private final String mobilePhone2;
  private final String workPhone;
  private final String workPhone2;
  private final String workPhone3;
  private final String email;
  private final String homepage;
  private final String birthday;
  private final String ayear;

  public AccountCreation(String name, String lastname1, String nick, String title, String company, String telephoneHome, String telephoneHome2, String mobilePhone, String mobilePhone2, String workPhone, String workPhone2, String workPhone3, String email, String homepage, String birthday, String ayear) {
    this.name = name;
    this.lastname1 = lastname1;
    this.nick = nick;
    this.title = title;
    this.company = company;
    this.telephoneHome = telephoneHome;
    this.telephoneHome2 = telephoneHome2;
    this.mobilePhone = mobilePhone;
    this.mobilePhone2 = mobilePhone2;
    this.workPhone = workPhone;
    this.workPhone2 = workPhone2;
    this.workPhone3 = workPhone3;
    this.email = email;
    this.homepage = homepage;
    this.birthday = birthday;
    this.ayear = ayear;
  }

  public String getName() {
    return name;
  }

  public String getLastname1() {
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

  public String getTelephoneHome2() {
    return telephoneHome2;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getMobilePhone2() {
    return mobilePhone2;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getWorkPhone2() {
    return workPhone2;
  }

  public String getWorkPhone3() {
    return workPhone3;
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
}
