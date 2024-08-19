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
    feels_like: number;
    pressure: number;
    humidity: number;
    dew_point: number;
    uvi: number;
    clouds: number;
    visibility: number;
    wind_speed: number;
    wind_deg: number;
    weather: Weather[];
  }
  
  interface HourlyWeather {
    dt: number;
    temp: number;
    feels_like: number;
    pressure: number;
    humidity: number;
    dew_point: number;
    uvi: number;
    clouds: number;
    visibility: number;
    wind_speed: number;
    wind_deg: number;
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
    feels_like: DailyFeelsLike;
    pressure: number;
    humidity: number;
    dew_point: number;
    wind_speed: number;
    wind_deg: number;
    weather: Weather[];
    clouds: number;
    pop: number;
    uvi: number;
  }
  
  interface Alert {
    sender_name: string;
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
    timezone_offset: number;
    current: CurrentWeather;
    minutely: null; // Assuming minutely is always null based on the provided excerpt
    hourly: HourlyWeather[];
    daily: DailyWeather[];
    alerts: Alert[];
  }