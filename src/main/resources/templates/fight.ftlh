<#import "parts/common.ftlh" as c>


<@c.page>

    <h2> Охота</h2>

    <#if notExist??>
        <div class="alert alert-warning" role="alert">
            ${notExist}
        </div>
    <#else >

        <div class="row">
            <div class="col-sm-3 mx-auto">
                    <#include "parts/knight.ftlh">
            </div>
            <div class="col-sm-6 text-center">

                <br><br><br>
                <form method="post">
                    <input type="hidden" name="knight_id" value="${knight.id}">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <div class="text-center"><button type="submit" class="btn btn-success btn-lg">       Fight!     </button></div>

                </form>

                <br>

                <#if fightinfo??>
                    <div class="alert alert-${infotype}" role="alert">


                        <div class="container text-center">
                            <h5>${fightinfo}</h5>
                            <br>
                            <div class="row">
                                <div class="col-sm">
                                    <h6>Осталось здоровья</h6>
                                </div>
                                <div class="col-sm">
                                    <h6>Всего ударов</h6>
                                </div>
                                <div class="col-sm">
                                    <h6>Осталось здоровья монстра</h6>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm">
                                    <h6>${knightRemainingHp} <b>/</b> ${knight.hp}</h6>
                                </div>
                                <div class="col-sm">
                                    <h6>${hitCount}</h6>
                                </div>

                                <div class="col-sm">
                                    <h6>${MonsterRemainingHp} <b>/</b> ${monster.hp}</h6>
                                </div>
                            </div>
                        </div>


                    </div>
                </#if>


            </div>


            <div class="col-sm-3 justify-content-center">

                <div class="card" style="width: 18rem;">
                    <img src="https://i.pinimg.com/474x/11/5c/d9/115cd93eff2a626bcde1128b6e748955--monster-games-monster-art.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Имя: Изверг</h5>
                        <h6 class="card-title">Город: Из глубин ада</h6>
                        <p class="card-text">Уродский монстр</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><b>Здоровье: </b>${monster.hp}</li>
                        <li class="list-group-item"><b>Сила атаки: </b>${monster.str}</li>
                        <li class="list-group-item"><b>Защита: </b>${monster.def}</li>
                        <li class="list-group-item"><b>Уровень: </b>${knight.killedMonsters}</li>


                    </ul>

                </div>

            </div>
        </div>




    </#if>




</@c.page>
