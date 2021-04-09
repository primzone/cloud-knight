<#import "parts/common.ftlh" as c>


<@c.page>

    <h2> Прокачка персонажа</h2>



    <#if notExist??>
        <div class="alert alert-warning" role="alert">
            ${notExist}
        </div>
    <#else >

        <div class="row">
            <div class="col-sm-4">
                <#include "parts/knight.ftlh">
            </div>
            <div class="col-sm-4">
                <form method="post">


                    <div class="mb-3">
                        <label for="exampleInput1" class="form-label"><h5>В какой город отправиться рыцарь для прокачки?</h5></label>
                        <input type="text" name="trainCity" class="form-control ${(trainCityError??)?string('is-invalid','')}"
                                id="exampleInput1">
                        <#if trainCityError??>
                            <div id="exampleInputEmail1Feedback" class="invalid-feedback">
                                ${trainCityError}
                            </div>
                        </#if>
                    </div>

                    <input type="hidden" name="knight_id" value="${knight.id}">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" class="btn btn-primary">Прокачать</button>

                </form>

                <br>
                <#if traininfo??>
                    <div class="alert alert-success" role="alert">


                    <div class="container text-center">
                        <h5>${traininfo}</h5>
                        <br>
                        <div class="row">
                            <div class="col-sm">
                                <h6>Здоровье</h6>
                            </div>
                            <div class="col-sm">
                                <h6>Сила атаки</h6>
                            </div>
                            <div class="col-sm">
                                <h6>Защита</h6>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm">
                                <h6>▲${addHp}</h6>
                            </div>
                            <div class="col-sm">

                                <h6>▲${addStr}</h6>
                            </div>
                            <div class="col-sm">
                                <h6>▲${addDef}</h6>
                            </div>
                        </div>
                    </div>
                    </div>





                </#if>




                <#if cityIsUsed??>
                    <div class="alert alert-warning" role="alert">
                        ${cityIsUsed}
                    </div>
                </#if>


            </div>


            <div class="col-sm-4">



                <ul class="list-unstyled">
                    <li class="media">
                        <div class="media-body">
                            <h5 class="mt-0 mb-1">Рыцарь прошел тренировку в городах:</h5>
                            <#list usedCities as ucity>
                                <ul>
                                    <li>${ucity}</li>
                                </ul>
                            </#list>
                        </div>

                    </li>
                </ul>




            </div>
        </div>




    </#if>



</@c.page>
