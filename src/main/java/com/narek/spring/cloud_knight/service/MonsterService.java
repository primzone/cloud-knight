package com.narek.spring.cloud_knight.service;

import com.narek.spring.cloud_knight.entity.Monster;
import com.narek.spring.cloud_knight.entity.User;
import com.narek.spring.cloud_knight.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MonsterService {

    @Autowired
    MonsterRepository monsterRepository;




    public void createNewMonsterForUser(User user){

        Optional<Monster> optionalMonster = monsterRepository.findByOwner(user);
        //если монстр у юзера есть, то удаляем и создаем нового с начальными данными
        optionalMonster.ifPresent(monster -> monsterRepository.delete(monster));


        Monster monster = new Monster(20, 2, 500, user);
        monsterRepository.save(monster);


    }

    public void improveMonster(Monster monster) {
        monster.setHp(monster.getHp()*1.07);
        monster.setStr(monster.getStr()*1.07);
        monster.setDef(monster.getDef()*1.07);

        monsterRepository.save(monster);
    }

    public void resetMonster(Monster monster) {
        monster.setHp(500);
        monster.setStr(20);
        monster.setDef(2);

        monsterRepository.save(monster);
    }


}
