CassandraSample
===============

CassandraSample

Use ZipDB;
create column family ZipLookUp with key_validation_class = 'UTF8Type' and comparator = 'UTF8Type' and column_metadata=[{column_name:ZIP_CODE, validation_class: UTF8Type, index_type:KEYS},
{column_name:CITY, validation_class: UTF8Type}
{column_name:STATE, validation_class: UTF8Type}
{column_name:COUNTRY, validation_class: UTF8Type}
{column_name:LATITUDE, validation_class: LongType}, 
{column_name:LONGITUDE, validation_class: LongType}];
