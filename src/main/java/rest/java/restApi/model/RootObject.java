package rest.java.restApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RootObject {

    @JsonProperty("RestResponse")
    private RestResponse restResponse;

    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }

    public RestResponse getRestResponse() {

        return restResponse;
    }
}
