package com.maxc.rest.common;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.type.TypeReference;

/**
 * @ClassName: ParseJSON
 * @Description: 解析
 * @author ant_shake_tree
 */
public class ParseJSON {
	private static ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 *             Title: parseClusterConfigure Description: parse
	 *             ClusterConfigure
	 * 
	 * @param config
	 *            string
	 * @return List<ParseJSON>
	 * @throws
	 */
	public static String toJson(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T fromJson(String json, Class<T> classOfT) {
		try {
			return objectMapper.readValue(json, classOfT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T fromJson(String json, TypeReference<T> classOfT) {
		try {
			return objectMapper.readValue(json, classOfT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ObjectMapper getJson() {
		return objectMapper;
	}

	public static <T> T convertObjectToDomain(Object object,
			TypeReference<T> type) {
		return ParseJSON.getJson().convertValue(object, type);
	}

	public static <T> T convertObjectToDomain(Object object, Class<T> class1) {
		return ParseJSON.getJson().convertValue(object, class1);
	}
//	public static void main(String[] args) {
//		objectMapper.
//	}
	
	public static class DateTypeSerializer extends JsonSerializer<Date> {

		@Override
		public void serialize(Date value, JsonGenerator jgen,
				SerializerProvider provider) throws IOException,
				JsonProcessingException {
			jgen.writeString(Constants.DATE_FORMAT_HOURE_MINUTE_SENCOND_FORMAT.format(value));
		}

	}
	public static class DateTypeJsonDeserializer extends JsonDeserializer<Date> {

		@Override
		public Date deserialize(JsonParser jp, DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			String text = jp.getText();
			try {
				return Constants.DATE_FORMAT_HOURE_MINUTE_SENCOND_FORMAT.parse(text);
			} catch (ParseException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	
}
