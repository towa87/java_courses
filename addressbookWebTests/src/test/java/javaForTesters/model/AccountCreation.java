package javaForTesters.model;

public class AccountCreation {
  private int id = Integer.MAX_VALUE;
  private  String name;
  private  String lastname1;
  private  String nick;
  private  String title;
  private String company;
  private  String telephoneHome;
  private  String telephoneHome2;
  private  String mobilePhone;
  private  String mobilePhone2;
  private  String workPhone;
  private  String workPhone2;
  private  String workPhone3;
  private  String email;
  private String homepage;
  private  String birthday;

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
    this.email = email;  return this;
  }

  public AccountCreation withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;  return this;
  }

  public AccountCreation withTelephoneHome(String telephoneHome) {
    this.telephoneHome = telephoneHome; return this;
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

  public AccountCreation withTitle(String title) {
    this.title = title; return this;
  }

  public AccountCreation withTelephoneHome2(String telephoneHome2) {
    this.telephoneHome2 = telephoneHome2; return this;
  }

  public AccountCreation withMobilePhone2(String mobilePhone2) {
    this.mobilePhone2 = mobilePhone2; return this;
  }

  public AccountCreation withWorkPhone(String workPhone) {
    this.workPhone = workPhone; return this;
  }

  public AccountCreation withWorkPhone3(String workPhone3) {
    this.workPhone3 = workPhone3;
    return this;
  }

  public AccountCreation withWorkPhone2(String workPhone2) {
      this.workPhone2 = workPhone2;
    return this;
  }

  private String ayear;
  private String group;





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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AccountCreation that = (AccountCreation) o;

    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lastname1 != null ? lastname1.equals(that.lastname1) : that.lastname1 == null;

  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (lastname1 != null ? lastname1.hashCode() : 0);
    return result;
  }
}
