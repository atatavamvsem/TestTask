<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<#import "parts/pager.ftlh" as p>
<@c.page>
    <#if isAdmin>
        <a href="/registration">Add new user</a>
    </#if>
    <h5>List users</h5>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filterUser" class="form-control" value="${filterUser?ifExists}" placeholder="Search by username">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>
<@p.pager url page/>
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
    <#list page.content as user>
        <tr>
            <td>${user.username}</td>
            <td>${user.lastname}</td>
            <td>${user.firstname}</td>
            <td><#list user.roles as role>${role}</#list></td>
            <td><a href="/user/${user.id}">edit</a></td>
        </tr>
    </#list>
</table>
<@p.pager url page/>
</@c.page>