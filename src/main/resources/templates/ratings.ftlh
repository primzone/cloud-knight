<#import "parts/common.ftlh" as c>


<@c.page>

    <h2> Рейтинги </h2>

<#--    <#list knights as knight>-->
<#--        <div>-->
<#--            &lt;#&ndash;            <b>${knight.id}</b><br>&ndash;&gt;-->
<#--            <span><b>Имя: </b>${knight.name}</span>-->
<#--            <span><b>Уровень: </b>${knight.level}</span>-->
<#--            <span><b>Пользователь: </b>${knight.owner.username}</span>-->
<#--            <span><b>Монстров убито: </b>${knight.killedMonsters}</span><br>-->
<#--            <span> Здоровье: ${knight.hp}</span>-->
<#--            <span> Сила: ${knight.str}</span>-->
<#--            <span> Защита: ${knight.def}</span>-->

<#--        </div>-->
<#--        <br><br>-->
<#--    </#list>-->



    <table class="table caption-top">

        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Пользователь</th>
            <th scope="col">Убито монстров</th>
            <th scope="col">Имя</th>
            <th scope="col">Уровень</th>
            <th scope="col">Здоровье</th>
            <th scope="col">Атака</th>
            <th scope="col">Защита</th>
        </tr>
        </thead>
        <tbody>
        <#list knights as knight>
            <tr>
                <th scope="row">${knight?counter}</th>
                <td>${knight.owner.username}</td>
                <td><b>${knight.killedMonsters}</b></td>
                <td>${knight.name}</td>
                <td>${knight.level}</td>
                <td>${knight.hp}</td>
                <td>${knight.str}</td>
                <td>${knight.def}</td>
            </tr>
        </#list>
        </tbody>
    </table>




</@c.page>
