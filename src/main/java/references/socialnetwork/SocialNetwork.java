package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

  private List<Member> members = new ArrayList<>();


  public void addMember(String name) {
    Member member = new Member(name);
    members.add(member);
  }

  public void connect(String name, String otherName) {
    Member first = findByName(name);
    first.connectMember(findByName(otherName));
  }

  public List<String> bidirectionalConnections() {
    List<String> connections = new ArrayList<>();
    for (int i = 0; i < members.size(); i++) {
      for (int j = 0; j < members.size(); j++) {
        if (members.get(i).getConnections().contains(members.get(j))) {
          connections.add(members.get(i).getName() + " - " + members.get(j).getName());
        }
      }
    }
    return connections;
  }

  private Member findByName(String name) {
    for (Member member : members) {
      if (member.getName().equals(name)) {
        return member;
      }
    }
    return null;
  }
  public static void main(String[] args) {

  }

}
