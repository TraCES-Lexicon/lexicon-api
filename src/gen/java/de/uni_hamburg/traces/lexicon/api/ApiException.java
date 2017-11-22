package de.uni_hamburg.traces.lexicon.api;

@javax.annotation.Generated(value = "class io.wagger.api.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-21T15:37:30.051+01:00")
public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
