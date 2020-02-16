<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <div>User Edit</div>
<form action="/user" method="post">
    <label class="col-sm-2 col-form-label">User Name :</label>
    <div class="col-sm-3">
        <input type="text" name="username" class="form-control" placeholder="User name" value="${user.username}"/>
    </div>
    <label class="col-sm-2 col-form-label">Password :</label>
    <div class="col-sm-3">
        <input type="text" name="password" class="form-control" placeholder="password" value="${user.password}"/>
    </div>

    <label class="col-sm-2 col-form-label">User Role :</label>
    <div class="col-sm-10">
        <select class="custom-select col-md-2" name="userRole">
            <#list roles! as role>
                <option value="${role}">${role}</option>
            </#list>
        </select>
    </div>

    <label class="col-sm-2 col-form-label">First Name :</label>
    <div class="col-sm-3">
        <input type="text" name="firstname" class="form-control" placeholder="User name" value="${user.firstname}"/>
    </div>
    <label class="col-sm-2 col-form-label">Last Name :</label>
    <div class="col-sm-3">
        <input type="text" name="lastname" class="form-control" placeholder="User name" value="${user.lastname}"/>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Status:</label>
        <div class="col-sm-3">
            <input type="checkbox" name="status" class="form-control" <#if (user.status)> checked="checked"</#if> />
        </div>
    </div>



    <input type="hidden" value="${user.id}" name="userId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button class="btn btn-primary" type="submit">Save</button>
</form>
</@c.page>