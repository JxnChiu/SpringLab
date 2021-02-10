package com.jason.utils;

import java.io.InputStream;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class JsonUtils {
	private final static Logger logger = LogManager.getLogger();

	public static String toJsonString(Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Throwable t) {

			logger.error("Cannot write {} as JSON string : [{}]", obj, t);
		}
		return null;
	}

	public static <T> T toJson(String inJson, Class<T> type) {
		T res = null;

		try {
			res = new ObjectMapper().readValue(inJson, type);
		} catch (Throwable t) {
			// logger.error("Cannot parse json string [{}]", inJson, t);
			logger.error("Cannot parse json string [{}] {}", inJson, t.getMessage(), t);
		}

		return res;
	}

	public static <T> List<T> toJsonList(String inJson, Class<T> type) throws Throwable {
		List<T> res = null;

		try {
			ObjectMapper mapper = new ObjectMapper();
			CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class, type);
			res = mapper.readValue(inJson, javaType);
		} catch (Throwable t) {
			logger.error("Cannot parse json string [{}] {}", inJson, t.getMessage(), t);
			throw t;
		}

		return res;
	}

	public static <T> T toJsonThrowsAll(String inJson, Class<T> type) throws Throwable {
		return new ObjectMapper().readValue(inJson, type);
	}

	public static <T> T toJson(InputStream inJson, Class<T> type) throws Throwable {
		T res = null;

		try {
			res = new ObjectMapper().readValue(inJson, type);
		} catch (Throwable t) {
			// logger.error("Cannot parse json string [{}]", inJson, t);
			logger.error("Cannot parse json InputStream: {}", t.getMessage());
			throw t;
		}

		return res;
	}

	public static <T> List<T> toJsonList(InputStream inJson, Class<T> type) throws Throwable {
		List<T> res = null;

		try {
			ObjectMapper mapper = new ObjectMapper();
			CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class, type);
			res = mapper.readValue(inJson, javaType);
		} catch (Throwable t) {
			// logger.error("Cannot parse json string [{}]", inJson, t);
			logger.error("Cannot parse json InputStream: {}", t.getMessage());
			throw t;
		}

		return res;
	}
}
