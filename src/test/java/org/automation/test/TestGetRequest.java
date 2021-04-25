package org.automation.test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.automation.readPropertyFile.ReadPropertiesFile;
import org.automation.utils.RequestType;
import org.automation.utils.URLGenerator;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Getting all employees and getting a particular employee detail
 * Asserting the response of single employee
 */

public class TestGetRequest {
    RequestType restUtils = new RequestType();
    URLGenerator urlGenerator = new URLGenerator();
    Properties prop;

    @BeforeTest
    public void setBaseUrl() throws IOException {
        prop = ReadPropertiesFile.loadProperty("config");
    }

    @Test
    public void getAllEmployees() throws IOException {
        String url = prop.getProperty("baseURL");
        String endPoint = urlGenerator.getUrl(url);
        Response response = restUtils.get(endPoint);
        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200);
    }


    @Test
    public void getSingleEmployees() throws IOException {
        String url = prop.getProperty("baseURL");
        String endPoint = urlGenerator.getSingleEmployee(url);
        Response response = restUtils.get(endPoint);
        response.prettyPrint();
        Map<String,String> testValues;
        testValues = ReadingTestDataJson.readJsonFile("getEmployee","expectedData.json");
        String res = response.asString();
        JsonPath jsonPath = new JsonPath(res);
        int empId = jsonPath.getInt("data.id");
        String empName= jsonPath.getString("data.employee_name");
        int empSalary = jsonPath.getInt("data.employee_salary");
        int empAge = jsonPath.getInt("data.employee_age");


        Assert.assertEquals(new Object[]{empId,empName,empSalary,empAge},
                new Object[]{Integer.parseInt(testValues.get("id")),
                             testValues.get("employee_name"),
                             Integer.parseInt(testValues.get("employee_salary")),
                             Integer.parseInt(testValues.get("employee_age"))});


    }

}
