package de.uni_hamburg.traces.lexicon.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * Result
 */
@javax.annotation.Generated(value = "class io.wagger.api.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-21T15:37:30.051+01:00")
public class Result   {
  private String query = null;

  private String fidael = null;

  private String transliteration = null;

  public Result query(String query) {
    this.query = query;
    return this;
  }

   /**
   * Get query
   * @return query
  **/
  @ApiModelProperty(example = "በስመ፡", value = "")
  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public Result fidael(String fidael) {
    this.fidael = fidael;
    return this;
  }

   /**
   * Get fidael
   * @return fidael
  **/
  @ApiModelProperty(example = "በስመ፡", value = "")
  public String getFidael() {
    return fidael;
  }

  public void setFidael(String fidael) {
    this.fidael = fidael;
  }

  public Result transliteration(String transliteration) {
    this.transliteration = transliteration;
    return this;
  }

   /**
   * Get transliteration
   * @return transliteration
  **/
  @ApiModelProperty(example = "ba-sǝma", value = "")
  public String getTransliteration() {
    return transliteration;
  }

  public void setTransliteration(String transliteration) {
    this.transliteration = transliteration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Result result = (Result) o;
    return Objects.equals(this.query, result.query) &&
        Objects.equals(this.fidael, result.fidael) &&
        Objects.equals(this.transliteration, result.transliteration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(query, fidael, transliteration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Result {\n");
    
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    fidael: ").append(toIndentedString(fidael)).append("\n");
    sb.append("    transliteration: ").append(toIndentedString(transliteration)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

