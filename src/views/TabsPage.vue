<template>
  <ion-page>
    <ion-header>
      <ion-toolbar class="custom-header">
        <img src="@/assets/img/freightwise-logo_80w-264x71-copy.png" alt="Weather Icon" class="title-icon" width="160"/>
        <div class="tagline">
          <span class="line1">SHIPPING YOU TOMORROW'S WEATHER</span><br>
          <span class="line2">TODAY!</span>
        </div>
        <div class="divider"></div> <!-- Divider bar -->
      </ion-toolbar>
      <ion-content>
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
      </ion-content>
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
import { IonTabBar, IonTabButton, IonButton, IonContent, IonTabs, IonLabel, IonIcon, IonPage, IonHeader, IonRouterOutlet, IonSearchbar, IonToolbar } from '@ionic/vue';
import { search as searchIcon, time, calendar, partlySunny } from 'ionicons/icons';

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

<style scoped src="./TabsPage.css"></style>
