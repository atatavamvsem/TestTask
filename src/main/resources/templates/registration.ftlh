<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<@c.page>

<h5 class="mb-1">Add new user</h5>
${message?ifExists}

 <form action="/registration" method="post">
     <div class="form-group row">
         <label class="col-sm-2 col-form-label">User Name :</label>
         <div class="col-sm-3">
             <input type="text" name="username"
                    class="form-control ${(usernameError??)?string('is-invalid', '')}"
                    placeholder="User name"/>
              <#if usernameError??>
                <div class="invalid-feedback" >
                    ${usernameError}
                </div>
              </#if>
         </div>
     </div>

     <div class="form-group row">
         <label class="col-sm-2 col-form-label">Password:</label>
         <div class="col-sm-3">

             <input type="password" name="password"
                    class="form-control ${(passwordError??)?string('is-invalid', '')}" placeholder="Password"/>
            <#if passwordError??>
                <div class="invalid-feedback">
                    ${passwordError}
                </div>
            </#if>
         </div>
     </div>

     <div class="form-group row">
         <label class="col-sm-2 col-form-label">Last name:</label>
         <div class="col-sm-3">
             <input type="lastname" name="lastname"
                    class="form-control ${(lastnameError??)?string('is-invalid', '')}" placeholder="lastname"/>
              <#if lastnameError??>
                <div class="invalid-feedback" >
                    ${lastnameError}
                </div>
              </#if>
         </div>
     </div>
     <div class="form-group row">
         <label class="col-sm-2 col-form-label">First name:</label>
         <div class="col-sm-3">
             <input type="firstname" name="firstname"
                    class="form-control ${(firstnameError??)?string('is-invalid', '')}" placeholder="firstname"/>
              <#if firstnameError??>
                <div class="invalid-feedback" >
                    ${firstnameError}
                </div>
              </#if>
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