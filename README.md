# profile-service-redis

This service is responsible for profile management (CRUD operations) with Redis as database.<br/>

Flow of the project
![image](https://user-images.githubusercontent.com/37982804/151365118-d119fee9-8c4e-43d2-afe9-74f6cc62b394.png)
<br/>

Steps to run this project<br/>
1. Start redis-server<br/>
2. Run the project as Spring Boot App<br/>
3. Perform CRUD operation in Postman (Please note that i've specified the port no. as 8082)<br/>
Example:<br/>
a. POST a profile
![image](https://user-images.githubusercontent.com/37982804/151351745-46ab4879-2d50-4762-af3c-dd403f0d6b09.png)
<br/>
b. GET profile by id
GET http://localhost:8082/api/profiles/2
<br/>
4. You can also fetch the data using redis-cli<br/>
a. Fetch all keys
![image](https://user-images.githubusercontent.com/37982804/151352418-73842fae-b938-42c0-9eac-30291c5bbf04.png)
<br/>
b. Fetch value from key
![redis-db-snap](https://user-images.githubusercontent.com/37982804/151353914-a72049f2-ce73-4e3b-8b80-677591005c14.png)
<br/>
I dont know why the key-value pairs are stored in such order, I'll update the information in future.
<br/>
