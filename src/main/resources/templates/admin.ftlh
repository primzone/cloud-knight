<#import "parts/common.ftlh" as c>


<@c.page>

    <h2> Admin Page</h2>

    <div class="container">
        <div class="row align-items-start">
            <div class="col">
                <form method="post">

                    <input  type="hidden" name="deleteAllKnights" value="delete">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" class="btn btn-primary">Удалить всех рыцарей</button>

                </form>
            </div>
            <div class="col">
                <form method="post" action="/showAllKnights">

                    <input  type="hidden" name="showAll" value="show">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" class="btn btn-primary">Показать всех рыцарей</button>

                </form>
            </div>
            <div class="col">
                <div class="col">
                    <form method="get" action="/createKnight">

<#--                        <input  type="hidden" name="createKnight">-->
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button type="submit" class="btn btn-primary">Создать рыцаря</button>

                    </form>
                </div>
            </div>
        </div>

        <div class="row align-items-center">
            <div class="col">
                <form method="get" action="/checkWeather">

                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" class="btn btn-primary">Узнать погоду</button>

                </form>
            </div>
            <div class="col">
                <form method="get" action="/user">

                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" class="btn btn-primary">Список пользователей</button>

                </form>
            </div>
            <div class="col">
                One of three columns
            </div>
        </div>


    </div>










</@c.page>
