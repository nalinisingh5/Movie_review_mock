package service;

import model.User;
import repository.UserRepository;

public class UserService {

  public static User findUserByName(String user) {
    return UserRepository.userSet.stream()
        .filter(user1 -> user1.getName().equals(user))
        .findAny()
        .orElseThrow();
  }

  public static void setUserAsViewer(String user) {
    User viewer =
        UserRepository.userSet.stream()
            .filter(userAsViewer -> userAsViewer.getName().equals(user))
            .findAny()
            .orElseThrow();
    viewer.setType("Viewer");
    UserRepository.userSet.add(viewer);
  }

  public static void setUserAsCritic(String user) {
    User critic =
        UserRepository.userSet.stream()
            .filter(viewer -> viewer.getName().equals(user))
            .findAny()
            .orElseThrow();
    critic.setType("Critic");
    UserRepository.userSet.add(critic);
  }

  public User createUser(String name, String email, String phoneNumber) {
    User user = new User(name, email, phoneNumber);
    UserRepository.userSet.add(user);
    return user;
  }
}
