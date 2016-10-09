package javaForTesters.model;

import com.google.common.collect.ForwardingSet;
import sandbox.Collections;

import java.util.*;

/**
 * Created by Антон on 17.09.2016.
 */
public class Groups extends ForwardingSet<GroupData> {

  private Set<GroupData> delegate;

  public Groups(Collection<GroupData> groups) {
    this.delegate = new HashSet<GroupData>(groups);
  }
  public Groups(Groups groups) {
    this.delegate = new HashSet<GroupData>(groups.delegate);
  }
  public Groups() {
    this.delegate = new HashSet<GroupData>();
  }


  @Override
  protected Set<GroupData> delegate() {
    return delegate;
  }
  public Groups withAdded(GroupData group){
    Groups groups = new Groups(this);
    groups.add(group);
    return groups;
  }
  public Groups without(GroupData group){
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }
}
