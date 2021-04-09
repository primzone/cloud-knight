<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">



<@c.page>

<figure class="text-center">
    <h2 class="display-5">Добро пожаловать в мир приключений Cloud Knight</h2>
</figure>



    <br>
    <#if !isAuthorized>
        <h3>Для начала создайте пользователя или авторизуйтесь</h3>
        <#if userCreateMessage??>
            <br>
            <div class="alert alert-success" role="alert">
                ${userCreateMessage}
            </div>
        </#if>
        <button onclick="window.location.href = '/login';" type="submit" class="btn btn-primary">Войти</button>
        <button onclick="window.location.href = '/registration';" type="submit" class="btn btn-primary">Регистрация</button>

    <#else>
          <p>Вы вошли под пользователем <b>${name}</b></p>
        <br>
    </#if>

    <br>

    <h3>Правила игры</h3>


    <ul class="list-unstyled">
        <li class="media">
            <div class="media-body">
                <h5 class="mt-0 mb-1">Создайте персонажа по следующим правилам</h5>


                <ul>
                    <li>Укажите имя</li>
                    <li>Укажите город из которого прибыл рыцарь</li>
                    <li>Характеристики рыцаря будут распределены следующим образом</li>
                    <ul>
                        <li>Температура в городе  - Защита рыцаря</li>
                        <li>Влажность в городе - Атака рыцаря</li>
                        <li>Давление в городе - Здоровье рыцаря</li>
                    </ul>
                    <li>У вас может быть только один рыцарь</li>
                </ul>
            </div>
            <#if isAuthorized>
                <form method="get" action="/createKnight">

                    <#--                        <input  type="hidden" name="createKnight">-->
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" class="btn btn-primary m-3">Создать рыцаря</button>

                </form>

            </#if>
        </li>

        <li class="media my-4">

            <div class="media-body">
                <h5 class="mt-0 mb-1">Сражайтесь с монстрами в подземелье</h5>
                <ul>
                    <li>Каждый монстр увеличивает уровень рыцаря на 1</li>
                    <li>Каждый следующий монстр сильнее на 7%</li>
                    <li>Если монстра победить не удалось, вам необходим прокачка</li>

                </ul>
            </div>
        </li>
        <li class="media">

            <div class="media-body">
                <h5 class="mt-0 mb-1">Прокачка рыцаря</h5>
                <ul>
                    <li>Вы можете улучшить характеристики рыцаря</li>
                    <li>Для этого нужно указать города, в которых тренировался ваш рыцарь</li>
                    <li>Характеристики рыцаря будут улучшены следующим образом</li>
                    <ul>
                        <li>(Температура в городе) / 10  - Защита рыцаря</li>
                        <li>(Влажность в городе) / 10 - Атака рыцаря</li>
                        <li>(Давление в городе) / 10 - Здоровье рыцаря</li>
                    </ul>
                    <li>Один город, можно использовать только один раз</li>

                </ul>
            </div>
        </li>

        <li class="media">

            <div class="media-body">
                <br>
                <h5 class="mt-0 mb-1">Рейтинги</h5>

                <ul>
                    <li>Лучшие рыцари будут на самом верху доски почета</li>



                </ul>

            </div>
        </li>
    </ul>




</@c.page>
