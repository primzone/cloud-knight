<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #F0FFFF">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Cloud Knight</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="/" href="/">Home</a>
                </li>


                <#if isAuthorized>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="/m" href="/myknight">My knight</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="/f" href="/fight">Fight</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="/l" href="/levelup">Level UP</a>
                    </li>
                </#if>

                <li class="nav-item">
                    <a class="nav-link" aria-current="/l" href="/ratings">Ratings</a>
                </li>

<#--                <li class="nav-item">-->
<#--                    <a class="nav-link" aria-current="/r" href="/knights">All Knights</a>-->
<#--                </li>-->

                <#if isAdmin>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="/r" href="/admin">Adminka</a>
                    </li>
                </#if>

            </ul>

            <div class="navbar-text me-3">${name}</div>

            <#if isAuthorized>
                <@l.logout/>
            </#if>

        </div>
    </div>
</nav>