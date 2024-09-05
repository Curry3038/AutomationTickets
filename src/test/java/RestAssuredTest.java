import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Credential;
import models.Users;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class RestAssuredTest {
  String baseUrl="https://reqres.in/api";
  @Test
    public void CorrectRegistration( ){

      Credential credential=new Credential("eve.holt@reqres.in","pistol");
      Response response =
              given()
                      .baseUri(baseUrl)
                      .basePath("/register")
                      .header("Accept","application/json")
                      .header("Content-type","application/json")
                      .body(credential)
              .when()
                      .post()
              .then()
                      .statusCode(200)
                      .extract()
                      .response();
      response.prettyPrint();

  }
  @Test
  public void InCorrectRegistration( ) {

    Credential InCorrect = new Credential("sydney@fife");
    Response response =
            given()
                    .baseUri(baseUrl)
                    .basePath("/register")
                    .header("Accept", "application/json")
                    .header("Content-type", "application/json")
                    .body(InCorrect)
                    .when()
                    .post()
                    .then()
                    .statusCode(400)
                    .extract()
                    .response();
    response.prettyPrint();

  }
  @Test
  public void ListUsers( ) {

    Response response =
            given()
                    .baseUri(baseUrl)
                    .basePath("/users")
                    .queryParam("page" ,2)
                    .when()
                    .get()
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();
    response.prettyPrint();

}
@Test
  public void DeleteUsers(){
    Response response=
            given()
                    .baseUri(baseUrl)
                    .basePath("/users/2")
            .when()
                    .delete()
            .then()
                    .statusCode(204)
                    .extract().response();


}
  @Test
  public void UpdateUsers( ) {

    Users user = new Users("morpheus", "zion resident");
    Response response =
            given()
                    .baseUri(baseUrl)
                    .basePath("/users/2")
                    .header("Accept", "application/json")
                    .header("Content-type", "application/json")
                    .body(user)
                    .when()
                    .patch()
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();
    response.prettyPrint();
    JsonPath jsonPath=response.jsonPath();
    String updatedAt = jsonPath.getString("updatedAt");
    System.out.println(updatedAt);




  }

}
