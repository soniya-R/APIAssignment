package org.automation.utils;

public class URLGenerator {

    /**
     * generating the url with respective endpoints
     */

    public String getAllEmployees = "/api/v1/employees";
    public String getSingleEmployee ="/api/v1/employee/1";
    public String deleteEmployee ="/public/api/v1/delete/2";


    public String getUrl(String baseURL)
    {
        return (baseURL+getAllEmployees);
    }

    public String getSingleEmployee(String baseURL)
    {
        return (baseURL+getSingleEmployee);
    }

    public String deleteEndpoint(String baseURL)
    {
        return (baseURL+deleteEmployee);
    }
}
