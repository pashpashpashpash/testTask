package org.example.steps;

import io.restassured.response.Response;
import org.example.api.RestUtil;

import java.util.HashMap;
import java.util.Map;

import static org.example.constant.PathConstants.REGISTER_PATH;
import static org.example.constant.PathConstants.USERS_PATH;
import static org.example.constant.RequestKey.*;

public class ApiSteps {

    private RestUtil restUtil = new RestUtil();

    public Response getAllUsers(String usersPerPage) {
        Map<String, String> params = new HashMap<>();
        params.put(USERS_PER_PAGE_KEY, usersPerPage);
        return restUtil.getWithParams(USERS_PATH, params);
    }


    public Response registerUser(String email, String password) {
        Map<String, String> params = new HashMap<>();
        params.put(EMAIL_KEY, email);
        params.put(PASSWORD_KEY, password);
        return restUtil.postWithParams(REGISTER_PATH, params);
    }

    public Response deleteUser(String userId) {
        Map<String, String> params = new HashMap<>();
        return restUtil.delete(USERS_PATH + "/" + userId);
    }

}
