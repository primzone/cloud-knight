<#import "parts/common.ftlh" as c>

<@c.page>

<div class="text-center"><h2> Create your Cloud Knight</h2></div>
<br>

<div class="row">
    <div class="col-sm-2">

    </div>
    <div class="col-sm-3">

        <form method="post">
            <div class="mb-3">

                <label for="exampleInputEmail1" class="form-label">Имя Рыцаря</label>
                <input type="text" name="name" class="form-control ${(nameError??)?string('is-invalid','')}"
                       value="<#if knights??>${knights.name}</#if>" id="exampleInputEmail1" >
                <#if nameError??>
                    <div id="exampleInputEmail1Feedback" class="invalid-feedback">
                        ${nameError}
                    </div>
                </#if>

            </div>
            <#--        <div class="mb-3">-->
            <#--            <label for="exampleInput2" class="form-label">Уровень рыцаря</label>-->
            <#--            <input type="text" name="level" class="form-control" id="exampleInput2">-->
            <#--        </div>-->
            <div class="mb-3">
                <label for="exampleInput1" class="form-label ">Город из которого прибыл рыцарь</label>
                <input type="text" name="fromCity" class="form-control ${(fromCityError??)?string('is-invalid','')}" id="exampleInput1">
                <#if fromCityError??>
                    <div id="exampleInputEmail1Feedback" class="invalid-feedback">
                        ${fromCityError}
                    </div>
                </#if>
            </div>



            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit" class="btn btn-primary">Добавить</button>

        </form>




        <#if message??>
            <br>
            <div class="alert alert-warning" role="alert">
                ${message}
            </div>
        </#if>



    </div>
    <div class="col-sm-1">

    </div>
    <div class="col-sm-4">
        <br>
        <ul class="list-unstyled">
            <li class="media">
                <div class="media-body">
                    <h5 class="mt-0 mb-1">Характеристики рыцаря будут распределены следующим образом</h5>
                    <ul>
                            <li>Температура в городе  - Защита рыцаря</li>
                            <li>Влажность в городе - Атака рыцаря</li>
                            <li>Давление в городе - Здоровье рыцаря</li>

                    </ul>
                </div>
            </li>
        </ul>

    </div>
</div>





</@c.page>
