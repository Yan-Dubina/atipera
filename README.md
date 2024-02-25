Application for search github repository by user.

**_Before start application you need add generated token from github(replace in application.properties %TOKEN_FROM_GIT_HUB%)_**

Task haven't precision for using external library for realization this task, and I have two solutions

**First one is using a third part library** ( you can find link for this library on official page https://developer.github.com/v3)
For using this solution you need send GET request with username as path variable  on endpoint http://localhost:8080/library/;

**Template of request**:
curl -X GET --location "http://localhost:8080/library/{{username}}"

**Second one is using HttpClient** for sending requests on github endpoints and Jackson for mapping github responses on java objects.

For using this solution you need send GET request with username as path variable on endpoint http://localhost:8080/cleint/;

**Template of request:**
curl -X GET --location "http://localhost:8080/client/{{username}}"