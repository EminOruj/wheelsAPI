import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class tasks {

    @Test
    public void verifySocialAccounts(String twitter, String instagram) {

        String twitterExpected = "https://twitter.com/WheelsUp";
        String instagramExpected = "http://instagram.com/wheelsup";
        Response response =  given().accept(ContentType.JSON)
                .and()
                .when().get("https://wheelsup.com/_mock_/initial-data.json");

                        JsonPath path = response.jsonPath();

        assertThat(twitterExpected, is(path.getString("keys.twitter")));

        System.out.println( path.getString("keys.twitter"));

        assertThat(instagramExpected, is(equalTo(path.getString("keys.instagram"))));

    }

    @Test
    public void displayEditedKeys() {
        Response response = given().accept(ContentType.JSON)
                .and()
                .when().get("https://wheelsup.com/_mock_/initial-data.json");

    }

    //api partially


}
