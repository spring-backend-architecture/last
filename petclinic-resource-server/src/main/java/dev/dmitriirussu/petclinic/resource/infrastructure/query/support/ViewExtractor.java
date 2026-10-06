package dev.dmitriirussu.petclinic.resource.infrastructure.query.support;

import dev.dmitriirussu.petclinic.resource.application.query.view.OwnerListView;
import dev.dmitriirussu.petclinic.resource.application.query.view.OwnerView;
import dev.dmitriirussu.petclinic.resource.application.query.view.PetView;
import dev.dmitriirussu.petclinic.resource.application.query.view.VisitView;
import dev.dmitriirussu.petclinic.resource.application.query.view.form.PetCreateForm;
import dev.dmitriirussu.petclinic.resource.application.query.view.form.PetEditForm;
import dev.dmitriirussu.petclinic.resource.application.query.view.form.VisitCreateForm;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public final class ViewExtractor {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static OwnerView getOwnerDetails(ResultSet rs, int rowNum) throws SQLException {
        try {
            List<PetView> pets = OBJECT_MAPPER.readValue(
                    rs.getString("pets_json"),
                    new TypeReference<List<PetView>>() {}
            );
            return new OwnerView(
                    rs.getString("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("street"),
                    rs.getString("city"),
                    rs.getString("telephone"),
                    pets
            );
        } catch (JacksonException e) {
            throw new SQLException("Failed to parse pets_json for owner " + rs.getString("id"), e);
        }
    }

    public static OwnerListView getOwnerWithPetNames(ResultSet rs, int rowNum) throws SQLException {
        String id        = rs.getString("id");
        String firstName = rs.getString("first_name");
        String lastName  = rs.getString("last_name");
        String street    = rs.getString("street");
        String city      = rs.getString("city");
        String telephone = rs.getString("telephone");

        Array sqlArray = rs.getArray("pet_names");
        List<String> petNames = sqlArray == null
                ? List.of()
                : Arrays.asList((String[]) sqlArray.getArray());

        return new OwnerListView(id, firstName, lastName, street, city, telephone, petNames);
    }

    public static PetCreateForm getPetCreateForm(ResultSet rs, int rowNum) throws SQLException {
        Array typesArray = rs.getArray("pet_types");
        List<String> types = Arrays.asList((String[]) typesArray.getArray());
        return new PetCreateForm(
                rs.getString("owner_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                types
        );
    }

    public static PetEditForm getPetEditForm(ResultSet rs, int rowNum) throws SQLException {
        return new PetEditForm(
                rs.getString("id"),
                rs.getString("name"),
                rs.getDate("birth_date").toLocalDate(),
                rs.getString("type"),
                rs.getString("owner_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                petTypesColumn(rs)
        );
    }

    public static VisitCreateForm getVisitCreateForm(ResultSet rs, int rowNum) throws SQLException {
        try {
            List<VisitView> visits = OBJECT_MAPPER.readValue(
                    rs.getString("visits_json"),
                    new TypeReference<List<VisitView>>() {}
            );
            return new VisitCreateForm(
                    rs.getString("pet_id"),
                    rs.getString("pet_name"),
                    rs.getDate("birth_date").toLocalDate(),
                    rs.getString("type"),
                    rs.getString("owner_id"),
                    rs.getString("owner_first_name"),
                    rs.getString("owner_last_name"),
                    visits
            );
        } catch (JacksonException e) {
            throw new SQLException("Failed to parse visits_json for pet " + rs.getString("pet_id"), e);
        }
    }

    private static List<String> petTypesColumn(ResultSet rs) throws SQLException {
        Array arr = rs.getArray("pet_types");
        return Arrays.asList((String[]) arr.getArray());
    }
}
