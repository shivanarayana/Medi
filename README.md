# Medicine Inventory
Steps To upload csv file AND HIT THE API

SELECT POST AND HIT ENDPOINT http://localhost:8080/uploadCSV

GOTO BODY AND SELECT FORM DATA

ENTER "file" IN key and change drop down as file instead of text and attach the file by selecting
![inventory upload csv](https://user-images.githubusercontent.com/10083536/198844425-42df14f3-255e-4d6b-82e8-daeb03b7d0f7.jpg)

<br />
**Records will be saved in the H2 DATABASE**

STEP 2: Data saved can be looked here <br />
http://localhost:8080/h2-console/login.do?
<br />
url = jdbc:h2:mem:medi
un: shiva
pwd: password
<br />

Select GET
http://localhost:8080/hasStock?supplierNameOrId=INDOCO
Select POST
Set the Body type to raw and add header Content-Type: application/json
http://localhost:8080/didNotExpire
iN BODY select raw and select text
["GLAXOSMITHKLINE(INGENIUM)","BIOSYS HEALTH CARE","BD SYRINGES  (MANTRI PHARMA)","CIPLA(RESP 2)"]

![didNotExpire](https://user-images.githubusercontent.com/10083536/198891670-ec1b4f73-c772-4894-a76a-5a93e2eabda2.jpg)


![supplierIdOrNameInStock](https://user-images.githubusercontent.com/10083536/198891659-b27db9f2-7ec2-4d17-8f25-1e5f6c252f05.jpg)
