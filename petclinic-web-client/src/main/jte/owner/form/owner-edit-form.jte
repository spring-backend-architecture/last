@import java.util.Map
@import dev.dmitriirussu.petclinic.web.presentation.command.form.OwnerForm

@param OwnerForm form
@param String ownerId
@param Map<String, String> errors
@param String error = ""
@param boolean admin = false

@template.layout.main(title = "Edit Owner", admin = admin,, content = @`

    <h2>Edit Owner</h2>

    @if(!error.isEmpty())
        <div class="alert alert-danger">${error}</div>
    @endif

    <form action="/owners/${ownerId}/edit" class="form-horizontal" id="add-owner-form" method="post">
        @template.owner.form.owner-fields(form = form, errors = errors)

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button class="btn btn-primary" type="submit">Update Owner</button>
            </div>
        </div>
    </form>

    <hr/>
    <a href="/owners/${ownerId}">Back to owner</a>
`)