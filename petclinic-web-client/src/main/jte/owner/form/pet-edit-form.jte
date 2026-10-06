@import dev.dmitriirussu.petclinic.web.presentation.command.form.PetForm
@import dev.dmitriirussu.petclinic.web.application.query.view.form.PetEditForm

@param PetEditForm petEditForm
@param PetForm form
@param java.util.Map<String, String> errors
@param String error = ""
@param boolean admin = false

@template.layout.main(title = "Edit Pet", admin = admin, content = @`

    <h2>Edit Pet</h2>

    @if(!error.isEmpty())
        <div class="alert alert-danger">${error}</div>
    @endif

    <form action="/pets/${petEditForm.id()}/edit" class="form-horizontal" method="post">
        @template.owner.form.pet-fields(
        ownerFirstName = petEditForm.firstName(),
        ownerLastName = petEditForm.lastName(),
        petTypes = petEditForm.petTypes(),
        form = form,
        errors = errors)

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button class="btn btn-primary" type="submit">Update Pet</button>
            </div>
        </div>
    </form>

    <a href="/owners/${form.getOwnerId()}" class="btn btn-default">Back to Owner</a>

`)