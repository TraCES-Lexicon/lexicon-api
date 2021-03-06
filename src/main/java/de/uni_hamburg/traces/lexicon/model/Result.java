/*
 * Swagger 2.0 version of TraCES Ge'ez Lexicon API (unstable)
 * An API that allows users to return accumulated results from different resources from their queries. ## **NOTE** SNAPSHOT, Do not implement! ## **NOTE** Will be superseded by https://swaggerhub.com/apis/sdruskat/traces-lexicon-api 
 *
 * OpenAPI spec version: 0.9.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.uni_hamburg.traces.lexicon.model;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Result
 */
@XmlRootElement
public class Result {
	@JsonProperty("query")
	private String query = null;

	@JsonProperty("fidal")
	private String fidal = null;

	@JsonProperty("transliteration")
	private String transliteration = null;
	
	@JsonProperty("uuid")
	private String uuid = null;
	
//	public Result(String uuid) {
//		this.uuid = uuid;
//	}
//	
//	public Result(String uuid, String query, String fidal, String transliteration) {
//		this.uuid = uuid;
//		this.query = query;
//		this.fidal = fidal;
//		this.transliteration = transliteration;
//	}

	/**
	 * @return the uuid
	 */
	public final String getUuid() {
		return uuid;
	}

	/**
 * @param uuid the uuid to set
 */
public final void setUuid(String uuid) {
	this.uuid = uuid;
}

	/**
	 * Get query
	 * 
	 * @return query
	 **/
	@ApiModelProperty(example = "በስመ፡", value = "")
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * Get fidal
	 * 
	 * @return fidal
	 **/
	@ApiModelProperty(example = "በስመ፡", value = "")
	public String getFidal() {
		return fidal;
	}

	public void setFidal(String fidal) {
		this.fidal = fidal;
	}

	/**
	 * Get transliteration
	 * 
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
		return Objects.equals(this.query, result.query) && Objects.equals(this.fidal, result.fidal)
				&& Objects.equals(this.transliteration, result.transliteration);
	}

	@Override
	public int hashCode() {
		return Objects.hash(query, fidal, transliteration);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Result {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    query: ").append(toIndentedString(query)).append("\n");
		sb.append("    fidal: ").append(toIndentedString(fidal)).append("\n");
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
