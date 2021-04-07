<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>

   <h2>Вход в аккаунт</h2>

<#--   ${message}-->

   <#if message??>${message}</#if>

   <#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
       <div class="alert alert-danger" role="alert">
          ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
       </div>
   </#if>

   <@l.login "/login" false/>

   <br>



</@c.page>
