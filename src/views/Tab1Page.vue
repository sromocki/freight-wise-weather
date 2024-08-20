<template>
  <ion-page>
    <ion-content :fullscreen="true">

      <ion-card v-if="weatherData && weatherData.daily && weatherData.daily.length > 0">
        <ion-card-header>
          <div class="info-grid">
            <div class="column">
              <ion-card-title>Forecast for Today: {{ formattedDateOnly(weatherData.daily[0].dt, weatherData.timezone) }}</ion-card-title>
              <ion-card-subtitle>{{ weatherData.daily[0].summary }}</ion-card-subtitle>
            </div>
            <div class="column">
              <ion-card-title>{{ weatherData.daily[0].weather[0].main }}</ion-card-title>
              <ion-card-subtitle v-if="shouldShowDescription">{{ capitalizeWords(weatherData.daily[0].weather[0].description) }}</ion-card-subtitle>
              <img :src="'http://openweathermap.org/img/wn/' + weatherData.daily[0].weather[0].icon + '@4x.png'" alt="Weather Icon" />
            </div>
          </div>
          
        </ion-card-header>
        <ion-card-content>
          <div class="info-grid">
            <div class="column">
              <p>Temperature: {{ weatherData.daily[0].temp.day }}°F</p>
              <p>High: {{ weatherData.daily[0].temp.max }}°F</p>
              <p>Low: {{ weatherData.daily[0].temp.min }}°F</p>
              <p>Humidity: {{ weatherData.daily[0].humidity }}%</p>
              <p>Pressure: {{ weatherData.daily[0].pressure }} hPa</p>
              <p>Wind Speed: {{ weatherData.daily[0].wind_speed }} mi/h</p>
              <p>Wind Gust: {{ weatherData.daily[0].wind_gust }} mi/h</p>
              <p>Wind Direction: {{ windDirection(weatherData.daily[0].wind_deg) }} ({{ weatherData.daily[0].wind_deg }}°)</p>
              <p>UV Index: {{ weatherData.daily[0].uvi }}</p>
            </div>
            <div class="column">
              <p v-if="weatherData.daily[0].snow">Snow: {{ convertMmToInches(weatherData.daily[0].snow) }} in</p>
              <p v-if="weatherData.daily[0].rain">Rain: {{ convertMmToInches(weatherData.daily[0].rain) }} in</p>
              <p>Clouds: {{ weatherData.daily[0].clouds }}%</p>
              <p>Dew Point: {{ weatherData.daily[0].dew_point }}°F</p>
              <p>Sunrise: {{ formatTime(weatherData.daily[0].sunrise, weatherData.timezone) }}</p>
              <p>Sunset: {{ formatTime(weatherData.daily[0].sunset, weatherData.timezone) }}</p>
              <p>Moonrise: {{ formatTime(weatherData.daily[0].moonrise, weatherData.timezone) }}</p>
              <p>Moonset: {{ formatTime(weatherData.daily[0].moonset, weatherData.timezone) }}</p>
              <p>Moon Phase: {{ moonPhaseToString(weatherData.daily[0].moon_phase) }}</p>
            </div>
          </div>
        </ion-card-content>
      </ion-card>

      <ion-card v-if="weatherData">
        <ion-card-header>
          <div class="info-grid">
            <div class="column">
              <ion-card-title>Currently in {{ weatherData.name }}</ion-card-title>
              <ion-card-subtitle>{{ formattedDate(weatherData.current.dt, weatherData.timezone) }}</ion-card-subtitle>
            </div>
            <div class="column">
              <ion-card-title>{{ weatherData.current.weather[0].main }}</ion-card-title>
              <ion-card-subtitle v-if="shouldShowDescription">{{ capitalizeWords(weatherData.current.weather[0].description) }}</ion-card-subtitle>
              <img :src="'http://openweathermap.org/img/wn/' + weatherData.current.weather[0].icon + '@4x.png'" alt="Weather Icon" />
            </div>
          </div>
        </ion-card-header>
        <ion-card-content>
          <div class="info-grid">
            <div class="column">
              <p>Temperature: {{ weatherData.current.temp }}°F</p>
              <p>Feels Like: {{ weatherData.current.feels_like }}°F</p>
              <p>Humidity: {{ weatherData.current.humidity }}%</p>
              <p>Pressure: {{ weatherData.current.pressure }} hPa</p>
              <p>Visibility: {{ visibilityInKm(weatherData.current.visibility) }} km</p>
            </div>
            <div class="column">
              <p v-if="weatherData.current.snow">Snow: {{ convertMmToInches(weatherData.current.snow['1h']) }} in/h</p>
              <p v-if="weatherData.current.rain">Rain: {{ convertMmToInches(weatherData.current.rain['1h']) }} in/h</p>
              <p>Clouds: {{ weatherData.current.clouds }}%</p>
              <p>Dew Point: {{ weatherData.current.dew_point }}°F</p>
              <p>Wind Speed: {{ weatherData.current.wind_speed }} mi/h</p>
              <p>Wind Gust: {{ weatherData.current.wind_gust }} mi/h</p>
              <p>Wind Direction: {{windDirection(weatherData.current.wind_deg) }} ({{ weatherData.current.wind_deg}}°) </p>
              <p>UV Index: {{ weatherData.current.uvi }}</p>
            </div>
          </div>
        </ion-card-content>
      </ion-card>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonPage, IonContent, IonCard, IonCardContent, IonCardHeader, IonCardTitle, IonCardSubtitle } from '@ionic/vue';
import { computed, inject } from 'vue';
import { windDirection, visibilityInKm, convertMmToInches, moonPhaseToString, capitalizeWords, formattedDate, formatTime, formattedDateOnly } from '@/utils/weatherHelpers';

const weatherState = inject('weatherState') as { weatherData: WeatherResponse | null };

const weatherData = computed(() => weatherState.weatherData);

const shouldShowDescription = computed(() => {
  if (!weatherData.value) return false;
  const main = weatherData.value.current.weather[0].main;
  const description = weatherData.value.current.weather[0].description;
  return main.toLowerCase() !== description.toLowerCase();
});
</script>

<style scoped>
ion-page {
  display: flex;
  flex-direction: column;
  height: 100%;
}

ion-content {
  flex: 1;
  overflow-y: auto;
  --padding-top: var(--ion-safe-area-top);
}

ion-card {
  margin: 20px;
}

ion-card-title {
  font-size: 1.5em;
  font-weight: bold;
}

ion-card-subtitle {
  font-size: 1.2em;
  color: #666;
}

ion-card-content p {
  margin: 5px 0;
}

.info-grid {
  display: flex;
  justify-content: space-between;
}

.column {
  flex: 1;
  padding: 0 10px;
}

.column p {
  margin: 0;
}
</style>
