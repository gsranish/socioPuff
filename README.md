# socioPuff

to test application running or not 
curl --location 'localhost:9091/socioPuff/user/test'
for Register :
curl --location 'localhost:9091/socioPuff/user/register' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "anish",
    "lastName": "kumar",
    "password": "asdfg",
    "mobile": "9031062915",
    "email": "anish@gmail.com",
    "role": "BRAND",
    "terms" :true,
    "isLogin": false
}'

For Login:
curl --location 'localhost:9091/socioPuff/user/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email" : "anish@gmail.com",
    "password": "asdfg123",
     "isLogin": true
}'
