package javaForTesters.model;

import com.google.common.collect.ForwardingSet;

import java.util.*;

/**
 * Created by Антон on 17.09.2016.
 */
public class Accounts extends ForwardingSet<AccountCreation> {
  private Set<AccountCreation> delegate;

  public Accounts(Accounts accountCreations) {
    this.delegate = new LinkedHashSet<AccountCreation>(accountCreations.delegate());
  }
  public Accounts(Collection accountCreations) {
    this.delegate = new LinkedHashSet<AccountCreation>(accountCreations);
  }

  public Accounts() {
    this.delegate = new HashSet<>();
  }

  @Override
  protected Set<AccountCreation> delegate() {
    return delegate;
  }
  public Accounts withAdded(AccountCreation account)
  {
    Accounts accounts = new Accounts(this);
    accounts.add(account);
    return accounts;
  }
  public Accounts without(AccountCreation account)
  {
    Accounts accounts = new Accounts(this);
    accounts.remove(account);
    return accounts;
  }
}
