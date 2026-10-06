@import java.util.Map
@import dev.dmitriirussu.petclinic.web.presentation.command.form.PetForm

@param String ownerFirstName
@param String ownerLastName
@param java.util.List<String> petTypes
@param PetForm form
@param Map<String, String> errors

<input type="hidden" name="ownerId" value="${form.getOwnerId()}">

<div class="form-group has-feedback">

    <div class="form-group">
        <label class="col-sm-2 control-label">Owner</label>
        <div class="col-sm-10">
            <span>${ownerFirstName} ${ownerLastName}</span>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">Name</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="name" value="${form.getName()}"/>
            @if(errors.containsKey("name"))
                <span class="text-danger">${errors.get("name")}</span>
            @endif
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">Birth Date</label>
        <div class="col-sm-10">
            <input class="form-control" type="date" name="birthDate"
                   max="${java.time.LocalDate.now().toString()}"
                   value="${form.getBirthDateDisplay()}"/>
            @if(errors.containsKey("birthDate"))
                <span class="text-danger">${errors.get("birthDate")}</span>
            @endif
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">Type</label>
        <div class="col-sm-10">
            <select class="form-control" name="type">
                @for(var t : petTypes)
                    @if(t.equals(form.getType()))
                        <option value="${t}" selected>${t}</option>
                    @else
                        <option value="${t}">${t}</option>
                    @endif
                @endfor
            </select>
            @if(errors.containsKey("type"))
                <span class="text-danger">${errors.get("type")}</span>
            @endif
        </div>
    </div>

</div>