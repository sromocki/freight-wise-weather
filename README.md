Frontend written in Typescript using the Ionic and Vue Frameworks

To deploy
```bash
npm run deploy
```

Backend is written in Springboot Java and hosted on elastic beanstalk.
Deployment is manual for now.  Build a new jar from gradle and then upload as a new application version in beanstalk.

This uses the OpenWeatherMap API for retrieving weather data.
https://openweathermap.org/api/one-call-3

This app is accesible from a statically hosted s3 bucket here:
http://freightwise-weather.s3-website-us-east-1.amazonaws.com

To run the frontend locally:
```bash
npm install
ionic serve
```
If you want your local to hit the prod backend simply do:
```bash
export NODE_ENV=production && ionic serve
```

To run the backend locally, you'll need to:
1.) Open the project in IntelliJ and run the gradle build

2.) Create a new run configuration for the app and set an environment variable for the 
OPENWEATHERMAP_API_KEY=

An API key can be obtained for free at https://openweathermap.org

3.) Run it!

