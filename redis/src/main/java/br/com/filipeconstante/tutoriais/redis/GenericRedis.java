package br.com.filipeconstante.tutoriais.redis;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

import redis.clients.jedis.BinaryJedis;

public class GenericRedis {

	private static final String HOST = "127.0.0.1";
	private static final int PORT = 6379;
	private static BinaryJedis jedis;

	private GenericRedis() {
	}
	
	public static Object get(String tag) {
		return GenericRedis.deserialize(getJedis().get(tag.getBytes()));
	}
	
	public static void set(String tag, Object obj) {
		getJedis().set(tag.getBytes(), GenericRedis.serialize((Serializable) obj));
	}

	public static byte[] serialize(Serializable obj) {
	    return SerializationUtils.serialize(obj);
	}

	public static Object deserialize(byte[] bytes) {
	    return SerializationUtils.deserialize(bytes);
	}
	
	public static synchronized BinaryJedis getJedis() {
		if (jedis == null) {
	        jedis = new BinaryJedis(HOST,PORT);
	    }
	    return jedis;
	}

}
