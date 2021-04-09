<#import "parts/common.ftlh" as c>


<@c.page>
    <h2>Мой рыцарь</h2>



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
                <form method="post" action="deletemyknight">

                    <input type="hidden" name="knight_id" value="${knight.id}">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" class="btn btn-primary">Удалить</button>

                </form>
            </div>
            <div class="col-sm-4">

            </div>

        </div>






    </#if>




</@c.page>
