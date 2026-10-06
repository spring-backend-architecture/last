select p.id, p.name, p.birth_date, p.type,
       o.id as owner_id, o.first_name, o.last_name,
       (select array_agg(name order by name) from pet_types) as pet_types
from pets p
join owners o on o.id = p.owner_id
where p.id = :id