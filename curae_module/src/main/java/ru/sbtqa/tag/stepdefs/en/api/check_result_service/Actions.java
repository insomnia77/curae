package ru.sbtqa.tag.stepdefs.en.api.check_result_service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.And;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import ru.sbtqa.tag.stepdefs.en.api.check_result_service.models.ingest.FPR;

import static ru.sbtqa.tag.pagefactory.web.drivers.WebDriverService.PROPERTIES;

public class Actions {


    @And("^post result ingest for guid \"([^\"]*)\" and job \"([^\"]*)\"$")
    public void resultIngest(String guid, String job_id) throws JsonProcessingException {
        //RestAssured.port = 443;
        RestAssured.baseURI = "http://beta-result-ingest-nlb-f2a1db66be033399.elb.eu-north-1.amazonaws.com:8080";
        FPR fpr = new FPR();
        ObjectMapper objectMapper = new ObjectMapper();

        fpr.setCheck_guid(guid);
        fpr.setJob_id(job_id);


        String fprBODY = objectMapper.writeValueAsString(fpr);
        Response response = RestAssured.given().
                header("Accept", "application/json, text/plain, */*").
                header("Content-Type", "application/json").
                body(fprBODY).
                when().
                post("/ingest/fpr");

        Assert.assertEquals(201, response.statusCode());


    }

    @And("^check result access for guid \"([^\"]*)\" and job \"([^\"]*)\"$")
    public void getResultAccess(String guid, String job_id)
    {
        RestAssured.baseURI = "http://beta-rs-access-api-nlb-7cfa543779a6b84e.elb.eu-north-1.amazonaws.com:8080";
        Response response = RestAssured.given().
                header("Accept", "application/vnd.apica-result-fpr-complete.app-v1.0+json").
                header("Content-Type", "application/json").
                when().get("/results/"+guid+"/result/"+job_id);

        Assert.assertEquals(200, response.statusCode());
    }
}
