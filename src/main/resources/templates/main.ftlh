<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<@c.page>
    <#if isAdmin>
        <a href="/registration">Add new user</a>
    </#if>
    <h5>List users</h5>

<table   class="table table-striped">
    <thead>
    <tr>
        <th>Name</th>
        <th>Last Name</th>
        <th>First Name</th>
        <th>Status</th>
        <th>Edit</th>
    </tr>
    </thead>
    <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td>${user.lastname}</td>
            <td>${user.firstname}</td>
            <td><#list user.roles as role>${role}</#list></td>
            <td><a href="/user/${user.id}">edit</a></td>
        </tr>
    </#list>
</table>
</@c.page>