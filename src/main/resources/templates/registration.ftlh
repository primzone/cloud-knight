<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>

   <h2>Регистрация</h2>


   <@l.login "/registration" true/>
   <#if message??>
      <div class="col-sm-4">
         <div class="alert alert-warning alert-dismissible fade show" role="alert">
            <strong>${message}</strong> Выберите другое имя
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Закрыть"></button>
         </div>
      </div>

   </#if>

</@c.page>
