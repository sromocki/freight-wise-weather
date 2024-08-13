<template>
  <ion-page>
    <ion-header>
      <ion-toolbar class="custom-header">
        <img src="@/assets/img/freightwise-logo_80w-264x71-copy.png" alt="Weather Icon" class="title-icon" />
        <div class="tagline">
          <span class="line1">SHIPPING YOU TOMORROW'S WEATHER</span><br>
          <span class="line2">TODAY!</span>
        </div>
        <div class="divider"></div> <!-- Divider bar -->
        <ion-searchbar
          v-model="searchQuery"
          @ionInput="handleSearch"
          placeholder="Weather Location"
          showCancelButton="focus"
          class="searchbar"
        ></ion-searchbar>
      </ion-toolbar>
    </ion-header>
    <ion-tabs>
      <ion-router-outlet></ion-router-outlet>
      <ion-tab-bar slot="bottom">
        <ion-tab-button tab="tab1" href="/tabs/tab1">
          <ion-icon aria-hidden="true" :icon="partlySunny" />
          <ion-label>Current Weather</ion-label>
        </ion-tab-button>

        <ion-tab-button tab="tab2" href="/tabs/tab2">
          <ion-icon aria-hidden="true" :icon="time" />
          <ion-label>Hourly</ion-label>
        </ion-tab-button>

        <ion-tab-button tab="tab3" href="/tabs/tab3">
          <ion-icon aria-hidden="true" :icon="calendar" />
          <ion-label>4 Day Forecast</ion-label>
        </ion-tab-button>
      </ion-tab-bar>
    </ion-tabs>
  </ion-page>
</template>

<script setup lang="ts">
import { IonTabBar, IonTabButton, IonTabs, IonLabel, IonIcon, IonPage, IonRouterOutlet } from '@ionic/vue';
import { time, calendar, partlySunny } from 'ionicons/icons';

import { ref } from 'vue';

// Sample weather data
const weatherData = ref({
  location: 'New York',
  temperature: 77,
  condition: 'Sunny',
  humidity: 60,
  windSpeed: 15,
});

const locationWeatherData = {
  'new york': {
    location: 'New York',
    temperature: 77, // Converted to Fahrenheit
    condition: 'Sunny',
    humidity: 60,
    windSpeed: 15,
  },
  'los angeles': {
    location: 'Los Angeles',
    temperature: 82, // Converted to Fahrenheit
    condition: 'Partly Cloudy',
    humidity: 55,
    windSpeed: 10,
  },
  london: {
    location: 'London',
    temperature: 64, // Converted to Fahrenheit
    condition: 'Rainy',
    humidity: 70,
    windSpeed: 20,
  },
  'san francisco': {
    location: 'San Francisco',
    temperature: 68, // Converted to Fahrenheit
    condition: 'Foggy',
    humidity: 80,
    windSpeed: 12,
  },
  tokyo: {
    location: 'Tokyo',
    temperature: 86, // Converted to Fahrenheit
    condition: 'Hot and Humid',
    humidity: 65,
    windSpeed: 5,
  },
};

const searchQuery = ref('');

// Handle search input and update weather data based on search query
function handleSearch(event: Event) {
  const target = event.target as HTMLIonSearchbarElement;
  if (target && target.value) {
    const query = target.value.toLowerCase();
    
    console.log('Search query:', query); // Debugging line
    
    if (query in locationWeatherData) {
      weatherData.value = locationWeatherData[query as keyof typeof locationWeatherData];
      console.log('Weather data for', weatherData.value.location, ':', JSON.parse(JSON.stringify(weatherData.value)));
    } else {
      console.log('Location not found');
    }
  } else {
    console.log('Search input is empty or undefined');
  }
}
</script>

<style scoped>
.tagline {
  font-family: 'Montserrat', sans-serif !important; /* or another bold, geometric font */
  float: right;
  text-align: center;
  padding-top: 20px;
  padding-right: 10px;
}

.line1 {
  color: #1F3B87; /* Dark Blue */
  font-size: 1em;
  font-weight: bold;
}

.line2 {
  color: #117A7B; /* Teal */
  font-size: 1.2em;
  font-weight: extra-bold;
}

ion-toolbar.custom-header {
  --background: #ffffff !important;
  color: #000000 !important;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.divider {
  width: 100%; /* Thickness of the divider */
  height: 1px; /* Height of the divider */
  background-color: #000000; /* Color of the divider */
}

ion-searchbar.searchbar {
  width: 100%; /* Adjust width as needed */
  --background: #ffffff !important;
  color: #000000 !important;
}

::v-deep .searchbar-input {
  font-size: 1.4em !important; /* Ensure this overrides any default styles */
  font-weight: bold !important;
}

.ion-page {
  --background: #ffffff !important;
}
</style>
