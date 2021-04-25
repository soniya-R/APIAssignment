package org.automation.test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.automation.readPropertyFile.ReadPropertiesFile;
import org.automation.utils.RequestType;
import org.automation.utils.URLGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * DELETE request and asserting status code and fields in body
 */

public class TestDeleteRequest {

    RequestType restUtils = new RequestType();
    URLGenerator urlGenerator = new URLGenerator();
    Properties prop;

    @BeforeTest
    public void setBaseUrl() throws IOException {
        prop = ReadPropertiesFile.loadProperty("config");
    }

    @Test
    public void deleteEmployee() throws IOException {
        String url = prop.getProperty("baseURL");
        String endPoint = urlGenerator.deleteEndpoint(url);
        Response response = restUtils.delete(endPoint);
        int statusCode = response.getStatusCode();
        JsonPath jsonPath = new JsonPath(response.asString());
        String message = jsonPath.getString("message");
        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(message,"Successfully! Record has been deleted");
    }
}
