<template>
  <ion-page>
    <ion-content :fullscreen="true">
      <ion-list v-if="weatherData && weatherData.daily && weatherData.daily.length > 0">
        <ion-item-sliding v-for="(day, index) in weatherData.daily" :key="index">
          <ion-item>
            <ion-label>
              <div class="info-grid">
                <div class="column">
                  <h1>{{ formatDay(day.dt, weatherData.timezone) }}</h1>
                  <br/>
                  <p>{{ day.summary }}</p>
                </div>
                <div class="column">
                  <p>Precipitation: {{ day.pop }}%</p>
                  <br/>
                  <p>Clouds: {{ day.clouds }}%</p>
                  <br/>
                  <p>High: {{ day.temp.max }}°F</p>
                  <br/>
                  <p>Low: {{ day.temp.min }}°F</p>
                </div>
                <div class="column">
                  <h2>{{ day.weather[0].main }}</h2>
                  <img :src="'http://openweathermap.org/img/wn/' + day.weather[0].icon + '.png'" alt="Weather Icon" />
                  <p v-if="day.snow">Snow: {{ convertMmToInches(day.snow) }} in</p>
                  <p v-if="day.rain">Rain: {{ convertMmToInches(day.rain) }} in</p>
                </div>
              </div>
            </ion-label>
            <ion-button fill="clear" @click="toggleDetails(index)" slot="end">
              <ion-icon :icon="arrowDownCircle" class="large-icon"></ion-icon>
            </ion-button>
          </ion-item>
          <ion-item v-if="expandedIndex === index">
            <ion-label>
              <div class="info-grid">
                <div class="column">
                  <div class="details">
                    <p>Humidity: {{ day.humidity }}%</p>
                    <p>Pressure: {{ day.pressure }} hPa</p>
                    <p>Dew Point: {{ day.dew_point }}°F</p>
                    <p>Wind Speed: {{ day.wind_speed }} mi/h</p>
                    <p>Wind Gust: {{ day.wind_gust }} mi/h</p>
                    <p>Wind Direction: {{ windDirection(day.wind_deg) }} ({{ day.wind_deg }}°)</p>
                    <p>UV Index: {{ day.uvi }}</p>
                  </div>
                </div>
                <div class="column">
                  <div class="details">
                    <p>Sunrise: {{ formatTime(day.sunrise, weatherData.timezone) }}</p>
                    <p>Sunset: {{ formatTime(day.sunset, weatherData.timezone) }}</p>
                    <p>Moonrise: {{ formatTime(day.moonrise, weatherData.timezone) }}</p>
                    <p>Moonset: {{ formatTime(day.moonset, weatherData.timezone) }}</p>
                    <p>Moon Phase: {{ moonPhaseToString(day.moon_phase) }}</p>
                  </div>
                </div>
            </div>
            </ion-label>
          </ion-item>
        </ion-item-sliding>
      </ion-list>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonPage, IonContent, IonList, IonItem, IonItemSliding, IonLabel, IonIcon } from '@ionic/vue';
import { ref, computed, inject } from 'vue';
import { windDirection, convertMmToInches, formatDay, formatTime, moonPhaseToString } from '@/utils/weatherHelpers';
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