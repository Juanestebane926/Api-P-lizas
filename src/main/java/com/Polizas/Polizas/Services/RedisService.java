package com.Polizas.Polizas.Services;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RedisService {
    String host = "redis-16928.c114.us-east-1-4.ec2.redns.redis-cloud.com";
    int port = 16928;
    String password = "EeiX8YlyA7LAx6h3RxD7ZCKVPShktB3k";
    int database = 0;
    private final Jedis jedis;

    public RedisService() {
        jedis = new Jedis(host, port);
        jedis.auth(password);
        jedis.select(database);
    }

    public void save(Long id, double valor) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String fechaHoraActualStr = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Guardar la fecha y hora actual junto con el valor en Redis
        jedis.rpush(String.valueOf(id), fechaHoraActualStr, String.valueOf(valor));

        // Establecer expiración en 20 minutos para la clave
        jedis.expire(String.valueOf(id), 20 * 60);
    }

    public List<String> getData(Long id) {
        return jedis.lrange(String.valueOf(id), 0, -1);
    }



}