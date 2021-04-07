<#import "parts/common.ftlh" as c>


<@c.page>

    <h2> Page of Cloud Knights</h2>



    <#if message??>${message}</#if>


    <#list knights as knight>
        <div>
<#--            <b>${knight.id}</b><br>-->
            <span><b>Имя: </b>${knight.name}</span>
            <span><b>Уровень: </b>${knight.level}</span><br>
            <span> Здоровье: ${knight.hp}</span>
            <span> Сила: ${knight.str}</span>
            <span> Защита: ${knight.def}</span>

        </div>
        <br><br>
    </#list>



</@c.page>
