package com.narek.spring.cloud_knight.controller;
import com.narek.spring.cloud_knight.entity.Knight;
import com.narek.spring.cloud_knight.entity.Monster;
import com.narek.spring.cloud_knight.entity.User;
import com.narek.spring.cloud_knight.repository.KnightRepository;
import com.narek.spring.cloud_knight.repository.UserRepository;
import com.narek.spring.cloud_knight.service.KnightService;
import com.narek.spring.cloud_knight.service.MonsterService;
import com.narek.spring.cloud_knight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
public class MyController {

    @Autowired
    private KnightRepository knightRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MonsterService monsterService;
    @Autowired
    private KnightService knightService;
    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public String showHomepage(){
        return "homepage";
    }

    @GetMapping("/knights")
    public String showKnights(Model model){

        Iterable<Knight> allKnights =  knightRepository.findAll();
        model.addAttribute("knights", allKnights);
        return "knights";
    }


    @GetMapping("/admin")
    public String showAdminPage(){
        return "admin";
    }


    @PostMapping("/admin")
    public String deleteAllKnights(@RequestParam String deleteAllKnights){

        if (deleteAllKnights.equals("delete")){
            //knightRepository.deleteAll();
            knightService.deleteAll();

        }
        return "admin";
    }

    @PostMapping("/showAllKnights")
    public String showAllKnights(@RequestParam String showAll, Map<String, Object> model){

        if (showAll != null && showAll.equals("show")){
            return "redirect:/knights";
        }

        return "redirect:/knights";
    }



    @GetMapping("/createKnight")
    public String showCreateKnight(){
        return "createknight";
    }


    @PostMapping("/createKnight")
    public String createKnight(@AuthenticationPrincipal User user, // получение текущего пользователя в качестве параметра
                               @Valid Knight knight,
                               BindingResult bindingResult,//список аргументов и сообщения ошибок валидации, должен идти перет model
                               Model model){


        //если ошибки из формы, то дальше не идем, а остаемсяя на странице
        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("knights", knight);
            return "createKnight";

        }

        Optional<Knight> optionalKnight = knightService.findByOwner(user);

        if (optionalKnight.isPresent()){
            model.addAttribute("notExist", "У вас уже создан рыцарь");
            return "myknight";
        }

        //если у юзера еще нет рыцаря то создаем, иначе отправляем сообщение, что он есть

        //получаемм данные о погоде
        Map<String, Double> weatherMap = ControllerUtils.checkInfoOpenweathermap(
                knight.getFromCity().replaceAll("\\d", "").toLowerCase());//убираем цифры из за api
        //если данные есть, то создаем рыцаря
        if (!weatherMap.isEmpty()){
            //Knight knight = new Knight(name,user,fromCity);
            knight.setOwner(user);

            knight.setHp(weatherMap.get("pressure"));
            knight.setDef(Math.abs(weatherMap.get("temp")));
            knight.setStr(weatherMap.get("humidity"));
            knight.setLevel(1);

            user.getUsedCities().add(knight.getFromCity().toLowerCase());

            //knightRepository.save(knight);
            knightService.save(knight);
            //userRepository.save(user);
            userService.save(user);


            model.addAttribute("knight", knight);

            //записываем в модель из репозитория и  отправляем в выдачу
        }
        else {
            model.addAttribute("message", "Введеный город не найден, попробуйте другой");
            return "createKnight";
        }



        System.out.println(user.getUsedCities());
        return "myknight";

    }


    @GetMapping("levelup")
    public String showLevelUp(@AuthenticationPrincipal User user, Model model){

        Optional<Knight> optionalKnight = knightService.findByOwner(user);



        if (optionalKnight.isPresent()){
            model.addAttribute("knight", optionalKnight.get());
        }
        else{
            model.addAttribute("notExist", "У вас пока нет рыцаря");
        }
        model.addAttribute("usedCities", user.getUsedCities());
        return "levelup";
    }



    @PostMapping("levelup")
    public String knightLevelUp(@AuthenticationPrincipal User user,
                                @RequestParam String trainCity,
                                @RequestParam long knight_id,
                                Model model){

        //проверка на действубщего рыцаря
        Optional<Knight> optionalKnight = knightService.findById(knight_id);


        if (!optionalKnight.isPresent()){
            model.addAttribute("notExist", "У вас пока нет рыцаря");
            return "levelup";
        }



        Knight knight = optionalKnight.get();
        //проверка длины введеного города
        if (trainCity.length() < 3){
            model.addAttribute("trainCityError", "Имя города должно состоять минимум из 3 букв");
            model.addAttribute("knight", knight);
        } //проверка на повторно введеные города
        else  if (user.getUsedCities().contains(trainCity.toLowerCase())){
            model.addAttribute("cityIsUsed","Вы уже тренировались в этом городе");
            model.addAttribute("knight", knight);
        }
        else {
            //получаем данные о погоде в городе
            Map<String, Double> weatherMap = ControllerUtils.checkInfoOpenweathermap(trainCity.replaceAll("\\d", ""));
            //если такой город есть, то добавляем все данные и сохраняем, иначе ошибка
            if (!weatherMap.isEmpty()){

                knight.setHp(knight.getHp() + (weatherMap.get("pressure") / 10));
                knight.setDef(knight.getDef() + (Math.abs(weatherMap.get("temp")) / 10));
                knight.setStr(knight.getStr() + (weatherMap.get("humidity") / 10));
                knight.setLevel(knight.getLevel() + 1);
                user.getUsedCities().add(trainCity.toLowerCase());


//                        knightRepository.save(knight);
//                        userRepository.save(user);
                knightService.save(knight);
                userService.save(user);

                model.addAttribute("traininfo", "Тренировка прошла успешно");
                model.addAttribute("addStr", (weatherMap.get("humidity") / 10));
                model.addAttribute("addDef", (Math.abs(weatherMap.get("temp")) / 10));
                model.addAttribute("addHp", (weatherMap.get("pressure") / 10));
                //записываем в модель из репозитория и  отправляем в выдачу
            }
            else model.addAttribute("cityIsUsed","Информация по городу не найдена");
            model.addAttribute("knight", knight);

        }

        model.addAttribute("usedCities", user.getUsedCities());

        System.out.println(user.getUsedCities());

        return "levelup";
    }


    @GetMapping("myknight")
    public String showMyKnight(@AuthenticationPrincipal User user, Model model){

        Optional<Knight> optionalKnight = knightService.findByOwner(user);

        if (optionalKnight.isPresent()){
            model.addAttribute("knight", optionalKnight.get());
        }
        else{
            model.addAttribute("notExist", "У вас пока нет рыцаря");
        }

        return "myknight";
    }

    @GetMapping("fight")
    public String showFight(@AuthenticationPrincipal User user, Model model){

        Optional<Knight> optionalKnight = knightService.findByOwner(user);

        if (optionalKnight.isPresent()){
            model.addAttribute("knight", optionalKnight.get());
            Monster monster = user.getUser_monster();
            model.addAttribute("monster", monster);

        }
        else{
            model.addAttribute("notExist", "У вас пока нет рыцаря");
        }

        return "fight";

    }


    @PostMapping("fight")
    public String knightAndMosterFight(@AuthenticationPrincipal User user, Model model){

        Monster monster = user.getUser_monster();
        Optional<Knight> optionalKnight = knightService.findByOwner(user);

        if (optionalKnight.isPresent()){
            Knight knight = optionalKnight.get();

            //получаем данные о результатах боя
            Map<String, String> mapFightCheck = ControllerUtils.getKnightAndMosterFightCheck(monster, knight);
            //если рыцарь победил, усиливаем монстра
            if (mapFightCheck.get("winner").equals("knight")){

                knight.setKilledMonsters(knight.getKilledMonsters()+1);
                monsterService.improveMonster(monster);
            }
            model.mergeAttributes(mapFightCheck);
            model.addAttribute("knight", knight);
            model.addAttribute("monster", monster);

        }
        else {
            model.addAttribute("notExist", "У вас пока нет рыцаря");
        }


        return "fight";
    }


    @GetMapping("ratings")
    public String showRatings(Model model){


        Iterable<Knight> allKnights =  knightService.findAll();

        List<Knight> list = new ArrayList<>();
        for (Knight k: allKnights){
            list.add(k);
        }

        //сортировка по количеству убитых монстров
        list.sort((o1, o2) -> o2.getKilledMonsters() - o1.getKilledMonsters());


        model.addAttribute("knights", list);

        return "ratings";
    }


    @PostMapping("deletemyknight")
    public String deleteMyKnight(@AuthenticationPrincipal User user, @RequestParam long knight_id, Model model){

        user.getUsedCities().clear();

        knightService.deleteById(knight_id);
        userService.save(user);
        monsterService.resetMonster(user.getUser_monster());// удаляем текущего монстра и создаем нового


        model.addAttribute("notExist", "Ваш рыцарь удален.");
        return "myknight";
    }





//    @PostMapping("/knights")
//    public String addKnight(@RequestParam String name, @RequestParam int level, Map<String, Object> model){
//        //Сначала сохраняем в БД
//        Knight knight = new Knight(name,level);
//        knightRepository.save(knight);
//
//
//        //записываем в модель из репозитория и  отправляем в выдачу
//        Iterable<Knight> allKnights =  knightRepository.findAll();
//        model.put("knights", allKnights);
//
//
//        return "knights";
//    }


}
