# :star: FamousRepos :star:


# Short description:
FamousRepos is a simple app that will list the most starred repos in GitHub during the last 30 days. </br></br>

# Technologies used:
The app is written for Android in Java, and makes use of the Retrofit library for HTTP requests' purposes and Github Api calls. </br>
To parse the data received from the API, the converter of the Gson serialization library (which is part of Retrofit) was used. </br>
The app was developped in Android Studio to ease both the design and testing of the app. 

# GitHub Api: 
To fetch repos information from GitHub, its own [API](https://api.github.com/) was used. Data is returned in a Json format. </br>
An example of the link used is: **https://api.github.com/search/repositories?q=created:>2019-04-22&sort=stars&order=desc&page=2** </br>
Parameters are the starting date of the period (30 days before in this case), the sorting order, and the page to fetch (for pagination support).

# Preview:

![preview](/preview.png)




