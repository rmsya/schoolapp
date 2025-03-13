## Initialized
Init container for postgreSQL
```
docker-compose up -d
```

Test connect to database
```
docker exec -it postgres-container psql -U postgres -d academic_db
```

Create new database for each services
```
CREATE DATABASE payment_db;
CREATE DATABASE member_db;
```

## How to run
Run service
- member-service
- payment-service


## How to test

## Create Student

Endpoint
```
POST http://localhost:8081/api/v1/student/create
```

Header
```
Content-Type: application/json
```

RequestBody
```
{
    "fullName":"Rahma Isnaini M",
    "gender": "Female",
    "grade": "2",
    "birthDate" : "1994-12-12",
    "parentName" : "Masnadi",
    "parentPhone" : "08129646374"
}
```

## Get Student List

Endpoint
```
GET http://localhost:8081/api/v1/student/get-list
```

Header
```
Content-Type: application/json
```

RequestBody
```
{
    "fullName" : "Rahma"
}
```

## Get Student Detail

Endpoint
```
GET http://localhost:8081/api/v1/student/get-detail?studentId=ST_XXXX
```

## Get Student Billing

Endpoint
```
GET http://localhost:8081/api/v1/student-fee/get-billing?studentId=ST_1741800519933&billingType=MONTHLY
```


## Student Fee Payment

Endpoint
```
POST http://localhost:8081/api/v1/student-fee/pay
```

Header
```
Content-Type: application/json
```

RequestBody
```
{
    "studentId" : "ST_XXXXX",
    "year" : "2025",
    "month" : "8",
    "type" : "MONTHLY",
    "paymentMethod" : "BANK_TRANSFER",
    "amount" : "100000"
}
```






