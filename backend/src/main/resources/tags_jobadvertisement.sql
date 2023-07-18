INSERT IGNORE INTO jobadvertisement_tags (job_advertisement_id, tags_id)
select 1 as "job_advertisement_id", id as "tags_id" from tag where name in('docker','c#','azure','dotnet','cloud');

INSERT IGNORE INTO jobadvertisement_tags (job_advertisement_id, tags_id)
select 2 as "job_advertisement_id", id as "tags_id" from tag where name in('java', 'cloud')
union all
select  2 as "job_advertisement_id", id as "tags_id" from tag where name like 'aws-%' order by tags_id limit 10;


