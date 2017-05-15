# labyrinth-webservice
Simple webservice that receive a labyrinth structure along with starting point and return labyrinth with escape path.

## Installation notes
To import and run this project please follow next steps:
1. Download or clone project in your workplace directory.
2. Run gradle task: __gradle clean build__ in project directory.
3. Open the project in your favorite IDE (It is a gradle project, so it should be easy to import it).
4. Run __LabyrinthWebserviceApplication.java__ class. It's a Spring Boot initialiser class.
5. Open Postman, SoapUI or any other tool that is able to make REST requests to our local web service.
6. Make a __POST__ request to __/labyrinth/escape__ with the following payload:
```javascript
{
	"startPoint":[2, 1],
	"labyrinth":[
		["O","O","O","O","O"],
		["O"," "," "," ","O"],
		["O"," ","O"," ","O"],
		["O"," ","O"," "," "],
		["O","O","O","O","O"]
	]
}
```
7. It should return following payload response:
```javascript
{"labyrinth": [
   "OOOOO",
   "O•••O",
   "O•O•O",
   "O O••",
   "OOOOO"
]}
```
8. If there is no existescape paths then it should return followin payload:
```javascript
{"errorMessage": "No escape paths exist!"}
```
