select outs.ANIMAL_ID, outs.name
from animal_outs outs
left join animal_ins ins on ins.ANIMAL_ID = outs.ANIMAL_ID
where ins.animal_id is null
order by outs.animal_id asc;
