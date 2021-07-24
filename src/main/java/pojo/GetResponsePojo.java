package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetResponsePojo {
    @JsonProperty("cod")
    private String cod;

    @JsonProperty("message")
    private String message;

    @JsonProperty("cnt")
    private Integer cnt;

//    @JsonProperty("list")
//    List<city> fulfillmentList;


}
