import { reactive } from 'vue';

export const weatherState = reactive({
  weatherData: null as WeatherResponse | null,
  setWeatherData(data: WeatherResponse) {
    this.weatherData = data;
  }
});