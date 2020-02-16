<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>

<h5 class="mb-1">Add new user</h5>
${message?ifExists}

 <form action="/registration" method="post">
     <div class="form-group row">
         <label class="col-sm-2 col-form-label">User Name :</label>
         <div class="col-sm-3">
             <input type="text" name="username" class="form-control" placeholder="User name"/>
         </div>
     </div>
     <div class="form-group row">
         <label class="col-sm-2 col-form-label">Password:</label>
         <div class="col-sm-3">
             <input type="password" name="password" class="form-control" placeholder="Password"/>
         </div>
     </div>
     <div class="form-group row">
         <label class="col-sm-2 col-form-label">Last name:</label>
         <div class="col-sm-3">
             <input type="lastname" name="lastname" class="form-control" placeholder="lastname"/>
         </div>
     </div>
     <div class="form-group row">
         <label class="col-sm-2 col-form-label">First name:</label>
         <div class="col-sm-3">
             <input type="firstname" name="firstname" class="form-control" placeholder="firstname"/>
         </div>
     </div>
     <div class="form-group row">
         <label class="col-sm-2 col-form-label">User Role :</label>
         <select class="custom-select col-sm-2" name="userRole">
            <#list roles! as role>
                <option value="${role}">${role}</option>
            </#list>
         </select>
     </div>
     <input type="hidden" name="_csrf" value="${_csrf.token}"/>
     <button class="btn btn-primary" type="submit">Registration</button>

 </form>

</@c.page>