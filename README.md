# TVShow App

![App Logo](link_to_your_logo.png)

## Overview

This Android app allows users to browse a list of available TV shows, view show details, explore episodes, and add shows to their wishlist using the MVVM architecture. The app also utilizes Room Database for wishlist management.

## Features

- **Show List**: Browse a comprehensive list of available TV shows.
- **Show Details**: View detailed information about a specific TV show, including its name and additional details.
- **Visit Website**: Navigate to the official website of the TV show for more information.
- **Episode List**: Access a bottom dialog listing all available episodes for a specific show.
- **Wishlist Management**: Add TV shows to your wishlist using Room Database.

## Screenshots

![Screenshot 1](link_to_screenshot_1.png)
![Screenshot 2](link_to_screenshot_2.png)

## Getting Started

To get started with the app, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/tvshow-app.git
   
2. Open the project in Android Studio.

3. Build and run the app on an emulator or a physical device.

## API Integration

This app utilizes the [Episodate API](https://www.episodate.com/api) to fetch information about TV shows and their episodes. The API does not require an API key for access.

## API Documentation

For more details about the Episodate API and its endpoints, refer to the official Episodate [API Documentation](https://www.episodate.com/api).

## Usage

- The app fetches data from the Episodate API to populate the list of available TV shows, retrieve show details, and obtain information about episodes. The integration with the API is handled through Retrofit.

- Please note that the Episodate API may have usage limitations, so it's recommended to review their documentation for any specific guidelines or terms of use.

- If you encounter any issues related to API changes or updates, please check the official Episodate API documentation for the latest information.

## Dependencies

This project leverages several third-party libraries to enhance its functionality. Here's a list of the key dependencies along with their versions:

- [Retrofit](https://square.github.io/retrofit/) (Version 2.9.0): A type-safe HTTP client for Android and Java that simplifies API consumption.
- [Picasso](https://square.github.io/picasso/) (Version 2.71828): A powerful image downloading and caching library for Android.
- [Lifecycle Extensions](https://developer.android.com/jetpack/androidx/releases/lifecycle) (Version 2.2.0): AndroidX library providing lifecycle-aware components.
- [Room Database](https://developer.android.com/jetpack/androidx/releases/room) (Version 2.6.1): Persistence library providing an abstraction layer over SQLite to manage offline data.
- [RxJava](https://github.com/ReactiveX/RxJava) (Version 2.2.21): A library for composing asynchronous and event-based programs using observable sequences.
- [RxAndroid](https://github.com/ReactiveX/RxAndroid) (Version 2.1.1): Android specific bindings for RxJava.
- [Rounded Image View](https://github.com/vinc3m1/RoundedImageView) (Version 2.3.0): A custom ImageView that supports rounded corners.

## Contributing
If you'd like to contribute to the project, please follow these steps:

1. Fork the repository.
2. Create a new branch:

   ```bash
   git checkout -b feature/new-feature

3. Make your changes and commit them:

   ```bash
   git commit -m 'Add new feature'

4. Push your changes to the branch:

   ```bash
   git push origin feature/new-feature

## License

This project is licensed under the [MIT License](https://www.mit.edu/~amini/LICENSE.md).
