# garage-assessment
Create Park:
    URL: http://localhost:8080/garage/park
    RequestBody: {
                     "color": "Black",
                     "licensePlate": "54 sen 54",
                     "vehicleType": "Car"
                 }
    vehicleType = Car, Jeep, Truck

    response:{
                 "ticketId": "048530e0-079a-4c85-bf65-eecd15000ac1",
                 "licensePlate": "54 sen 54",
                 "color": "Black",
                 "yourSlots": "Your Slot/Slots: 0"
             }

Leave Park (Delete Mapping):
    URL: http://localhost:8080/garage/"ticket id from response"
         http://localhost:8080/garage/048530e0-079a-4c85-bf65-eecd15000ac1

Get Status:
    URL: http://localhost:8080/garage/status


If you want to see all case in console, you should try this metod.
Test
    URL: http://localhost:8080/garage/test

I am so busy in YKB so i can make better then this. For example i didn't have time for unit tests. If you want to see better then this assessment, just give me a feed back.
Thank you for the assessment.
