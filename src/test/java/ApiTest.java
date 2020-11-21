import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class ApiTest {

    @Test(groups = {"req"})
    public void testing() {

        String URL = "https://api.themoviedb.org/3/genre/movie/list?api_key=";
        int statusCode = 200;

        given()
                .header("contentType", "application/json")
                .when()
                .get(URL)
                .then()
                .log()
                .all();

        System.out.println(" time " + get(URL).timeIn(TimeUnit.MILLISECONDS));
        given().when().get(URL).then().assertThat().statusCode(200);
        given().when().get(URL).then().assertThat().header("content-type", "application/json;charset=utf-8");
    }
}
