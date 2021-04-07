package com.narek.spring.cloud_knight.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.narek.spring.cloud_knight.entity.Knight;
import com.narek.spring.cloud_knight.entity.Monster;
import com.narek.spring.cloud_knight.entity.Weather;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ControllerUtils {


     static Map<String, String> getErrors(BindingResult bindingResult){

        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        );

        return bindingResult.getFieldErrors().stream().collect(collector);
    }


    static Map<String, Double> checkInfoOpenweathermap(String cityName){
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Double> weatherMap = new HashMap<>();

        try {
            Weather value = mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    .readValue(new URL("https://api.openweathermap.org/data/2.5/" +
                            "weather?q=" + cityName + "&appid=7984a23014928462576b56060f5faadb&units=metric&lang=ru"), Weather.class);

            weatherMap = value.getMain();
            //weatherMap.put("cod", value.getCod());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("тоби пизда");
        }



        return weatherMap;
    }


    static void hit(Monster zMonster, Knight zKnight){

         double oneKnightHit = zKnight.getStr() - zMonster.getDef();
         double oneMonstertHit = zMonster.getStr() - zKnight.getDef();

         zMonster.setHp(zMonster.getHp() - oneKnightHit);
         zKnight.setHp(zKnight.getHp() - oneMonstertHit);


    }


    static Map<String, String> getKnightAndMosterFightCheck(Monster monster, Knight knight) {

         Monster zMonster = new Monster();
         zMonster.setDef(monster.getDef());
         zMonster.setHp(monster.getHp());
         zMonster.setStr(monster.getStr());

         Knight zKnight = new Knight();
        zKnight.setDef(knight.getDef());
        zKnight.setHp(knight.getHp());
        zKnight.setStr(knight.getStr());
        int hitCount = 0;
        Map<String, String> map = new HashMap<>();

        if (zKnight.getDef() >= zMonster.getStr() && zMonster.getDef() >= zKnight.getStr()){
            map.put("fightinfo", "у вас у обоих слишком твердая броня, вы не сможешь победить друг друга.");
            map.put("infotype", "warning");
            map.put("winner", "nobody");
        }
        else if (zKnight.getDef() >= zMonster.getStr()){
            map.put("fightinfo", "Ваша броня очень мощная, монстр не нанес вам вреда");
            map.put("infotype", "success");
            map.put("winner", "knight");
        }
        else if (zMonster.getDef() >= zKnight.getStr()){
            map.put("fightinfo", "Броня монстра слишком твердая, вам нужно больше силы атаки");
            map.put("infotype", "danger");
            map.put("winner", "monster");
        }
        else {
            while (zMonster.getHp() >= 0 && zKnight.getHp() >= 0){
                hit(zMonster, zKnight);
                hitCount++;
            }
            if (zMonster.getHp() <= 0) {
                map.put("winner", "knight");
                map.put("fightinfo", "Это была тяжелая битва, вы еле справились");
                map.put("infotype", "primary");
            }
            else{
                map.put("winner", "monster");
                map.put("fightinfo", "Монстр вас чуть не сожрал. Вам нужна прокачка");
                map.put("infotype", "danger");
            }

            map.put("hitCount", String.valueOf(hitCount));

        }




        map.put("knightRemainingHp", String.valueOf((long)zKnight.getHp() <= 0 ? 0 : (long)zKnight.getHp()));
        map.put("MonsterRemainingHp", String.valueOf((long)zMonster.getHp() <= 0 ? 0 : (long)zMonster.getHp()));
        return map;

    }


}
