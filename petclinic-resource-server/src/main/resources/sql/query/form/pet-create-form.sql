select o.id as owner_id, o.first_name, o.last_name,
       (select array_agg(name order by name) from pet_types) as pet_types
from owners o
where o.id = :ownerId