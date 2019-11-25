import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class APITests {
    private RestTemplate restTemplate;

    private final String API_BASE = "https://api.github.com";

    @BeforeMethod
    public void start() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void testUserInfoResponse() {
        User user = restTemplate.getForObject(API_BASE + "/users/EvgenyMyshkovets", User.class);
        //System.out.println(user);

        //User localUser = restTemplate.postForObject();

        Assert.assertTrue(user.getHtml_url().contains("https://github.com/EvgenyMyshkovets"));
    }

    @Test
    public void testFollowers() {
       User[] followers = restTemplate.getForObject(API_BASE + "/users/EvgenyMyshkovets/followers",
                User[].class);

        Assert.assertTrue(followers.length == 0);
    }
}
