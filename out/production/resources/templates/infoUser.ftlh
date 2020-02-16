<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#include "parts/security.ftlh">
<@c.page>
    <div>User Info</div>
<form action="/user" method="post">
    <table   class="table table-striped">
    <thead>
    <tr>
        <th>Name</th>
        <th>Last Name</th>
        <th>First Name</th>
        <th>Date created</th>
        <th>Role</th>
        <th>Status</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tr>
        <td>${user.username}</td>
        <td>${user.firstname}</td>
        <td>${user.lastname}</td>
        <td>${user.created}</td>
        <td><#list user.roles as role>${role}</#list></td>
        <td>${user.status?c}</td>
        <td> <#if isAdmin><a href="/user/${user.id}/edit">edit</a></#if></td>
    </tr>

    <input type="hidden" value="${user.id}" name="userId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    </table>
</form>
</@c.page>