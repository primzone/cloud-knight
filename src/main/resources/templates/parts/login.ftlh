<#macro login path isRegisterForm>



<#--    <form action="${path}" method="post">-->
<#--        <div class="mb-3">-->
<#--            <label class="form-control"> User Name :</label>-->
<#--            <input class="form-control" type="text" name="username">-->
<#--        </div>-->
<#--        <div><label> Password: <input type="password" name="password"/> </label></div>-->
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}">-->
<#--        <div><input type="submit" value="Sign In"/></div>-->
<#--    </form>-->


    <form action="${path}" method="post">
        <div class="mb-3">
            <label for="exampleName" class="form-label">User Name :</label>
            <div class="col-sm-3">
            <input type="text" class="form-control ${(usernameError??)?string('is-invalid','')}"
                   id="exampleName" aria-describedby="emailHelp" name="username">
                <#if usernameError??>
                    <div id="exampleInputEmail1Feedback" class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <div class="col-sm-3">
            <input type="password" class="form-control ${(passwordError??)?string('is-invalid','')}" id="exampleInputPassword1" name="password">
                <#if passwordError??>
                    <div id="exampleInputEmail1Feedback" class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">

        <button type="submit" class="btn btn-primary"><#if isRegisterForm>Создать<#else>Войти</#if></button>
    </form>
    <br>

    <#if !isRegisterForm>
    <button onclick="window.location.href = '/registration';" type="submit" class="btn btn-secondary">Регистрация</button>
    </#if>



</#macro>


<#macro logout>
    <form action="/logout" method="post">

        <button type="submit" class="btn btn-primary">Sign out</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>



</#macro>