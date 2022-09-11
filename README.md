# Task2_APIAutomation
API Automation Using Rest Assured

How to Execute :
- Download Repository
- Open project on eclipse as a existing maven project
- Run AppTest Class as a TestNG Class

Output:

[RemoteTestNG] detected TestNG version 7.4.0

Test case Name: Fetch the list of available employee’s details .


Response Body: 

{"page":1,"per_page":6,"total":12,"total_pages":2,"data":
[{"id":1,"email":"george.bluth@reqres.in","first_name":"George","last_name":"Bluth","avatar":"https://reqres.in/img/faces/1-image.jpg"},
{"id":2,"email":"janet.weaver@reqres.in","first_name":"Janet","last_name":"Weaver","avatar":"https://reqres.in/img/faces/2-image.jpg"},
{"id":3,"email":"emma.wong@reqres.in","first_name":"Emma","last_name":"Wong","avatar":"https://reqres.in/img/faces/3-image.jpg"},
{"id":4,"email":"eve.holt@reqres.in","first_name":"Eve","last_name":"Holt","avatar":"https://reqres.in/img/faces/4-image.jpg"},
{"id":5,"email":"charles.morris@reqres.in","first_name":"Charles","last_name":"Morris","avatar":"https://reqres.in/img/faces/5-image.jpg"},
{"id":6,"email":"tracey.ramos@reqres.in","first_name":"Tracey","last_name":"Ramos","avatar":"https://reqres.in/img/faces/6-image.jpg"}],
"support":{"url":"https://reqres.in/#support-heading","text":"To keep ReqRes free, contributions towards server costs are appreciated!"}}

Response Code: 200


Test case Name: Search the employee using the Id but that employee detail is not available, validate the response.

Response Body: 

{}

Response Code: 404


Test case Name: Create a one employee details and check whether it employee is created

Response Body: 

{"id":"354","createdAt":"2022-09-11T13:50:32.835Z"}

Response Code: 201

User Created, ID:354


Test case Name: Update the Job value for the created employee using employee Id and check the update happen for the employee.

Response Body: 

{"updatedAt":"2022-09-11T13:50:34.703Z"}

Response Code: 200

User Update


Test case Name: Delete the employee using employee Id and check the employee details are deleted successfully.

Response Body: 


Response Code: 204

User Deleted

PASSED: getListOfAvailableEmployee

PASSED: deleteEmployee

PASSED: updateJobValue

PASSED: CreateEmployee

PASSED: getEmployeeByID



===============================================
    Default test
    Tests run: 5, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 5, Passes: 5, Failures: 0, Skips: 0
===============================================

