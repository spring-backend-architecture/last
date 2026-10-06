@import dev.dmitriirussu.petclinic.web.presentation.command.form.PetForm
@import dev.dmitriirussu.petclinic.web.application.query.view.form.PetCreateForm

@param PetCreateForm petCreateForm
@param PetForm form
@param java.util.Map<String, String> errors
@param String error = ""
@param boolean admin = false

@template.layout.main(title = "New Pet", admin = admin, content = @`

    <h2>New Pet</h2>

    @if(!error.isEmpty())
        <div class="alert alert-danger">${error}</div>
    @endif

    <form action="/pets/new" class="form-horizontal" method="post">
        @template.owner.form.pet-fields(
        ownerFirstName = petCreateForm.ownerFirstName(),
        ownerLastName = petCreateForm.ownerLastName(),
        petTypes = petCreateForm.petTypes(),
        form = form,
        errors = errors)

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button class="btn btn-primary" type="submit">Add Pet</button>
            </div>
        </div>
    </form>

    <a href="/owners/${form.getOwnerId()}" class="btn btn-default">Back to Owner</a>

`)