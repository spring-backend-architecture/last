@param dev.dmitriirussu.petclinic.web.application.query.view.form.VisitCreateForm visitCreateForm
@param dev.dmitriirussu.petclinic.web.presentation.command.form.VisitForm form
@param java.util.Map<String, String> errors
@param String error = ""
@param boolean admin = false

@template.layout.main(title = "New Visit", admin = admin, content = @`

    <h2>New Visit</h2>

    @if(!error.isEmpty())
        <div class="alert alert-danger">${error}</div>
    @endif

    <b>Pet</b>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Birth Date</th>
            <th>Type</th>
            <th>Owner</th>
        </tr>
        </thead>
        <tr>
            <td>${visitCreateForm.petName()}</td>
            <td>${visitCreateForm.birthDate().toString()}</td>
            <td>${visitCreateForm.type()}</td>
            <td>${visitCreateForm.ownerFirstName()} ${visitCreateForm.ownerLastName()}</td>
        </tr>
    </table>

    <form action="/visits/new" method="post">
        <input type="hidden" name="petId" value="${visitCreateForm.petId()}">
        <input type="hidden" name="ownerId" value="${visitCreateForm.ownerId()}">

        <div class="form-group has-feedback">

            <div class="form-group">
                <label class="col-sm-2 control-label">Date</label>
                <div class="col-sm-10">
                    <input class="form-control" type="date" name="visitDate"
                           min="${java.time.LocalDate.now().toString()}"
                           value="${form.getVisitDateDisplay()}"/>
                    @if(errors.containsKey("visitDate"))
                        <span class="text-danger">${errors.get("visitDate")}</span>
                    @endif
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Description</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="description"
                           value="${form.getDescription()}"/>
                    @if(errors.containsKey("description"))
                        <span class="text-danger">${errors.get("description")}</span>
                    @endif
                </div>
            </div>

        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button class="btn btn-primary" type="submit">Add Visit</button>
            </div>
        </div>

    </form>

    <br/>

    <b>Previous Visits</b>
    <table class="table table-striped">
        <tr>
            <th>Date</th>
            <th>Description</th>
        </tr>
        @for(var visit : visitCreateForm.visits())
            <tr>
                <td>${visit.visitDate().toString()}</td>
                <td>${visit.description()}</td>
            </tr>
        @endfor
    </table>

`)