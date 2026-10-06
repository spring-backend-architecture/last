@import java.util.Map
@import dev.dmitriirussu.petclinic.web.presentation.command.form.OwnerForm

@param OwnerForm form
@param Map<String, String> errors


<div class="form-group has-feedback">

    <div class="form-group">
        <label class="col-sm-2 control-label">First Name</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="firstName" value="${form.getFirstName()}"/>
            @if(errors.containsKey("firstName"))
                <span class="text-danger">${errors.get("firstName")}</span>
            @endif
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">Last Name</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="lastName" value="${form.getLastName()}"/>
            @if(errors.containsKey("lastName"))
                <span class="text-danger">${errors.get("lastName")}</span>
            @endif
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">Address</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="street" value="${form.getStreet()}"/>
            @if(errors.containsKey("street"))
                <span class="text-danger">${errors.get("street")}</span>
            @endif
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">City</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="city" value="${form.getCity()}"/>
            @if(errors.containsKey("city"))
                <span class="text-danger">${errors.get("city")}</span>
            @endif
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">Telephone</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="telephone" value="${form.getTelephone()}"/>
            @if(errors.containsKey("telephone"))
                <span class="text-danger">${errors.get("telephone")}</span>
            @endif
        </div>
    </div>

</div>