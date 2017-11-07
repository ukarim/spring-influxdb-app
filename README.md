#### How to build and run

```
> gradlew build
> docker-compose up
```
SpringBoot app will be available on port 8080 and InfluxDB on port 8086

#### How to check

###### Store in InfluxDB
Send json of the following structure
```
{
    "value": "100"
}
```
to http://localhost:8080 by POST method (maybe using Postman or any other do you prefer)

!!! Send json with proper media type to not obtain 415

###### Get last inserted

Available on http://localhost:8080
