interface Weather {
    id: number;
    main: string;
    description: string;
    icon: string;
  }
  
  interface CurrentWeather {
    dt: number;
    sunrise: number;
    sunset: number;
    temp: number;
    feelsLike: number;
    pressure: number;
    humidity: number;
    dewPoint: number;
    uvi: number;
    clouds: number;
    visibility: number;
    windSpeed: number;
    windDeg: number;
    weather: Weather[];
  }
  
  interface HourlyWeather {
    dt: number;
    temp: number;
    feelsLike: number;
    pressure: number;
    humidity: number;
    dewPoint: number;
    uvi: number;
    clouds: number;
    visibility: number;
    windSpeed: number;
    windDeg: number;
    weather: Weather[];
  }
  
  interface DailyTemperature {
    day: number;
    min: number;
    max: number;
    night: number;
    eve: number;
    morn: number;
  }
  
  interface DailyFeelsLike {
    day: number;
    night: number;
    eve: number;
    morn: number;
  }
  
  interface DailyWeather {
    dt: number;
    sunrise: number;
    sunset: number;
    temp: DailyTemperature;
    feelsLike: DailyFeelsLike;
    pressure: number;
    humidity: number;
    dewPoint: number;
    windSpeed: number;
    windDeg: number;
    weather: Weather[];
    clouds: number;
    pop: number;
    uvi: number;
  }
  
  interface Alert {
    senderName: string;
    event: string;
    start: number;
    end: number;
    description: string;
    tags: string[];
  }
  
  interface WeatherResponse {
    lat: number;
    lon: number;
    name: string;
    timezone: string;
    timezoneOffset: number;
    current: CurrentWeather;
    minutely: null; // Assuming minutely is always null based on the provided excerpt
    hourly: HourlyWeather[];
    daily: DailyWeather[];
    alerts: Alert[];
  }