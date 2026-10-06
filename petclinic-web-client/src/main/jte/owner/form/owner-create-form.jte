@import java.util.Map
@import dev.dmitriirussu.petclinic.web.presentation.command.form.OwnerForm

@param OwnerForm form
@param Map<String, String> errors
@param String error = ""
@param boolean admin = false

@template.layout.main(title = "New Owner", admin = admin, content = @`

    <h2>New Owner</h2>

    @if(!error.isEmpty())
        <div class="alert alert-danger">${error}</div>
    @endif

    <form action="/owners/new" class="form-horizontal" id="add-owner-form" method="post">
        @template.owner.form.owner-fields(form = form, errors = errors)

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button class="btn btn-primary" type="submit">Add Owner</button>
            </div>
        </div>
    </form>

`)