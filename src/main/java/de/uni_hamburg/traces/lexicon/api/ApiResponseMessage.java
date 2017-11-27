package de.uni_hamburg.traces.lexicon.api;

import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApiResponseMessage {
    int code;
    String type;
    String message;

    public ApiResponseMessage(){}

    public ApiResponseMessage(Status status, String message){
    	this.code = status.getStatusCode();
        this.message = status.getReasonPhrase();
        System.out.println(this.code + ": " + this.message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
