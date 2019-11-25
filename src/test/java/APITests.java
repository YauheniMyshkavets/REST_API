import controllers.UserController;
import models.User;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class APITests {
   private UserController userController;

    @BeforeMethod
    public void start() {
        userController = new UserController();
    }

    @Test
    public void testUserInfoResponse() {
        User user = userController.getUserByUsername("EvgenyMyshkovets");
        //System.out.println(user);

        //User localUser = restTemplate.postForObject();

        Assert.assertTrue(user.getHtml_url().contains("https://github.com/EvgenyMyshkovets"));
    }

    @Test
    public void testFollowers() {
       User[] followers = userController.getFollowersByUsername("EvgenyMyshkovets");

        Assert.assertTrue(followers.length == 0);
    }
}
