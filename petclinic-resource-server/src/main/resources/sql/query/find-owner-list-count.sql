SELECT COUNT(*) FROM owners o
WHERE (CAST(:lastNamePrefix AS text) IS NULL
       OR LOWER(o.last_name) LIKE LOWER(:lastNamePrefix) || '%' ESCAPE '\')
