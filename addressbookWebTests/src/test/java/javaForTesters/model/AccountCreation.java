package javaForTesters.model;

public class AccountCreation {
  private int id;
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
  private String group;



  public AccountCreation(String name, String lastname1, String nick, String title, String company, String telephoneHome, String telephoneHome2, String mobilePhone, String mobilePhone2, String workPhone, String workPhone2, String workPhone3, String email, String homepage, String birthday, String ayear, String group) {
    id = Integer.MAX_VALUE;

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
    this.group = group;
  }

  public AccountCreation( int id, String name, String lastname1, String nick, String title, String company, String telephoneHome, String telephoneHome2, String mobilePhone, String mobilePhone2, String workPhone, String workPhone2, String workPhone3, String email, String homepage, String birthday, String ayear, String group) {
    this.id = id;
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
    this.group = group;
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
  public String getGroup() {
    return group;
  }
  public int getId() {
    return id;
  }

  public void setId(int id) { this.id = id; }

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
