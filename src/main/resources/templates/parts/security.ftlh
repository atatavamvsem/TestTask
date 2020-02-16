<#assign
    know = Session.SPRING_SECURITY_CONTEXT??
>
<#if know>
    <#assign
        userAct = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = userAct.getUsername()
        isAdmin = userAct.isAdmin()
    >
<#else>
    <#assign
        name = "unknown"
        isAdmin = false
    >
</#if>