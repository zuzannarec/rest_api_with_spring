package rest.java.restApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class UserList {
    @JsonProperty("userList")
    @JacksonXmlProperty(localName = "user")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<User> users;


    public UserList(){
    }

    public UserList(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }


}
