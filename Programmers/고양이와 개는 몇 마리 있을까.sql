SELECT animal_type, count(animal_type)
from animal_ins
group by ANIMAL_TYPE
order by ANIMAL_TYPE;
