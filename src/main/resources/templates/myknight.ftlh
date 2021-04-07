<#import "parts/common.ftlh" as c>


<@c.page>
    <h2>Мой рыцарь</h2>



    <#if notExist??>

        <div class="alert alert-warning" role="alert">
            ${notExist}
        </div>

    <#else >


      <#include "parts/knight.ftlh">


        <form method="post" action="deletemyknight">

            <input type="hidden" name="knight_id" value="${knight.id}">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit" class="btn btn-primary">Удалить</button>

        </form>


    </#if>




</@c.page>
