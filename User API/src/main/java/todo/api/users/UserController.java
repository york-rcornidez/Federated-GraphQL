package todo.api.users;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Query to fetch all users
    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Query to fetch a user by ID
    @QueryMapping
    public User getUserById(@Argument Long id) {
        return userService.getUserById(id);
    }

    // Mutation to create a new user
    @MutationMapping
    public User createUser(@Argument String email, @Argument String password) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        return userService.createUser(newUser);
    }

    // Mutation to update a user by ID
    @MutationMapping
    public User updateUser(@Argument Long id, @Argument String email, @Argument String password) {
        User updatedUser = new User();
        updatedUser.setEmail(email);
        updatedUser.setPassword(password);
        return userService.updateUser(id, updatedUser);
    }

    // Mutation to delete a user by ID
    @MutationMapping
    public String deleteUser(@Argument Long id) {
        userService.deleteUser(id);
        return "User with ID " + id + " deleted successfully!";
    }
}