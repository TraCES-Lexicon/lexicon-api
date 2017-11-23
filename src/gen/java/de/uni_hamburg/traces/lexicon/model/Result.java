package de.uni_hamburg.traces.lexicon.model;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModelProperty;

/**
 * Result
 */
@XmlRootElement
public class Result {
	private String query = null;

	private String fidal = null;

	private String transliteration = null;

	/**
	 * // TODO Add description
	 * 
	 * @param query
	 * @return
	 */
	public Result query(String query) {
		this.query = query;
		return this;
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

	/**
	 * // TODO Add description
	 * 
	 * @param query
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * // TODO Add description
	 * 
	 * @param fidal
	 * @return
	 */
	public Result fidal(String fidal) {
		this.fidal = fidal;
		return this;
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

	/**
	 * // TODO Add description
	 * 
	 * @param fidal
	 */
	public void setFidal(String fidal) {
		this.fidal = fidal;
	}

	/**
	 * // TODO Add description
	 * 
	 * @param transliteration
	 * @return
	 */
	public Result transliteration(String transliteration) {
		this.transliteration = transliteration;
		return this;
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

	/**
	 * // TODO Add description
	 * 
	 * @param transliteration
	 */
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
