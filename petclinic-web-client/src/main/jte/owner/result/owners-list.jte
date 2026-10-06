@import dev.dmitriirussu.petclinic.web.application.query.PageResult
@import dev.dmitriirussu.petclinic.web.application.query.view.OwnerListView

@param PageResult<OwnerListView> result
@param int currentPage
@param String lastName
@param boolean admin = false

@template.layout.main(title = "Owners", admin = admin, content = @`

    <h2>Owners</h2>

    @if(result.isEmpty())
        <p>No owners found.</p>
    @else
        <table id="owners" class="table table-striped">
            <thead>
            <tr>
                <th style="width: 150px;">Name</th>
                <th style="width: 200px;">Address</th>
                <th>City</th>
                <th style="width: 120px;">Telephone</th>
                <th>Pets</th>
            </tr>
            </thead>
            <tbody>
            @for(var o : result.content())
                <tr>
                    <td><a href="/owners/${o.id()}">${o.firstName()} ${o.lastName()}</a></td>
                    <td>${o.street()}</td>
                    <td>${o.city()}</td>
                    <td>${o.telephone()}</td>
                    <td>${String.join(", ", o.petNames())}</td>
                </tr>
            @endfor
            </tbody>
        </table>

        @if(result.totalPages() > 1)
            <div>
                <span>Pages:</span>
                <span>[</span>
                @for(int i = 1; i <= result.totalPages(); i++)
                    @if(currentPage == i)
                        <span>${i}</span>
                    @else
                        <a href="/owners/search?page=${i}&lastName=${lastName}">${i}</a>
                    @endif
                @endfor
                <span>]&nbsp;</span>

                @if(currentPage > 1)
                    <a href="/owners/search?page=1&lastName=${lastName}" title="first" class="fa fa-fast-backward"></a>
                    <a href="/owners/search?page=${currentPage - 1}&lastName=${lastName}" title="previous" class="fa fa-step-backward"></a>
                @else
                    <span title="first" class="fa fa-fast-backward"></span>
                    <span title="previous" class="fa fa-step-backward"></span>
                @endif

                @if(currentPage < result.totalPages())
                    <a href="/owners/search?page=${currentPage + 1}&lastName=${lastName}" title="next" class="fa fa-step-forward"></a>
                    <a href="/owners/search?page=${result.totalPages()}&lastName=${lastName}" title="last" class="fa fa-fast-forward"></a>
                @else
                    <span title="next" class="fa fa-step-forward"></span>
                    <span title="last" class="fa fa-fast-forward"></span>
                @endif
            </div>
        @endif
    @endif

`)