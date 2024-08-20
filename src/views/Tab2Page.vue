<template>
  <ion-page>
    <ion-content :fullscreen="true">
      <ion-list v-if="weatherData && weatherData.hourly && weatherData.hourly.length > 0">
        <ion-item-sliding v-for="(hour, index) in weatherData.hourly" :key="index">
          <ion-item>
            <ion-label>
              <div class="info-grid">
                <div class="column">
                  <h1>{{ formatHour(hour.dt, weatherData.timezone) }}</h1>
                  <p>Precipitation: {{ hour.pop }}%</p>
                  <p>Clouds: {{ hour.clouds }}%</p>
                  <p>Temperature: {{ hour.temp }}°F</p>
                  <p>Feels Like: {{ hour.feels_like }}°F</p>
                </div>
                <div class="column">
                  <h2>{{ weatherData.daily[0].weather[0].main }}</h2>
                  <img :src="'http://openweathermap.org/img/wn/' + weatherData.daily[0].weather[0].icon + '.png'" alt="Weather Icon" />
                  <p v-if="hour.snow">Snow: {{ convertMmToInches(hour.snow['1h']) }} in/h</p>
                  <p v-if="hour.rain">Rain: {{ convertMmToInches(hour.rain['1h']) }} in/h</p>
                </div>
              </div>
            </ion-label>
            <ion-button fill="clear" @click="toggleDetails(index)" slot="end">
              <ion-icon :icon="arrowDownCircle" class="large-icon"></ion-icon>
            </ion-button>
          </ion-item>
          <ion-item v-if="expandedIndex === index">
            <ion-label>
              <div class="details">
                <p>Humidity: {{ hour.humidity }}%</p>
                <p>Pressure: {{ hour.pressure }} hPa</p>
                <p>Dew Point: {{ hour.dew_point }}°F</p>
                <p>Visibility: {{ visibilityInKm(hour.visibility) }} km</p>
                <p>Wind Speed: {{ hour.wind_speed }} mi/h</p>
                <p>Wind Gust: {{ hour.wind_gust }} mi/h</p>
                <p>Wind Direction: {{ windDirection(hour.wind_deg) }} ({{ hour.wind_deg }}°)</p>
                <p>UV Index: {{ hour.uvi }}</p>
              </div>
            </ion-label>
          </ion-item>
        </ion-item-sliding>
      </ion-list>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonPage, IonContent, IonList, IonItem, IonItemSliding, IonItemOptions, IonItemOption, IonLabel, IonIcon } from '@ionic/vue';
import { ref, computed, inject } from 'vue';
import { windDirection, visibilityInKm, convertMmToInches, formatHour } from '@/utils/weatherHelpers';
import { arrowDownCircle } from 'ionicons/icons';

const weatherState = inject('weatherState') as { weatherData: WeatherResponse | null };

const weatherData = computed(() => weatherState.weatherData);
const expandedIndex = ref<number | null>(null);

const toggleDetails = (index: number) => {
  expandedIndex.value = expandedIndex.value === index ? null : index;
};
</script>

<style scoped>
ion-item {
  --padding-start: 10px;
  --inner-padding-end: 10px;
}

.info-grid {
  display: flex;
  justify-content: space-between;
}

.column {
  flex: 1;
  padding: 0 10px;
}

.column h1 {
  font-size: 1.2em;
  margin: 0;
}

.column p {
  margin: 0;
  font-size: 0.9em;
}

.details {
  padding: 10px;
}

.details p {
  margin: 5px 0;
  font-size: 0.9em;
}

.large-icon {
  font-size: 2em;
}
</style>