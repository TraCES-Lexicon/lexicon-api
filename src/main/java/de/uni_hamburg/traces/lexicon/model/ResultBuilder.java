/**
 * 
 */
package de.uni_hamburg.traces.lexicon.model;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class ResultBuilder {
	
	private final String uuid;
	private String query;
	private String fidal;
	private String transliteration;

	public ResultBuilder(String uuid) {
		this.uuid = uuid;
	}
	
	public ResultBuilder query(String query) {
		this.query = query;
		return this;
	}
	
	public ResultBuilder fidal(String fidal) {
		this.fidal = fidal;
		return this;
	}
	
	public ResultBuilder transliteration(String transliteration) {
		this.transliteration = transliteration;
		return this;
	}
	
	public Result build() {
		Result result = new Result();
		result.setUuid(uuid);
		result.setQuery(query);
		result.setFidal(fidal);
		result.setTransliteration(transliteration);
		return result;
	}

}
