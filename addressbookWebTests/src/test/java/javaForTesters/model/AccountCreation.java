package javaForTesters.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Properties;
import java.io.File;
import java.util.Set;

@Entity
@Table(name = "addressbook")
@XStreamAlias("AccountCreation")
public class AccountCreation {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  @Column(name = "firstname")
  private String name;
  @Column(name = "lastname")
  private String lastname1;
  @Column(name = "nickname")
  private String nick;
  private String title;
  private String company;
  //  private  String WorkPhone;
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;
  @Transient
  private String ayear = null;

    @Column(name = "home")
  @Type(type = "text")
  private String telephoneHome;
  @Transient
  private String allPhone;
  @Column(name = "address")
  @Type(type = "text")
  private String address;
  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;
  @Column(name = "email")
  @Type(type = "text")
  private String email;
  @Column(name = "email2")
  @Type(type = "text")
  private String email2;
  @Column(name = "email3")
  @Type(type = "text")
  private String email3;
  @Transient
  private String allEmails;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AccountCreation that = (AccountCreation) o;

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (lastname1 != null ? !lastname1.equals(that.lastname1) : that.lastname1 != null) return false;
    if (company != null ? !company.equals(that.company) : that.company != null) return false;
    if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
    if (telephoneHome != null ? !telephoneHome.equals(that.telephoneHome) : that.telephoneHome != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
    if (email != null ? !email.equals(that.email) : that.email != null) return false;
    if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
    if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
    return homepage != null ? homepage.equals(that.homepage) : that.homepage == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (lastname1 != null ? lastname1.hashCode() : 0);
    result = 31 * result + (company != null ? company.hashCode() : 0);
    result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
    result = 31 * result + (telephoneHome != null ? telephoneHome.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (email2 != null ? email2.hashCode() : 0);
    result = 31 * result + (email3 != null ? email3.hashCode() : 0);
    result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
    return result;
  }

  public void setId(int id) {

    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname1() {
    return lastname1;
  }

  public void setLastname1(String lastname1) {
    this.lastname1 = lastname1;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public void setTelephoneHome(String telephoneHome) {
    this.telephoneHome = telephoneHome;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setEmail2(String email2) {
    this.email2 = email2;
  }

  public void setEmail3(String email3) {
    this.email3 = email3;
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  @Column(name = "homepage")
  @Type(type = "text")

  private String homepage;
  @Transient
  private String birthday = null;
  @Transient
  private String photo;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name ="group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  public File getPhoto() {
    return new File (photo);
  }

  public AccountCreation withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }



  // public AccountCreation(Accounts accountCreations) {
  //}

  public AccountCreation withAyear(String ayear) {
    this.ayear = ayear;
    return this;
  }



  public AccountCreation withBirthday(String birthday) {
    this.birthday = birthday;
    return this;
  }

  public AccountCreation withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public AccountCreation withEmail(String email) {
    this.email = email;
    return this;
  }

  public AccountCreation withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }


  public AccountCreation withTelephoneHome(String telephoneHome) {
    this.telephoneHome = telephoneHome;
    return this;
  }

  public Groups getGroups() {
    return new Groups(groups);
  }

  public AccountCreation withLastname1(String lastname1) {
    this.lastname1 = lastname1;
    return this;
  }

  public AccountCreation withName(String name) {
    this.name = name;
    return this;
  }

  public AccountCreation withNick(String nick) {
    this.nick = nick;
    return this;
  }

  public AccountCreation withCompany(String company) {
    this.company = company;
    return this;
  }

  public AccountCreation withAddress(String address) {
    this.address = address;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public AccountCreation withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }


  public AccountCreation withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public AccountCreation withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }


  public AccountCreation withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }


  public String getAllPhone() {
    return allPhone;
  }

  public AccountCreation withAllPhone(String allPhone) {
    this.allPhone = allPhone;
    return this;
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



  public int getId() {
    return id;
  }

  public AccountCreation withId(int id) {
    this.id = id;
    return this;
  }

  @Override
  public String toString() {
    return "AccountCreation{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastname1='" + lastname1 + '\'' +
            ", company='" + company + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", telephoneHome='" + telephoneHome + '\'' +
            ", address='" + address + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", email='" + email + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", homepage='" + homepage + '\'' +
            ", photo='" + photo + '\'' +
            '}';
  }


  public AccountCreation inGroup(GroupData group) {
    groups.add(group);
    return this;
  }
}
