<template>
  <ion-app>
    <ion-header>
      <ion-toolbar class="custom-header">
        <img src="@/assets/img/freightwise-logo_80w-264x71-copy.png" alt="Weather Icon" class="title-icon" width="160"/>
        <div class="tagline">
          <span class="line1">SHIPPING YOU TOMORROW'S WEATHER --> <span class="line2">TODAY!</span></span>
        </div>
        <div class="divider"></div> <!-- Divider bar -->
        <div class="search-container">
          <ion-searchbar
            v-model="searchQuery"
            @keypress.enter="handleSearch"
            placeholder="Enter a city or zip"
            showCancelButton="focus"
            class="searchbar"
            :show-icon="false"
          ></ion-searchbar>
          <ion-button @click="handleSearch" class="search-button">
            <ion-icon :icon="searchIcon" />
          </ion-button>
        </div>
      </ion-toolbar>
    </ion-header>
    <ion-content>
      <ion-router-outlet />
    </ion-content>
  </ion-app>
</template>

<script setup lang="ts">
import { IonApp, IonButton, IonIcon, IonHeader, IonRouterOutlet, IonSearchbar, IonToolbar, IonContent } from '@ionic/vue';
import { search as searchIcon } from 'ionicons/icons';
import { weatherState } from './weatherStore';
import { ref } from 'vue';

const searchQuery = ref('');

const baseURL = process.env.NODE_ENV === 'production' 
  ? 'http://freightwise-weather-backend-env-1.eba-isjqjwpy.us-east-1.elasticbeanstalk.com' 
  : 'http://localhost:8080';

// Handle search input and update weather data based on search query
async function handleSearch() {
    const query = searchQuery.value.trim().toLowerCase();
    if (query) {
      console.log('Search query:', query); // Debugging line
      
      try {
        const response = await fetch(`${baseURL}/current-weather?location=${query}`);
        if (response.ok) {
          const data: WeatherResponse = await response.json();
          console.log('Weather data for', query, ':', JSON.parse(JSON.stringify(data)));
          weatherState.setWeatherData(data);
        } else {
          console.log('Location not found');
        }
      } catch (error) {
        console.error('Error fetching weather data:', error);
      }
    } else {
      console.log('Search input is empty or undefined');
    }
  }
</script>

<style scoped src="./AppVue.css"></style>
