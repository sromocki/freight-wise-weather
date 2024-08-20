Frontend written in Typescript using the Ionic and Vue Frameworks

To deploy
```bash
npm run deploy
```

Backend is written in Springboot Java and hosted on elastic beanstalk.
Deployment is manual for now.  Build a new jar from gradle and then upload as a new application version in beanstalk.

This uses the OpenWeatherMap API for retrieving weather data.
https://openweathermap.org/api/one-call-3
