<template>
  <ion-page>
    <ion-content :fullscreen="true">
      <ion-card v-if="weatherData">
        <ion-card-header>
          <ion-card-title>{{ weatherData.name }}</ion-card-title>
          <ion-card-subtitle>{{ formattedDate(weatherData.current.dt) }}</ion-card-subtitle>
        </ion-card-header>
        <ion-card-content>
          <div class="info-grid">
            <div class="column">
              <p>Temperature: {{ weatherData.current.temp }}°F</p>
              <p>Clouds: {{ weatherData.current.clouds }}%</p>
              <p>Humidity: {{ weatherData.current.humidity }}%</p>
              <p>Pressure: {{ weatherData.current.pressure }} hPa</p>
              <p>Visibility: {{ weatherData.current.visibility }} meters</p>
            </div>
            <div class="column">
              <p>Feels Like: {{ weatherData.current.feels_like }}°F</p>
              <p>Dew Point: {{ weatherData.current.dew_point }}°F</p>
              <p>Wind Speed: {{ weatherData.current.wind_speed }} mi/h</p>
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

const weatherState = inject('weatherState') as { weatherData: WeatherResponse | null };

const weatherData = computed(() => weatherState.weatherData);

function formattedDate(timestamp: number): string {
  if (!weatherData.value) return '';
  const timezone = weatherData.value.timezone;
  const date = new Date(timestamp * 1000); // Convert from seconds to milliseconds
  return new Intl.DateTimeFormat('en-US', {
    year: 'numeric',
    month: 'long',
    day: 'numeric',
    hour: 'numeric',
    minute: 'numeric',
    second: 'numeric',
    timeZone: timezone,
    timeZoneName: 'short'
  }).format(date);
}

function windDirection(degree: number): string {
  const directions = ['N', 'NNE', 'NE', 'ENE', 'E', 'ESE', 'SE', 'SSE', 'S', 'SSW', 'SW', 'WSW', 'W', 'WNW', 'NW', 'NNW'];
  const index = Math.round(degree / 22.5) % 16;
  return directions[index];
}
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
